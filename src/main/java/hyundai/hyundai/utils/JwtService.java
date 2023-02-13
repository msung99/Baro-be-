package hyundai.hyundai.utils;


import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponseStatus;
import hyundai.hyundai.User.TokenDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.Date;

@Service
public class JwtService {
    private static final String AUTHORITIES_KEY = "auth";
    private static final String BEARER_TYPE = "Bearer";
    private static final long ACCESS_TOKEN_EXPIRE_TIME = 30 * 60 * 1000L; // 30분
    private static final long REFRESH_TOKEN_EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000L;  // 7일
    private final String key = Secret.JWT_SECRET_KEY;

    public TokenDto createJwt(int userIdx){
        // accessToken 생성
        Date accessTokenExpiresIn = new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRE_TIME);
        String accessToken = Jwts.builder()
                .setHeaderParam("type", "jwt")
                .claim("userIdx", userIdx)
                .setExpiration(accessTokenExpiresIn)
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();

        return TokenDto.builder()
                .userIdx(userIdx)
                .accessToken(accessToken)
                .build();
    }

    public String getJwt(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return request.getHeader("Authorization");
    }

    public int getUserIdx() throws BaseException {
        String accessToken = getJwt();

        if(accessToken == null || accessToken.length() == 0){
            throw new BaseException(BaseResponseStatus.EMPTY_JWT);
        }

        Jws<Claims> claimsAccessToken;
        try{
            claimsAccessToken = Jwts.parserBuilder()
                    .setSigningKey(Secret.JWT_SECRET_KEY)
                    .build()
                    .parseClaimsJws(accessToken);

            int userIdx = claimsAccessToken.getBody().get("userIdx", Integer.class);
        } catch (io.jsonwebtoken.security.SignatureException signatureException){
            throw new BaseException(BaseResponseStatus.INVALID_TOKEN);
        } catch (io.jsonwebtoken.ExpiredJwtException expiredJwtException){
            throw new BaseException(BaseResponseStatus.ACCESS_TOKEN_EXPIRED);
        }

        return claimsAccessToken.getBody().get("userIdx", Integer.class);
    }
}
