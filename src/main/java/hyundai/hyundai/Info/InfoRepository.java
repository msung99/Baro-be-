package hyundai.hyundai.Info;

import hyundai.hyundai.Info.model.InfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface InfoRepository extends JpaRepository<InfoEntity, Integer> {
}
