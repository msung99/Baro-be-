package hyundai.hyundai.Real.model;

import hyundai.hyundai.Custom.model.CustomRecordEntity;
import hyundai.hyundai.User.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MakeRealRecordReq {
    UserEntity userEntity;

    public RealRecordEntity toEntity(){
        return RealRecordEntity.builder()
                .user(userEntity)
                .build();
    }
}
