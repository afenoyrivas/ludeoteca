package fenoyagostina.ludeoteca.repository;

import fenoyagostina.ludeoteca.model.JuegoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface JuegoRepository extends JpaRepository<JuegoEntity, Integer> {
    Optional<JuegoEntity> findByIdPublico(UUID idPublico);
    List<JuegoEntity> findByActivo(Boolean activo);
}