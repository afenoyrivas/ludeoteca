package fenoyagostina.ludeoteca.service;

import fenoyagostina.ludeoteca.dto.request.SocioRequestDto;
import fenoyagostina.ludeoteca.dto.response.SocioResponseDto;
import fenoyagostina.ludeoteca.exception.DniYaExisteException;
import fenoyagostina.ludeoteca.exception.EmailYaExisteException;
import fenoyagostina.ludeoteca.mapper.SocioMapper;
import fenoyagostina.ludeoteca.model.ReservaEntity;
import fenoyagostina.ludeoteca.model.SocioEntity;
import fenoyagostina.ludeoteca.repository.SocioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SocioService {

    private final SocioRepository repository;
    private final SocioMapper mapper;

    public SocioService(SocioRepository repository, SocioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<SocioResponseDto> findAll(){
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    SocioEntity findByIdPublico(UUID idPublico){
        return repository.findByIdPublico(idPublico)
                .orElseThrow(EntityNotFoundException::new);
    }

    SocioEntity findByDni(String dni){
        return repository.findByDni(dni)
                .orElseThrow(EntityNotFoundException::new);
    }

    public SocioResponseDto getByIdPublico(UUID idPublico){
        return mapper.toDto(findByIdPublico(idPublico));
    }

    public SocioResponseDto getByDni(String dni){
        return mapper.toDto(findByDni(dni));
    }

    @Transactional
    public SocioResponseDto save(SocioRequestDto request){
        if(repository.existsByDni(request.getDni())){
            throw new DniYaExisteException(request.getDni());
        }
        if(repository.existsByEmail(request.getEmail())){
            throw new EmailYaExisteException(request.getEmail());
        }
        SocioEntity entity = mapper.toEntity(request);
        repository.save(entity);
        return mapper.toDto(entity);
    }
}
