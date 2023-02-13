package hyundai.hyundai.ChatGPT;


import hyundai.hyundai.ChatGPT.model.ChatGptReq;
import hyundai.hyundai.ChatGPT.model.ChatGptRes;
import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/askToChatGPT")
    @Operation(summary = "chatGPT 에게 질문하기", description = "질문을 보내면 그에 알맞는 대답을 보내줍니다.")
    public BaseResponse<ChatGptRes> askToChatGPT(@RequestBody ChatGptReq chatGptReq){
        try {
            ChatGptRes chatGptRes = chatGPTService.getChatResponse(chatGptReq.getQuestion());
            return new BaseResponse(chatGptRes);
        } catch (BaseException baseException){
            return new BaseResponse(baseException.getStatus());
        }
    }
}
