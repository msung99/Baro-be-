package hyundai.hyundai.User.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepasswordReq {
    @ApiModelProperty(example = "Mypassword123@")
    @NotEmpty(message = "재확인 비밀번호는 필수 입력값입니다.")
    private String rePassword;

    int userIdx;
}
