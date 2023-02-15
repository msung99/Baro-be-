package hyundai.hyundai.Custom;

import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponseStatus;
import hyundai.hyundai.Custom.model.CustomReq;
import hyundai.hyundai.User.UserRepository;
import hyundai.hyundai.User.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            // userEntity.setCustomList(customReq.getCustomNumberList());
            userRepository.save(userEntity);
        } catch (Exception exception){
            throw new BaseException(BaseResponseStatus.SERVER_ERROR);
        }
    }
}
