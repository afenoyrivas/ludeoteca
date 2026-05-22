package fenoyagostina.ludeoteca.service;

import fenoyagostina.ludeoteca.dto.request.ReservaRequestDto;
import fenoyagostina.ludeoteca.dto.response.ReservaResponseDto;
import fenoyagostina.ludeoteca.exception.EntidadInactivaException;
import fenoyagostina.ludeoteca.exception.EstadoInvalidoException;
import fenoyagostina.ludeoteca.exception.StockInsuficienteException;
import fenoyagostina.ludeoteca.mapper.ReservaMapper;
import fenoyagostina.ludeoteca.model.EstadoReserva;
import fenoyagostina.ludeoteca.model.JuegoEntity;
import fenoyagostina.ludeoteca.model.ReservaEntity;
import fenoyagostina.ludeoteca.model.SocioEntity;
import fenoyagostina.ludeoteca.repository.ReservaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    private final ReservaRepository repository;
    private final ReservaMapper mapper;
    private final SocioService socioService;
    public final JuegoService juegoService;

    public ReservaService(ReservaRepository repository, ReservaMapper mapper,
                          SocioService socioService, JuegoService juegoService) {
        this.repository = repository;
        this.mapper = mapper;
        this.socioService=socioService;
        this.juegoService=juegoService;
    }

    public List<ReservaResponseDto> findAll(EstadoReserva estado){
        if(estado!=null){
            return repository.findByEstado(estado).stream()
                    .map(mapper::toDto)
                    .collect(Collectors.toList());
        }
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public List<ReservaResponseDto> findByIdSocio(UUID idSocio){
        return repository.findBySocio_IdPublico(idSocio).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    ReservaEntity findByIdPublico(UUID idPublico){
        return repository.findByIdPublico(idPublico)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public ReservaResponseDto save(ReservaRequestDto request){
        SocioEntity socio = socioService.findByIdPublico(request.getIdSocio());
        JuegoEntity juego = juegoService.findByIdPublico(request.getIdJuego());

        if(!socio.getActivo()){
            throw new EntidadInactivaException("El socio esta inactivo");
        }
        if(!juego.getActivo()){
            throw new EntidadInactivaException("El juego esta inactivo");
        }

        if(juego.getStockDisponible()<request.getCantidad()){
            throw new StockInsuficienteException();
        }

        ReservaEntity reserva = mapper.toEntity(request);
        reserva.setSocio(socio);
        reserva.setJuego(juego);

        return mapper.toDto(repository.save(reserva));
    }

    @Transactional
    public ReservaResponseDto cancelarReserva(UUID idReserva){
        ReservaEntity reserva = findByIdPublico(idReserva);
        if(reserva.getEstado()==EstadoReserva.CANCELADA){
            throw new EstadoInvalidoException("La reserva ya esta cancelada");
        }
        reserva.setEstado(EstadoReserva.CANCELADA);
        return mapper.toDto(repository.save(reserva));
    }
}
