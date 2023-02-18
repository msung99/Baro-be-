package hyundai.hyundai.Real;

import hyundai.hyundai.Real.model.RealRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface RealRecordRepository extends JpaRepository<RealRecordEntity, Integer> {
}
