package hyundai.hyundai.ExceptionHandler;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {

    SUCCESS("요청에 성공했습니다.");

    private final String message;
    private BaseResponseStatus(String message){
        this.message = message;
    }
}
