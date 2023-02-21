package hyundai.hyundai.User.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserReq {
    @ApiModelProperty(example = "msung1234")
    private String identification;

    @ApiModelProperty(example = "mypassword")
    private String password;
}
