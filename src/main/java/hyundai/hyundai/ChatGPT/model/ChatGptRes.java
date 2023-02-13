package hyundai.hyundai.ChatGPT.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatGptRes {
    @ApiModelProperty(example = "현대는 의료 차량을 제공하고 있습니다. 이 차량은 의료 서비스를 제공하기 위해 설계되었으며, 의료 장비, 의료 인력 및 의료 자원을 제공하기 위해 최적화되었습니다.")
    String answer;

    @ApiModelProperty(example = "의료")
    String category;
}
