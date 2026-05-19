package fenoyagostina.ludeoteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "socios")
public class SocioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_publico", nullable = false, unique = true, updatable = false)
    private UUID idPublico;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "dni", nullable = false, unique = true)
    private String dni;

    @Column(name = "fecha_alta", nullable = false)
    private LocalDate fechaAlta;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

    @PrePersist
    public void onCreate(){
        if(idPublico==null){
            idPublico=UUID.randomUUID();
        }
        if(fechaAlta==null){
            fechaAlta= LocalDate.now();
        }
        if(activo==null){
            activo=true;
        }
    }
}
