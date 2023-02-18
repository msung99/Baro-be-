package hyundai.hyundai.Real.model;

import hyundai.hyundai.User.model.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RealRecord")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @Getter @Setter
public class RealRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int realRecordIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private UserEntity user;

    @OneToMany(mappedBy = "realRecord")
    private List<RealEntity> realEntityList;
}
