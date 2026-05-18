package fenoyagostina.ludeoteca.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    @Positive
    private Integer edadMinima;

    @NotNull
    @Min(1)
    private Integer stockDisponible;
}
