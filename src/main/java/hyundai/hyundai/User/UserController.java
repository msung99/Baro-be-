package hyundai.hyundai.User;

import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponse;
import hyundai.hyundai.User.model.LoginUserReq;
import hyundai.hyundai.User.model.LoginUserRes;
import hyundai.hyundai.User.model.SignupUserReq;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
@Api(value = "User", tags = "User 관련 API")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
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

}
