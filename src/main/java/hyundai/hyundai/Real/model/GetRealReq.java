package hyundai.hyundai.Real.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRealReq {
    @ApiModelProperty(example = "3")
    int customRecord;
}
