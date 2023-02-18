package hyundai.hyundai.Real.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRealRes {
    @ApiModelProperty(example = "[1, 3, 5, 6]")
    private List<Integer> customNumberList = new ArrayList<>();
}
