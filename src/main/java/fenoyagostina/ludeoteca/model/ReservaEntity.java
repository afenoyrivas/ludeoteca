package fenoyagostina.ludeoteca.model;

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
@Table(name = "reservas")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_publico", nullable = false, unique = true, updatable = false)
    private UUID idPublico;

    @Column(name = "fecha_reserva", nullable = false)
    private LocalDate fechaReserva;

    @Column(name = "fecha_retiro", nullable = false)
    private LocalDate fechaRetiro;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    private SocioEntity socio;

    @ManyToOne
    @JoinColumn(name = "juego_id")
    private JuegoEntity juego;

    @PrePersist
    public void onCreate(){
        if(idPublico==null){
            idPublico=UUID.randomUUID();
        }
        if(fechaReserva==null){
            fechaReserva=LocalDate.now();
        }
        if(estado==null){
            estado=EstadoReserva.CONFIRMADA;
        }
    }
}
