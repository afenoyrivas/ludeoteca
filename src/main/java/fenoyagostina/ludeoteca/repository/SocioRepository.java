package fenoyagostina.ludeoteca.repository;

import fenoyagostina.ludeoteca.model.SocioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SocioRepository extends JpaRepository<SocioEntity, Integer> {
    Optional<SocioEntity> findByDni(String dni);
    boolean existsByDni(String dni);
    boolean existsByEmail(String email);
}
