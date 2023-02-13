package hyundai.hyundai.ChatGPT.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatGptReq {

    @ApiModelProperty(example = "Hi ChatGpt, How are you?")
    String question;
}
