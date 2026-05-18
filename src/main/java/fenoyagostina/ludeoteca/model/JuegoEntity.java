package fenoyagostina.ludeoteca.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "juegos")
public class JuegoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_publico", nullable = false, unique = true, updatable = false)
    private UUID idPublico;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "edad_minima", nullable = false)
    private Integer edadMinima;

    @Column(name = "stock_disponible", nullable = false)
    private Integer stockDisponible;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

    @PrePersist
    public void onCreate(){
        if(idPublico==null){
            idPublico=UUID.randomUUID();
        }
        if(activo==null){
            activo=true;
        }
    }
}
