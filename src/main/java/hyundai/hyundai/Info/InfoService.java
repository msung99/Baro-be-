package hyundai.hyundai.Info;

import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponseStatus;
import hyundai.hyundai.Info.model.GetInfoRes;
import hyundai.hyundai.Info.model.InfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
