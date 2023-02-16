package hyundai.hyundai.Custom.model;


import hyundai.hyundai.User.model.UserEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CustomRecord")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter @Builder
public class CustomRecordEntity {
    @Id
    @GeneratedValue
    int customRecordIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private UserEntity user;
}
