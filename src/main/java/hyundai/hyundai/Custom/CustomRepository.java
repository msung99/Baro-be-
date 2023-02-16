package hyundai.hyundai.Custom;

import hyundai.hyundai.Custom.model.CustomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface CustomRepository extends JpaRepository<CustomEntity, Integer> {
}
