package fenoyagostina.ludeoteca.controller;

import fenoyagostina.ludeoteca.dto.request.JuegoRequestDto;
import fenoyagostina.ludeoteca.dto.response.JuegoResponseDto;
import fenoyagostina.ludeoteca.repository.JuegoRepository;
import fenoyagostina.ludeoteca.service.JuegoService;
import fenoyagostina.ludeoteca.service.SocioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/api/juegos")
public class JuegoController {

    private final JuegoService service;

    public JuegoController(JuegoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<JuegoResponseDto>> getAll(
            @RequestParam(required = false) Boolean activo){
        List<JuegoResponseDto> juegos = service.findAll(activo);
        return ResponseEntity.status(HttpStatus.OK).body(juegos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JuegoResponseDto> getById(@PathVariable @NotNull UUID id){
        JuegoResponseDto juego = service.findByIdPublico(id);
        return ResponseEntity.status(HttpStatus.OK).body(juego);
    }

    @PostMapping
    public ResponseEntity<JuegoResponseDto> create(@Valid @RequestBody JuegoRequestDto request){
        JuegoResponseDto juego = service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(juego);
    }
}
