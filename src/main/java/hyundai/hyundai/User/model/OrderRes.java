package hyundai.hyundai.User.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRes {
    @ApiModelProperty(example = "010-1234-5678")
    private String phoneNumber;

    @ApiModelProperty(example = "나문희")
    private String orderName;
}
