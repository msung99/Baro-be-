package hyundai.hyundai.User.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupUserReq {

    @ApiModelProperty(example = "msung1234")
    @NotEmpty(message = "아이디")
    @Pattern(regexp = "^[a-z0-9]{5,20}$", message = "아이디는 영어 소문자와 숫자만 사용하여 5~20자리여야 합니다.")
    private String identification;

    @ApiModelProperty(example = "Mypassword@")
    @NotEmpty(message = "비밀번호는 필수 입력값입니다")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password;

    @ApiModelProperty(example = "Mypassword@")
    @NotEmpty(message = "비밀번호 확인은 필수 입력값입니다")
    private String repass;

    @ApiModelProperty(example = "msung99")
    @NotEmpty(message = "닉네임은 필수 입력값입니다")
    @Pattern(regexp = "^[가-힣a-zA-Z0-9]{2,10}$" , message = "닉네임은 특수문자를 포함하지 않은 2~10자리여야 합니다.")
    private String nickname;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .password(password)
                .nickname(nickname)
                .build();
    }
}
