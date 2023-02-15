package hyundai.hyundai.Category.model;

import hyundai.hyundai.User.model.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Category")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @Getter @Setter
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryIdx;
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<UserEntity> userEntityList = new ArrayList<>();
}

 /*
    @OneToMany(mappedBy = "user_id")
    private List<GoalEntity> goalEntityList = new ArrayList<>();
     */
    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private UserEntity user_id; // 외래키 : 어떤 유저의 목표인가?
     */