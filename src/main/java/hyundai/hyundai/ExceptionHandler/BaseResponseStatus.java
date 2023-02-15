package hyundai.hyundai.ExceptionHandler;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {

    SUCCESS("요청에 성공했습니다."),
    INVALID_EMAIL_FORM("이메일 형식을 확인해주세요"),
    INVALID_PASSWORD_FORM("비밀번호 형식을 확인해주세요"),
    NOT_EQUAL_PASSWORD_REPASSWORD("일치하지 않습니다. 다시 한번 확인해주세요"),
    // NOT_EQUAL_PASSWORD_REPASSWORD("비밀번호는 숫자,문자를 모두 포함하며, 8자~20자 사이로 입력해주세요"),

    SERVER_ERROR("서버와의 연동에 실패했습니다"),
    NOT_EXISTS_USER("아이디 또는 비밀번호를 다시 확인해주세요"),
    EMPTY_JWT("토큰이 비어있습니다. HTTP Header 에 토큰을 실어서 요청을 보내주세요"),
    INVALID_TOKEN("변조된 토큰입니다. 올바른 토큰을 전송해주세요"),
    ACCESS_TOKEN_EXPIRED("만료된 토큰입니다. 로그인을 시도하여 새로운 토큰을 발급받으세요"),
    EXISTS_USER("이미 존재하는 아이디입니다");

    private final String message;
    private BaseResponseStatus(String message){
        this.message = message;
    }
}
