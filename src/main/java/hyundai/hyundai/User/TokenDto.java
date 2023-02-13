package hyundai.hyundai.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class TokenDto {
    int userIdx;
    private String grantType;
    private String accessToken;
}
