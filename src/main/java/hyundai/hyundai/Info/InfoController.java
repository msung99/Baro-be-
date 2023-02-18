package hyundai.hyundai.Info;


import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponse;
import hyundai.hyundai.Info.model.GetInfoRes;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/info")
@Api(value = "info", tags = "데이버테이스 디폴트(더미) 데이터 조회")
public class InfoController {
    private final InfoService infoService;

    @Autowired
    public InfoController(InfoService infoService){
        this.infoService = infoService;
    }

    @ResponseBody
    @PostMapping("/getAllInfo")
    @Operation(summary = "DB에 존재하는 모든 디폴트 데이터 조회" , description = "")
    public BaseResponse<List<GetInfoRes>> getInfo(){
        try{
            List<GetInfoRes> getInfoResList = infoService.getInfo();
            return new BaseResponse(getInfoResList);
        } catch (BaseException baseException){
            return new BaseResponse(baseException.getStatus());
        }
    }
}
