package hyundai.hyundai.Category;

import hyundai.hyundai.Category.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
