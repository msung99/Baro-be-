package hyundai.hyundai.ChatGPT;

import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponseStatus;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyChatGPTService {
    private ChatgptService chatgptService;

    public MyChatGPTService(ChatgptService chatgptService){
        this.chatgptService = chatgptService;
    }

    @Value("${openai.api-key}")
    private String apikey;

    // Model ID for the GPT model
    String modelId = "text-davinci-002";

    // Prompt text for the GPT model
    String prompt = "Hello, ChatGPT. How are you doing today?";

    public String getChatResponse(String prompt) throws BaseException {
        try {
            String responseMessage = chatgptService.sendMessage(prompt);
            System.out.println(responseMessage);
            return responseMessage;
        } catch (Exception exception){
            throw new BaseException(BaseResponseStatus.SERVER_ERROR);
        }
    }
}
