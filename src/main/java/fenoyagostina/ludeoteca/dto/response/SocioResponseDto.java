package fenoyagostina.ludeoteca.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class SocioResponseDto {

    private UUID idPublico;
    private String nombre;
    private String email;
    private String dni;
    private LocalDate fechaAlta;
    private Boolean activo;
}
