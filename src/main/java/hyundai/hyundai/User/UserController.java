package hyundai.hyundai.User;

import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponse;
import hyundai.hyundai.User.model.LoginUserReq;
import hyundai.hyundai.User.model.LoginUserRes;
import hyundai.hyundai.User.model.PeopleReq;
import hyundai.hyundai.User.model.SignupUserReq;
import hyundai.hyundai.utils.JwtService;
import io.jsonwebtoken.Jwt;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
@Api(value = "User", tags = "User 관련 API")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    @Autowired
    public UserController(UserService userService, JwtService jwtService){
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @ResponseBody
    @PostMapping("/signup")
    @Operation(summary = "회원가입", description = "email, password 필드 값을 정상적인 값을 입력받도록 Regex(정규 표현식)을 사용했다는점 참고 해주세요!")
    public BaseResponse createUser(@RequestBody SignupUserReq signupUserReq){
        try{
            userService.createUser(signupUserReq);
            return new BaseResponse();
        } catch (BaseException exception){
            return new BaseResponse(exception.getStatus());
        }
    }

    @ResponseBody
    @PostMapping("/login")
    @Operation(summary = "로그인", description = "HttpHeader명:Authorization / 토큰 발급")
    public BaseResponse<LoginUserRes> login(@RequestBody LoginUserReq loginUserReq){
        try{
            LoginUserRes loginUserRes = userService.login(loginUserReq);
            return new BaseResponse(loginUserRes);
        } catch (BaseException exception){
            return new BaseResponse(exception.getStatus());
        }
    }

    @ResponseBody
    @PostMapping("/selectPeopleCount")
    @Operation(summary = "인원수 설정", description = "카테고리(테마) 설정후 인원수를 설정합니다.")
    public BaseResponse setPeopleCount(@RequestBody PeopleReq peopleReq){
        try{
            int userIdx = jwtService.getUserIdx();
            userService.setPeopleCount(userIdx, peopleReq.getCount());
            return new BaseResponse();
        } catch (BaseException exception){
            return new BaseResponse(exception.getStatus());
        }
    }
}
