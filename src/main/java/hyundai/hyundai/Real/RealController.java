package hyundai.hyundai.Real;

import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponse;
import hyundai.hyundai.Real.model.GetRealReq;
import hyundai.hyundai.Real.model.GetRealRes;
import hyundai.hyundai.Real.model.MakeReaReq;
import hyundai.hyundai.Real.model.MakeRealRes;
import hyundai.hyundai.utils.JwtService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/custom")
@RestController
@Api(value = "custom", tags = "커스텀 페이지 배열 나열관련 API")
public class RealController {
    private final RealService realService;
    private final JwtService jwtService;

    @Autowired
    public RealController(RealService realService, JwtService jwtService){
        this.realService = realService;
        this.jwtService = jwtService;
    }

    @ResponseBody
    @PostMapping("/setCustomList")
    @Operation(summary = "커스텀 배열 번호 선택", description = "커스텀 배열 반호를 저장합니다.")
    public BaseResponse<MakeRealRes> setCustomList(@RequestBody MakeReaReq makeRealReq){
        try{
            int userIdx = jwtService.getUserIdx();
            MakeRealRes makeRealRes = realService.setRealList(userIdx, makeRealReq);
            return new BaseResponse(makeRealRes);
        } catch (BaseException baseException){
            return new BaseResponse(baseException.getStatus());
        }
    }

    @ResponseBody
    @PostMapping("/getCustomList")
    @Operation(summary = "커스텀 배열 번호 조회", description = "앞서 저장해놓았던 커스텀 배열 번호를 조회합니다.")
    public BaseResponse<GetRealRes> getCustomList(@RequestBody GetRealReq getRealReq){
        try{
            int userIdx = jwtService.getUserIdx();
            int customRecord = getRealReq.getCustomRecord();;
            GetRealRes getRealres = realService.getRealList(userIdx, customRecord);
            return new BaseResponse(getRealres);
        } catch (BaseException baseException){
            return new BaseResponse(baseException.getStatus());
        }
    }
}
