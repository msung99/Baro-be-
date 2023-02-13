package hyundai.hyundai.ChatGPT.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatGptReq {

    @ApiModelProperty(example = "나 뭐 추천받지?")
    String question;
}
