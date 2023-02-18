package hyundai.hyundai.Real.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MakeReaReq {
    @ApiModelProperty(example = "[1,2,3,4]")
    private Set<Integer> customNumberList;
}
