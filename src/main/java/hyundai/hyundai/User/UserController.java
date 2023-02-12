package hyundai.hyundai.User;

import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponse;
import hyundai.hyundai.User.model.SignupUserReq;
import io.swagger.annotations.Api;
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
    public BaseResponse createUser(@RequestBody SignupUserReq signupUserReq){
        try{
            userService.createUser(signupUserReq);
            return new BaseResponse();
        } catch (BaseException exception){
            return new BaseResponse(exception.getStatus());
        }
    }
}
