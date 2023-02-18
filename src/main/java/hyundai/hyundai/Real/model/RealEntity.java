package hyundai.hyundai.Real.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "MyReal")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @Getter @Setter
public class RealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int realIdx;
    private int realNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "realRecordIdx")
    private RealRecordEntity realRecord;
}
