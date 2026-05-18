package fenoyagostina.ludeoteca.repository;

import fenoyagostina.ludeoteca.model.JuegoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepository extends JpaRepository<JuegoEntity, Integer> {
}
