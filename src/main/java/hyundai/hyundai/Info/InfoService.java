package hyundai.hyundai.Info;

import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponseStatus;
import hyundai.hyundai.Info.model.GetInfoRes;
import hyundai.hyundai.Info.model.InfoDummy;
import hyundai.hyundai.Info.model.InfoEntity;
import hyundai.hyundai.Info.model.InfoInputReq;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class InfoService {
    private final InfoRepository infoRepository;

    @Autowired
    public InfoService(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    public List<GetInfoRes> getInfo() throws BaseException {
        try {
            List<InfoEntity> infoEntityList = infoRepository.findAll();
            List<GetInfoRes> getInfoResList = new ArrayList<>();
            for (InfoEntity infoEntity : infoEntityList) {
                GetInfoRes getInfoRes = new GetInfoRes();
                getInfoRes.setInfoNumber(infoEntity.getInfoNumber());
                getInfoRes.setName(infoEntity.getName());
                getInfoRes.setImageUrl(infoEntity.getImageUrl());

                getInfoResList.add(getInfoRes);
            }
            return getInfoResList;
        } catch (Exception exception){
            throw new BaseException(BaseResponseStatus.SERVER_ERROR);
        }
    }

    // fake JSON API
    public Object getDummy() throws BaseException{
        try{
            String data = "";
            ClassPathResource cpr = new ClassPathResource("/dummy.json");
            byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
            data = new String(bdata, StandardCharsets.UTF_8);
            JSONParser jsonParser = new JSONParser();
            Object object = jsonParser.parse(data);
            return object;

        } catch (Exception exception){
            throw new BaseException(BaseResponseStatus.SERVER_ERROR);
        }
    }
}
