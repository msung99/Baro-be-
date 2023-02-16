package hyundai.hyundai.Custom.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SetCustomListRes {
    @ApiModelProperty(example = "3")
    private int customRecord;
}
