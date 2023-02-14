package hyundai.hyundai.User.model;

import hyundai.hyundai.Category.model.CategoryEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
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
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryIdx") // referencedColumnName = "categoryIdx" => 생략시 자동으로 PK 를 가리킴
    private CategoryEntity category;

    /*
    @OneToMany(mappedBy = "user_id")
    private List<GoalEntity> goalEntityList = new ArrayList<>();
     */
    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private UserEntity user_id; // 외래키 : 어떤 유저의 목표인가?
     */


    // 회원가입 (entity -> DTO 변환)
    public SignupUserRes toSignupUserRes(){
        return new SignupUserRes(userIdx);
    }
}
