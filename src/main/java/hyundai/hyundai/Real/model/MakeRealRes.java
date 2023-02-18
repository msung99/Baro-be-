package hyundai.hyundai.Real.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MakeRealRes {
    @ApiModelProperty(example = "3")
    private int customRecord;
}
