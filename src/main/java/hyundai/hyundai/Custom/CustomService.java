package hyundai.hyundai.Custom;

import hyundai.hyundai.Custom.model.*;
import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponseStatus;
import hyundai.hyundai.User.UserRepository;
import hyundai.hyundai.Custom.model.MakeCustomReq;
import hyundai.hyundai.User.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomService {

    private final UserRepository userRepository;
    private final CustomRecordRepository customRecordRepository;
    private final CustomRepository customRepository;

    @Autowired
    public CustomService(UserRepository userRepository,
                         CustomRecordRepository customRecordRepository, CustomRepository customRepository){
        this.userRepository = userRepository;
        this.customRecordRepository = customRecordRepository;
        this.customRepository = customRepository;
    }

    @Transactional
    public SetCustomListRes setCustomList(int userIdx, CustomReq customReq) throws BaseException {
        try {
            UserEntity userEntity = userRepository.findById(userIdx).get();
            MakeCustomRecordReq makeCustomRecordReq = new MakeCustomRecordReq(userEntity);
            CustomRecordEntity customRecordEntity = makeCustomRecordReq.toEntity(); // CustomRecordEntity 생성
            customRecordRepository.save(customRecordEntity);
            // CustomEntity 데이터들 생성
            for(Integer customNumber : customReq.getBasicNumberList()) {
                if(customNumber != null) {
                    MakeCustomReq makeCustomReq = new MakeCustomReq(customNumber, customRecordEntity);
                    CustomEntity customEntity = makeCustomReq.toEntity();
                    customRepository.save(customEntity);
                }
            }
            int customRecordIdx = customRecordEntity.getCustomRecordIdx();
            return new SetCustomListRes(customRecordIdx);
        } catch (Exception exception){
            throw new BaseException(BaseResponseStatus.SERVER_ERROR);
        }
    }

    public CustomRes getCustomList(int userIdx, int customRecordIdx) throws BaseException{
        try{
            UserEntity userEntity = userRepository.findById(userIdx).get();
            CustomRecordEntity customRecordEntity = customRecordRepository.findById(customRecordIdx).get();
            List<CustomEntity> customEntityList = customRepository.getCustomList(customRecordEntity);
            CustomRes customRes = new CustomRes();

            for(CustomEntity customEntity : customEntityList){
                customRes.getBasicNumberList().add(Integer.valueOf(customEntity.getCustomNumber()));
            }


            return customRes;
        } catch (Exception exception){
            System.out.println(exception);
            System.out.println(exception.getMessage());
            System.out.println(exception.getCause());
            throw new BaseException(BaseResponseStatus.SERVER_ERROR);
        }
    }

}
