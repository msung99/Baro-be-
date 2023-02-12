package hyundai.hyundai.User.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupUserReq {

    @ApiModelProperty(example = "abcde@naver.com")
    @NotEmpty(message = "이메일은 필수 입력값입니다")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String email;

    @ApiModelProperty(example = "mypassword")
    @NotEmpty(message = "비밀번호는 필수 입력값입니다")
    private String password;

    @ApiModelProperty(example = "mypassword")
    @NotEmpty(message = "비밀번호 확인은 필수 입력값입니다")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String repass;

    @ApiModelProperty(example = "msung99")
    @NotEmpty(message = "닉네임은 필수 입력값입니다")
    private String nickname;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .build();
    }
}
