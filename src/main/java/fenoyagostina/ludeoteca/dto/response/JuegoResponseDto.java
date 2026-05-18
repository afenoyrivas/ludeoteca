package fenoyagostina.ludeoteca.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class JuegoResponseDto {

    private UUID idPublico;
    private String nombre;
    private String categoria;
    private Integer edadMinima;
    private Integer stockDisponible;
    private Boolean activo;
}
