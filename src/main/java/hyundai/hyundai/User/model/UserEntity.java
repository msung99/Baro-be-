package hyundai.hyundai.User.model;

import hyundai.hyundai.Category.model.CategoryEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "User")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data @Builder
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

    int peopleCount;

    // https://devhan.tistory.com/174
    // @ElementCollection
    // @CollectionTable(name = "customList", joinColumns = @JoinColumn(name = "customIdx"))
    // @Column(name = "customNumber")
    // https://postitforhooney.tistory.com/entry/springhibernateEntity-%EC%84%A0%EC%96%B8%EC%8B%9C%EC%97%90-Column%EC%9C%BC%EB%A1%9C-%EC%93%B0%EC%A7%80%EC%95%8A%EB%8A%94-%EB%B3%80%EC%88%98%EC%97%90-%EB%8C%80%ED%95%9C-%EC%84%A0%EC%96%B8-Transient
    @Transient
    private Set<Integer> customList = new HashSet<Integer>();

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
