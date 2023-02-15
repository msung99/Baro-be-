package hyundai.hyundai.Category.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryReq {

    @ApiModelProperty(example = "3")
    int categoryIdx;
}
