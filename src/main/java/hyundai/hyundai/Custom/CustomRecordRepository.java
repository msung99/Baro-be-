package hyundai.hyundai.Custom;

import hyundai.hyundai.Custom.model.CustomEntity;
import hyundai.hyundai.Custom.model.CustomRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomRecordRepository extends JpaRepository<CustomRecordEntity, Integer> {

}
