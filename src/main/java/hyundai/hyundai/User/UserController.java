package hyundai.hyundai.User;

import hyundai.hyundai.ExceptionHandler.BaseResponse;
import hyundai.hyundai.User.model.SignupUserReq;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
@Api(value = "User", tags = "User 관련 API")
public class UserController {

    @ResponseBody
    @PostMapping
    public BaseResponse createUser(@RequestBody SignupUserReq signupUserReq){
        try{

        }
    }
}