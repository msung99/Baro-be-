package hyundai.hyundai.Custom.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomListReq {

    @ApiModelProperty(example = "1")
    int customRecord;
}
