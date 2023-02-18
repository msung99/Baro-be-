package hyundai.hyundai.Custom;

import hyundai.hyundai.Custom.model.CustomRes;
import hyundai.hyundai.Custom.model.GetCustomListReq;
import hyundai.hyundai.Custom.model.SetCustomListRes;
import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponse;
import hyundai.hyundai.Custom.model.CustomReq;
import hyundai.hyundai.utils.JwtService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/basic")
@RestController
@Api(value = "basic", tags = "베이직 배열 나열관련 API")
public class CustomController {
    private final CustomService customService;
    private final JwtService jwtService;

    @Autowired
    public CustomController(CustomService customService, JwtService jwtService){
        this.customService = customService;
        this.jwtService = jwtService;
    }

    @ResponseBody
    @PostMapping("/setBasicList")
    @Operation(summary = "커스텀 가구 번호 선택", description = "커스텀할 가구 번호를 배열 형태로 입력받습니다.")
    public BaseResponse<SetCustomListRes> setCustomList(@RequestBody CustomReq customReq){
        try {
            int userIdx = jwtService.getUserIdx();
            SetCustomListRes setCustomListRes = customService.setCustomList(userIdx, customReq);
            return new BaseResponse(setCustomListRes);
        } catch (BaseException baseException){
            return new BaseResponse(baseException.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/getBasicList")
    @Operation(summary = "커스텀 가구 번호 배열조회", description = "커스텀했던 가구 번호 배열을 조회합니다.")
    public BaseResponse<CustomRes> getCustomList(@RequestBody GetCustomListReq getCustomListReq){
        try {
            int userIdx = jwtService.getUserIdx();
            int customRecord = getCustomListReq.getCustomRecord();
            CustomRes customRes = customService.getCustomList(userIdx, customRecord);
            return new BaseResponse(customRes);
        } catch (BaseException baseException){
            return new BaseResponse(baseException.getStatus());
        }
    }
}
