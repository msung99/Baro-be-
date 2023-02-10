package hyundai.hyundai.ExceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"message"})
public class BaseResponse<T> {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    private T result;

    // 요청에 성공한 경우1 : Response 미포함
    public BaseResponse(){
        this.message = BaseResponseStatus.SUCCESS.getMessage();
    }

    // 요청에 성공한 경우2 : Response 포함
    public BaseResponse(T result){
        this.message = BaseResponseStatus.SUCCESS.getMessage();;
        this.result = result;
    }

    // 요청에 실패한 경우
    public BaseResponse(BaseResponseStatus baseResponseStatus){
        this.message = baseResponseStatus.getMessage();
    }
}
