package hyundai.hyundai.Custom.model;

import hyundai.hyundai.Custom.model.CustomEntity;
import hyundai.hyundai.Custom.model.CustomRecordEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MakeCustomReq {
    int customNumber;
    CustomRecordEntity customRecordEntity;

    public CustomEntity toEntity(){
        return CustomEntity.builder()
                .customNumber(customNumber)
                .customRecord(customRecordEntity)
                .build();
    }
}
