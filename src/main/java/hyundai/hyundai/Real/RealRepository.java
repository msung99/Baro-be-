package hyundai.hyundai.Real;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface RealRepository extends JpaRepository<> {
}
