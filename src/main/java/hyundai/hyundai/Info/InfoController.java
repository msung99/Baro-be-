package hyundai.hyundai.Info;


import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponse;
import hyundai.hyundai.Info.model.GetInfoRes;
import hyundai.hyundai.Info.model.InfoDummy;
import hyundai.hyundai.Info.model.InfoInputReq;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.catalina.LifecycleState;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;

import java.io.*;
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
    @Operation(summary = "모든 디폴트 더미 데이터 조회", description = "infoNumber, imageUrl, name 필드를 조회합니다. / 스웨거에서 'execute' 버튼 누르면 모든 값들 싹다 조회됩니다!")
    public BaseResponse<Object> getDummyListInJsonFile(){
        try{
            Object object = infoService.insertDummy();
            System.out.println(object);
            return new BaseResponse(object);
        } catch (BaseException baseException) {
            return new BaseResponse(baseException.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/getDBdummyData")
    @Operation(summary = "DB에 존재하는 모든 디폴트 데이터 조회", description = "백엔드에서만 사용하는 테스트 API 이므로 무시하셔도 됩니다!")
    public BaseResponse<List<GetInfoRes>> getInfo(){
        try{
            List<GetInfoRes> getInfoResList = infoService.getInfo();
            return new BaseResponse(getInfoResList);
        } catch (BaseException baseException){
            return new BaseResponse(baseException.getStatus());
        }
    }

        // List<InfoDummy> infoDummyList = infoInputReq.getInfoDummyList();
        // Reader reader = new FileReader("dummy.json");
        // infoService.insertDummy(infoDummyList);
        // infoService.insertDummy();
        // ResourceLoader resourceLoader;
        // InputStream file = (InputStream) resourceLoader.getResource("dummy.json");
}
