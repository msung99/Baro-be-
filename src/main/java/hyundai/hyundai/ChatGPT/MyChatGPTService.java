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

    List<String> keywordList = Arrays.asList("의료", "거주", "운송", "스토어", "이동수단", "오피스", "다용도", "엔터테인먼트");

    public ChatGptRes getChatResponse(String prompt) throws BaseException {
        try {
            String responseMessage = chatgptService.sendMessage(prompt);
            String category = getKeywordInAnswer(responseMessage);
            String resultMessage =  parsingResponseMessage(responseMessage);
            return new ChatGptRes(resultMessage, category);
        } catch (Exception exception){
            System.out.println(exception);
            System.out.println(exception.getMessage());
            System.out.println(exception.toString());
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
        if(result == null){  // 8개의 키워드중에 아무것도 해당 안되면 "커스텀" 리턴
            result = "커스텀";
        }
        return result;
    }
    /*
    //2. 특정문자 이후의 문자열 제거
    String str = "ABCD/DEFGH";
    String result = str.substring(str.lastIndexOf("/")+1);
            System.out.println(result);
    //결과값 DEFGH
     */

    public String parsingResponseMessage(String responseMessage){
        responseMessage = responseMessage.toLowerCase();
        String parsingResult = responseMessage;
        if(responseMessage.contains("answer")) {
            parsingResult = responseMessage.substring(responseMessage.lastIndexOf("answer") + 8);
        }
        parsingResult = parsingResult.replace(String.valueOf("\n"), "");
        // parsingResult = parsingResult.replaceAll("[^\\n+]", "");
        return parsingResult;
    }
}
