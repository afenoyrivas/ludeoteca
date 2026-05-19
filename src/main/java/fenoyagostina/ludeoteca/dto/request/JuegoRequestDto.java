package fenoyagostina.ludeoteca.dto.request;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JuegoRequestDto {

    @NotBlank
    private String nombre;

    @NotBlank
    private String categoria;

    @NotNull
    @PositiveOrZero
    private Integer edadMinima;

    @NotNull
    @Min(1)
    private Integer stockDisponible;
}
