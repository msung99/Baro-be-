package hyundai.hyundai.ChatGPT;


import hyundai.hyundai.ChatGPT.model.ChatGptReq;
import hyundai.hyundai.ChatGPT.model.ChatGptRes;
import hyundai.hyundai.ExceptionHandler.BaseResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/chatGPT")
@RestController
@Api(value = "chatGPT", tags = "chatGPT API")
public class MyChatGPTController {
    private final MyChatGPTService chatGPTService;

    @Autowired
    public MyChatGPTController(MyChatGPTService chatGPTService){
        this.chatGPTService = chatGPTService;
    }

    @ResponseBody
    public BaseResponse<ChatGptRes> askToChatGPT(ChatGptReq chatGptReq){

    }
}
