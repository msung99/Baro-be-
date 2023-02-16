package hyundai.hyundai.Custom;

import hyundai.hyundai.Custom.model.CustomRes;
import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponseStatus;
import hyundai.hyundai.Custom.model.CustomReq;
import hyundai.hyundai.User.UserRepository;
import hyundai.hyundai.User.model.UserEntity;
import io.swagger.models.auth.In;
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

    @Autowired
    public CustomService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional
    public void setCustomList(int userIdx, CustomReq customReq) throws BaseException {
        try {
            UserEntity userEntity = userRepository.findById(userIdx).get();

            for(Integer customNumber : customReq.getCustomNumberList()){
                userEntity.getCustomList().add(customNumber);
            }

            for(Integer customNumber : userEntity.getCustomList()){
                System.out.println(customNumber);
            }
            System.out.println("1===============================================");
            // userEntity.setCustomList(customReq.getCustomNumberList());
            // userEntity.setCustomList(customReq.getCustomNumberList());
             userRepository.save(userEntity);
            System.out.println("2===============================================");

        } catch (Exception exception){
            throw new BaseException(BaseResponseStatus.SERVER_ERROR);
        }
    }

    public CustomRes getCustomList(int userIdx) throws BaseException{
        try{
            UserEntity userEntity = userRepository.findById(userIdx).get();
            Set<Integer> customSet = new HashSet<>();

            Set<Integer> customList = userEntity.getCustomList();

            for(Integer customNumber : customList){
                System.out.println(customNumber);
                customSet.add(customNumber);
            }

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
