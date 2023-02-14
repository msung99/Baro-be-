package hyundai.hyundai.Category.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPeopleCategory {

    @ApiModelProperty(example = "의류")
    String categoryName;
    @ApiModelProperty(example = "3")
    int peopleCount;
}
