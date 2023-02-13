package hyundai.hyundai.User.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @Getter @Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userIdx;

    // @Column 을 사용할경우 객체의 필드와 테이블의 컬럼을 매핑한다.
    // 만일 @Column 을 생략할경우 필드의 이름을 테이블 컬럼 이름으로 사용한다.
    @Column(unique = true)
    private String identification;  // 아이디
    private String nickname;
    private String password;


    // 회원가입 (entity -> DTO 변환)
    public SignupUserRes toSignupUserRes(){
        return new SignupUserRes(userIdx);
    }
}
