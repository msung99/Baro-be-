package hyundai.hyundai.ExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseException extends Exception{
    private BaseResponseStatus status;
}
