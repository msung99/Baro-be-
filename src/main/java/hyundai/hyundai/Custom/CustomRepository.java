package hyundai.hyundai.Custom;

import hyundai.hyundai.Custom.model.CustomEntity;
import hyundai.hyundai.Custom.model.CustomRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface CustomRepository extends JpaRepository<CustomEntity, Integer> {
    @Query("select m from CustomEntity m where m.customRecord = :customRecordEntity")
    public List<CustomEntity> getCustomList(CustomRecordEntity customRecordEntity);
}
