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

import java.util.HashSet;
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
    public void setCustomList(int userIdx, CustomReq customReq) throws BaseException {
        try {
            UserEntity userEntity = userRepository.findById(userIdx).get();
            MakeCustomRecordReq makeCustomRecordReq = new MakeCustomRecordReq(userEntity);
            CustomRecordEntity customRecordEntity = makeCustomRecordReq.toEntity(); // CustomRecordEntity 생성
            customRecordRepository.save(customRecordEntity);
            // CustomEntity 데이터들 생성
            for(Integer customNumber : customReq.getCustomNumberList()){
                MakeCustomReq makeCustomReq = new MakeCustomReq(customNumber, customRecordEntity);
                CustomEntity customEntity = makeCustomReq.toEntity();
                customRepository.save(customEntity);
            }

        } catch (Exception exception){
            throw new BaseException(BaseResponseStatus.SERVER_ERROR);
        }
    }

    public CustomRes getCustomList(int userIdx) throws BaseException{
        try{
            UserEntity userEntity = userRepository.findById(userIdx).get();
            Set<Integer> customSet = new HashSet<>();

            // Set<Integer> customList = userEntity.getCustomList();

            CustomRes customRes = new CustomRes();
            for(Integer custom : customSet){
                customRes.getCustomNumberList().add(custom);
            }
            return customRes;
        } catch (Exception exception){
            throw new BaseException(BaseResponseStatus.SERVER_ERROR);
        }
    }

}
