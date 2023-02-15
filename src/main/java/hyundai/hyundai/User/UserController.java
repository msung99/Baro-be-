package hyundai.hyundai.User;

import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponse;
import hyundai.hyundai.User.model.*;
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
    @Operation(summary = "회원가입", description = "아이디, 패스워드 필드 값을 정상적인 값을 입력받도록 Regex(정규 표현식)을 사용했다는점 참고 해주세요!")
    public BaseResponse createUser(@RequestBody SignupUserReq signupUserReq){
        try{
            userService.createUser(signupUserReq);
            return new BaseResponse();
        } catch (BaseException exception){
            return new BaseResponse(exception.getStatus());
        }
    }

    @ResponseBody
    @PostMapping("/signup/makeIdentification")
    @Operation(summary = "회원가입시 아이디 입력받기", description = "회원가입을 진행할떄 아이디, 비번, 재확인비번을 각각 따로 페이지를 넘겨갈때마다 입력받아서 유저 데이터를 생성합니다. / 아이디는 영어 소문자와 숫자만 사용하여 5~20자리여야 합니다.")
    public BaseResponse<UserIdxRes> makeIdentification(@RequestBody IdentificationReq identificationReq){
        try{
            int userIdx = userService.makeIdentification(identificationReq);
            return new BaseResponse(new UserIdxRes(userIdx));
        } catch (BaseException exception){
            return new BaseResponse(exception.getStatus());
        }
    }

    @ResponseBody
    @PostMapping("/signup/makePassword")
    @Operation(summary = "회원가입시 비밀번호 입력받기", description = "회원가입 진행시 아이디 입력받은후 비밀번호 입력받는 페이지에서 활용 / 비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    public BaseResponse makePassword(@RequestBody IdentificationReq identificationReq){
        try{
            userService.makePassword(ide);
            return new BaseResponse();
        } catch (BaseException baseException){
            return new BaseResponse(baseException.getStatus());
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
