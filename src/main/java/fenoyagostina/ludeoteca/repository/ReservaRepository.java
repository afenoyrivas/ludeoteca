package fenoyagostina.ludeoteca.repository;

import fenoyagostina.ludeoteca.model.EstadoReserva;
import fenoyagostina.ludeoteca.model.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Integer> {
    List<ReservaEntity> findByEstado(EstadoReserva estado);
    List<ReservaEntity> findBySocio_IdPublico(UUID idPublico);
    Optional<ReservaEntity> findByIdPublico(UUID idPublico);
}
