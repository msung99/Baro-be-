package hyundai.hyundai.ChatGPT.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatGptReq {

    @ApiModelProperty(example = "현대에서 추천해주는 의료 차량에 관심이 생겼어. 이 차량에 관해 추천할만한게 있을까?")
    String question;
}
