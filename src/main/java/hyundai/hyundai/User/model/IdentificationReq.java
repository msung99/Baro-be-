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
    @Pattern(regexp = "^[a-z0-9]{5,20}$", message = "아이디는 영어 소문자와 숫자만 사용하여 5~20자리여야 합니다.")
    String identification;
    //     @Pattern(regexp = "^[a-z0-9]{5,20}$", message = "아이디는 영어 소문자와 숫자만 사용하여 5~20자리여야 합니다.")

    public UserEntity toEntity(String identify){
        System.out.println("2=================================");
        System.out.println(identify);
        return UserEntity.builder()
                .identification(identify)
                .build();
    }
}
