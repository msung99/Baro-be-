package hyundai.hyundai.User;

import hyundai.hyundai.User.model.LoginUserRes;
import hyundai.hyundai.User.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query("select new hyundai.hyundai.User.model.LoginUserRes(m.userIdx) from UserEntity m where m.email = :email and m.password = :password")
    LoginUserRes findUser(@Param("email") String email, @Param("password") String password);

    UserEntity findUserEntityByEmail(String email);
}
