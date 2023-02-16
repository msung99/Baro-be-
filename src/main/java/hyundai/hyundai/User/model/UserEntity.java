package hyundai.hyundai.User.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import hyundai.hyundai.Category.model.CategoryEntity;
import hyundai.hyundai.Custom.model.CustomRecordEntity;
import lombok.*;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.util.*;

@Entity
@Indexed
@Table(name = "User")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter @Builder
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

    @OneToMany(mappedBy = "user")
    private List<CustomRecordEntity> customRecordEntityList = new ArrayList<>();

    // https://devhan.tistory.com/174
    // @CollectionTable(name = "customList", joinColumns = @JoinColumn(name = "customIdx"))
    // @ElementCollection(fetch = FetchType.LAZY)
    // @CollectionTable(name = "Custom", joinColumns = @JoinColumn(name = "customIdx", insertable = false))
    // @Column(name = "customNumber")
    // private Set<Integer> customList = new HashSet<>();


    // https://postitforhooney.tistory.com/entry/springhibernateEntity-%EC%84%A0%EC%96%B8%EC%8B%9C%EC%97%90-Column%EC%9C%BC%EB%A1%9C-%EC%93%B0%EC%A7%80%EC%95%8A%EB%8A%94-%EB%B3%80%EC%88%98%EC%97%90-%EB%8C%80%ED%95%9C-%EC%84%A0%EC%96%B8-Transient
}
