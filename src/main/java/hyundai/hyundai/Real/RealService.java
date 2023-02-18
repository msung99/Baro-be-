package hyundai.hyundai.Real;

import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponseStatus;
import hyundai.hyundai.Real.model.MakeReaReq;
import hyundai.hyundai.Real.model.MakeRealRes;
import hyundai.hyundai.User.UserRepository;
import hyundai.hyundai.User.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RealService {
    private final UserRepository userRepository;
    private final RealRepository realRepository;
    private final RealRecordRepository realRecordRepository;

    @Autowired
    public RealService(UserRepository userRepository, RealRepository realRepository, RealRecordRepository realRecordRepository){
        this.userRepository = userRepository;
        this.realRepository = realRepository;
        this.realRecordRepository = realRecordRepository;
    }

    @Transactional
    public MakeRealRes setRealList(int userIdx, MakeReaReq makeReaReq) throws BaseException {
        try{
            UserEntity userEntity = userRepository.findById(userIdx).get();

        } catch (Exception exception){
            throw new BaseException(BaseResponseStatus.SERVER_ERROR);
        }
    }
}
