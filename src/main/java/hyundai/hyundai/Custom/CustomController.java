package hyundai.hyundai.Custom;

import hyundai.hyundai.Custom.model.CustomRes;
import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponse;
import hyundai.hyundai.Custom.model.CustomReq;
import hyundai.hyundai.utils.JwtService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/custom")
@RestController
@Api(value = "custom", tags = "커스텀후 배열 나열관련 API")
public class CustomController {
    private final CustomService customService;
    private final JwtService jwtService;

    @Autowired
    public CustomController(CustomService customService, JwtService jwtService){
        this.customService = customService;
        this.jwtService = jwtService;
    }

    @ResponseBody
    @PostMapping("/setCustomList")
    public BaseResponse setCustomList(@RequestBody CustomReq customReq){
        try {
            int userIdx = jwtService.getUserIdx();
            customService.setCustomList(userIdx, customReq);
            return new BaseResponse();
        } catch (BaseException baseException){
            return new BaseResponse(baseException.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/getCustomList")
    public BaseResponse<CustomRes> getCustomList(){
        try {
            int userIdx = jwtService.getUserIdx();
            CustomRes customRes = customService.getCustomList(userIdx);
            return new BaseResponse(customRes);
        } catch (BaseException baseException){
            return new BaseResponse(baseException.getStatus());
        }
    }
}
