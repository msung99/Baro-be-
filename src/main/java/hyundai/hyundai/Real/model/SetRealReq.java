package hyundai.hyundai.Real.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetRealReq {
    int realNumber;
    RealRecordEntity realEntity;

    public RealEntity toEntity(){
        return RealEntity.builder()
                .realNumber(realNumber)
                .realRecord(realEntity)
                .build();
    }
}
