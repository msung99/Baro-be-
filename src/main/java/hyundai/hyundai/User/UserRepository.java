package hyundai.hyundai.User;

import hyundai.hyundai.User.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<UserEntity, int> {
}
