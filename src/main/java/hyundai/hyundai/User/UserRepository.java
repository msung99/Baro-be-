package hyundai.hyundai.User;

import hyundai.hyundai.User.model.LoginUserRes;
import hyundai.hyundai.User.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query("select m from UserEntity m where m.identification = :identification and m.password = :password")
    UserEntity findUser(@Param("identification") String identification, @Param("password") String password);

    boolean existsUserEntityByIdentification(String identification);
}
