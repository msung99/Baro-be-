package hyundai.hyundai.User.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupUserReq {

    @ApiModelProperty(example = "abcde@naver.com")
    private String email;

    @ApiModelProperty(example = "mypassword")
    private String password;

    @ApiModelProperty(example = "mypassword")
    private String repass;

    @ApiModelProperty(example = "msung99")
    private String nickname;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .build();
    }
}
