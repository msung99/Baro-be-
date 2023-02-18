package hyundai.hyundai.Real;

import hyundai.hyundai.Custom.model.CustomEntity;
import hyundai.hyundai.Real.model.RealEntity;
import hyundai.hyundai.Real.model.RealRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface RealRepository extends JpaRepository<RealEntity, Integer> {

    @Query("select m from RealEntity m where m.realRecord = :realRecordEntity")
    public List<RealEntity> getRealList(RealRecordEntity realRecordEntity);
}
