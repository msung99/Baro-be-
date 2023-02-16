package hyundai.hyundai.Custom.model;


import hyundai.hyundai.User.model.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CustomRecord")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter @Builder
public class CustomRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int customRecordIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private UserEntity user;

    @OneToMany(mappedBy = "customRecord")
    private List<CustomEntity> customList;
}
