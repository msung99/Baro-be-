package hyundai.hyundai.ChatGPT;

import hyundai.hyundai.ChatGPT.model.ChatGptRes;
import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponseStatus;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MyChatGPTService {
    private ChatgptService chatgptService;

    @Autowired
    public MyChatGPTService(ChatgptService chatgptService){
        this.chatgptService = chatgptService;
    }

    @Value("${openai.api-key}")
    private String apikey;

    List<String> keywordList = Arrays.asList("침대", "책상", "수납상자", "식탁", "전시대", "냉장고", "의자", "검색 디바이스", "의료형 침대");

    public ChatGptRes getChatResponse(String prompt) throws BaseException {
        try {
            String responseMessage = chatgptService.sendMessage(prompt);
            String category = getKeywordInAnswer(responseMessage);
            return new ChatGptRes(responseMessage, category);
        } catch (Exception exception){
            throw new BaseException(BaseResponseStatus.SERVER_ERROR);
        }
    }

    // chatGPT 가 리턴해주는 답변 문자열에서 특정 키워드(카테고리) 추출
    public String getKeywordInAnswer(String responseMessage){
        String result = null;
        for (String keyword :keywordList){
            if(responseMessage.contains(keyword)){
                result = keyword;
                break;
            }
        }
        return result;
    }
}
