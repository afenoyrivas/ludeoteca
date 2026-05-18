package fenoyagostina.ludeoteca.repository;

import fenoyagostina.ludeoteca.model.SocioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocioRepository extends JpaRepository<SocioEntity, Integer> {
}
