package fenoyagostina.ludeoteca.repository;

import fenoyagostina.ludeoteca.model.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Integer> {
}
