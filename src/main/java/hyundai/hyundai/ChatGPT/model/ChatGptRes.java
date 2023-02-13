package hyundai.hyundai.ChatGPT.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatGptRes {
    @ApiModelProperty("현대에서는 오피스 용 차량을 제공합니다. 스타일과 기능을 조합하여 당신의 용도에 맞는 차량을 추천해드릴게요.")
    String answer;

    @ApiModelProperty("침대")
    String category;
}
