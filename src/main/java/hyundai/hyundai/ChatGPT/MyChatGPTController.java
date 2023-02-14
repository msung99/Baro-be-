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
    String qreQuestion = "우리가 만들고 있는 차량은 목적에 따라 7가지가 있어. 의료, 거주, 운송, 스토어, 이동수단, 오피스, 다용도, 엔터테인먼트 이렇게 크게 7가지야. 고객이 만약 ‘저는 차 안에서 게임을 즐길거에요.’ 라고 하면 너는 category:'엔터테인먼트', answer:'당신에게 엔터테인먼트 차량을 추천합니다.'라고 차량을 추천하면 되는거야. 만약 여기에 해당하지 않으면 너는 category:'커스텀', answer:'현대에서 제공하는 프리셋 중, 일치하는 차량이 없습니다. 나만의 차량을 커스텀해보시겠어요?'라고만 하면 되는거야. 대답은 최대 3문장만 해야해. 그리고 앞으로 너는 너 스스로를 ‘현대’라고 불러야해. 이제 내가 고객이 되어서 너에게 차량 추천을 받아볼게.";
    private final MyChatGPTService chatGPTService;

    @Autowired
    public MyChatGPTController(MyChatGPTService chatGPTService){
        this.chatGPTService = chatGPTService;
    }

    @ResponseBody
    @PostMapping("/askChatGPT")
    @Operation(summary = "chatGPT 에게 질문하기", description = "질문을 보내면 그에 알맞는 대답을 보내줍니다.")
    public BaseResponse<ChatGptRes> askToChatGPT(@RequestBody ChatGptReq chatGptReq){
        try {
            String resultQuestion = qreQuestion + chatGptReq.getQuestion();
            ChatGptRes chatGptRes = chatGPTService.getChatResponse(resultQuestion);
            return new BaseResponse(chatGptRes);
        } catch (BaseException baseException){
            return new BaseResponse(baseException.getStatus());
        }
    }
}
