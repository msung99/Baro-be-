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

    @ApiModelProperty(example = "eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxLCJpYXQiOjE2NzM5MjY4NTMsImV4cCI6MTY3NTM5ODA4Mn0.d_IZrGwPbN9nIcVsokdSu8H5ZHBrZKSSZK1JhWW8IBc")
    String accessToken;
}
