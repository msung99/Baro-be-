package hyundai.hyundai.Custom.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomRes {

    @ApiModelProperty(example = "[1, 3, 5, 6]")
    private List<Integer> customNumberList = new ArrayList<>();
}
