package hyundai.hyundai.ChatGPT.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatGptRes {
    @ApiModelProperty("내 현상황에 알맞는 침대 종류에는 무엇이 있을가?")
    String answer;

    @ApiModelProperty("침대")
    String category;
}
