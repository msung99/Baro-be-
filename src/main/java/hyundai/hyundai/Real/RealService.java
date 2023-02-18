package hyundai.hyundai.Real;

import hyundai.hyundai.Custom.model.CustomRecordEntity;
import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponseStatus;
import hyundai.hyundai.Real.model.*;
import hyundai.hyundai.User.UserRepository;
import hyundai.hyundai.User.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
            MakeRealRecordReq makeRealRecordReq = new MakeRealRecordReq(userEntity);
            RealRecordEntity realRecordEntity = makeRealRecordReq.toEntity();
            realRecordRepository.save(realRecordEntity);

            for(Integer realNumber : makeReaReq.getCustomNumberList()){
                if(realNumber != null){
                    SetRealReq setRealReq = new SetRealReq(realNumber, realRecordEntity);
                    RealEntity realEntity = setRealReq.toEntity();
                    realRepository.save(realEntity);
                }
            }
            int realIdx = realRecordEntity.getRealRecordIdx();
            return new MakeRealRes(realIdx);
        } catch (Exception exception){
            throw new BaseException(BaseResponseStatus.SERVER_ERROR);
        }
    }

    public GetRealRes getRealList(int userIdx, int customRecordIdx) throws BaseException{
        try{
            RealRecordEntity realRecordEntity = realRecordRepository.findById(customRecordIdx).get();
            List<RealEntity> realEntityList = realRepository.getRealList(realRecordEntity);
            GetRealRes getRealRes = new GetRealRes();

            for(RealEntity realEntity : realEntityList){
                getRealRes.getCustomNumberList().add(Integer.valueOf(realEntity.getRealNumber()));
            }
            return getRealRes;
        } catch (Exception exception){
            throw new BaseException(BaseResponseStatus.SERVER_ERROR);
        }
    }
}
