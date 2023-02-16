package hyundai.hyundai.Custom.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Custom")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter @Builder
public class CustomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customIdx;
    private int customNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customRecordIdx")
    public CustomRecordEntity customRecord;
}