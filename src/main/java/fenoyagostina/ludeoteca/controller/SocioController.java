package fenoyagostina.ludeoteca.controller;

import fenoyagostina.ludeoteca.dto.request.SocioRequestDto;
import fenoyagostina.ludeoteca.dto.response.SocioResponseDto;
import fenoyagostina.ludeoteca.service.SocioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/api/socios")
public class SocioController {

    private final SocioService service;

    public SocioController(SocioService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<SocioResponseDto>> getAll(){
        List<SocioResponseDto> socios = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(socios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SocioResponseDto> getById(@PathVariable UUID id){
        SocioResponseDto socio = service.getByIdPublico(id);
        return ResponseEntity.status(HttpStatus.OK).body(socio);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<SocioResponseDto> getByDni(@PathVariable @Size(min = 9, max = 9) String dni){
        SocioResponseDto socio = service.getByDni(dni);
        return ResponseEntity.status(HttpStatus.OK).body(socio);
    }

    @PostMapping
    public ResponseEntity<SocioResponseDto> create(@Valid @RequestBody SocioRequestDto request){
        SocioResponseDto socio = service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(socio);
    }
}
