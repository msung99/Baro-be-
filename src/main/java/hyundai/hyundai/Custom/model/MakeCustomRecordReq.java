package hyundai.hyundai.Custom.model;

import hyundai.hyundai.Custom.CustomRepository;
import hyundai.hyundai.User.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MakeCustomRecordReq {
    UserEntity userEntity;

    public CustomRecordEntity toEntity(){
        return CustomRecordEntity.builder()
                .user(userEntity)
                .build();
    }
}
