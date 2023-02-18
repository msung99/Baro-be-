package hyundai.hyundai.Real;

import hyundai.hyundai.Real.model.RealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface RealRepository extends JpaRepository<RealEntity, Integer> {
}
