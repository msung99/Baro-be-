package hyundai.hyundai.User.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter @Setter
@ToString @Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IdentificationReq {

    @ApiModelProperty(example = "msung1234")
    @NotEmpty(message = "아이디는 필수 입력값입니다")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    String identification;
    //     @Pattern(regexp = "^[a-z0-9]{5,20}$", message = "아이디는 영어 소문자와 숫자만 사용하여 5~20자리여야 합니다.")

    public UserEntity toEntity(){
        return UserEntity.builder()
                .identification(identification)
                .build();
    }
}
