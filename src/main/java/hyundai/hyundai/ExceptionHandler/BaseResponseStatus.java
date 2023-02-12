package hyundai.hyundai.ExceptionHandler;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {

    SUCCESS("요청에 성공했습니다."),
    INVALID_EMAIL_FORM("이메일 형식을 확인해주세요"),
    INVALID_PASSWORD_FORM("비밀번호 형식을 확인해주세요"),
    NOT_EQUAL_PASSWORD_REPASSWORD("비밀번호는 숫자,문자를 모두 포함하며, 8자~20자 사이로 입력해주세요");

    private final String message;
    private BaseResponseStatus(String message){
        this.message = message;
    }
}
