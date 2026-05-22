package fenoyagostina.ludeoteca.controller;

import fenoyagostina.ludeoteca.dto.request.ReservaRequestDto;
import fenoyagostina.ludeoteca.dto.response.ReservaResponseDto;
import fenoyagostina.ludeoteca.model.EstadoReserva;
import fenoyagostina.ludeoteca.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @GetMapping("/{idSocio}")
    public ResponseEntity<List<ReservaResponseDto>> getAll(@PathVariable EstadoReserva estado){
        List<ReservaResponseDto> reservas = service.findAll(estado);
        return ResponseEntity.status(HttpStatus.OK).body(reservas);
    }

    @GetMapping
    public ResponseEntity<List<ReservaResponseDto>> getByIdSocio(@RequestParam UUID idSocio){
        List<ReservaResponseDto> reservas = service.findByIdSocio(idSocio);
        return ResponseEntity.status(HttpStatus.OK).body(reservas);
    }

    @PostMapping
    public ResponseEntity<ReservaResponseDto> create(@Valid @RequestBody ReservaRequestDto request){
        ReservaResponseDto reserva = service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
    }

    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<ReservaResponseDto> cancelarReserva(@PathVariable UUID id){
        ReservaResponseDto reserva = service.cancelarReserva(id);
        return ResponseEntity.status(HttpStatus.OK).body(reserva);
    }
}
