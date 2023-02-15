package hyundai.hyundai.User.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class IdentificationReq {

    @ApiModelProperty(example = "msung1234")
    @NotEmpty(message = "아이디는 필수 입력값입니다")
    @Pattern(regexp = "^[a-z0-9]{5,20}$", message = "아이디는 영어 소문자와 숫자만 사용하여 5~20자리여야 합니다.")
    String identification;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .identification(identification)
                .build();
    }
}
