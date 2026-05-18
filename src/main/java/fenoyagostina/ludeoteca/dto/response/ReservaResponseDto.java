package fenoyagostina.ludeoteca.dto.response;

import fenoyagostina.ludeoteca.model.EstadoReserva;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class ReservaResponseDto {

    private UUID idPublico;
    private LocalDate fechaReserva;
    private LocalDate fechaRetiro;
    private Integer cantidad;
    private EstadoReserva estado;
    private SocioResponseDto socio;
    private JuegoResponseDto juego;
}
