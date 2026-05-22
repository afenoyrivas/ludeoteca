package fenoyagostina.ludeoteca.dto.request;

import fenoyagostina.ludeoteca.model.JuegoEntity;
import fenoyagostina.ludeoteca.model.SocioEntity;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class ReservaRequestDto {

    @NotNull
    @FutureOrPresent
    private LocalDate fechaRetiro;

    @NotNull
    @Positive
    private Integer cantidad;

    @NotNull
    private UUID idSocio;

    @NotNull
    private UUID idJuego;
}
