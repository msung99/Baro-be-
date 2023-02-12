package hyundai.hyundai.User.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserRes {

    @ApiModelProperty(example = "3")
    int userIdx;
}
