package hyundai.hyundai.User;

import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponseStatus;
import hyundai.hyundai.ExceptionHandler.Validation.CheckValidForm;
import hyundai.hyundai.User.model.*;
import hyundai.hyundai.utils.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Autowired
    public UserService(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public void createUser(SignupUserReq signupUserReq) throws BaseException{

        // 중복된 아이디를 가지는 유저가 또 존재하는지 확인
        String signupIdentification = signupUserReq.getIdentification();
        if(userRepository.existsUserEntityByIdentification(signupIdentification)){
            throw new BaseException(BaseResponseStatus.EXISTS_USER);
        }

        // 비밓번호와 재입력받은 비밓번호가 같은지 다른지 유효성 검사 (다르면 예외 발생)
        if(!CheckValidForm.isEqual_Passwrord_Check(signupUserReq.getPassword(), signupUserReq.getRepass())){
            throw new BaseException(BaseResponseStatus.NOT_EQUAL_PASSWORD_REPASSWORD);
        }

        if(!CheckValidForm.isValid_Password_Form(signupUserReq.getPassword())){
            throw new BaseException(BaseResponseStatus.NOT_EQUAL_PASSWORD_REPASSWORD);
        }

        try{
            UserEntity userEntity = signupUserReq.toEntity();  // DTO -> Entity 변환
            userRepository.save(userEntity);
        } catch (Exception exception){
            throw new BaseException(BaseResponseStatus.SERVER_ERROR);
        }
    }

    public LoginUserRes login(LoginUserReq loginUserReq) throws BaseException{
        try{
            // LoginUserRes loginUserRes = userRepository.findUser(loginUserReq.getEmail(), loginUserReq.getPassword());
            // return new LoginUserRes(loginUserRes.getUserIdx());
            UserEntity userEntity = userRepository.findUser(loginUserReq.getIdentification(), loginUserReq.getPassword());
            TokenDto tokenDto = jwtService.createJwt(userEntity.getUserIdx());
            return new LoginUserRes(userEntity.getUserIdx(), tokenDto.getAccessToken());
        } catch (Exception exception){
            throw new BaseException(BaseResponseStatus.NOT_EXISTS_USER);
        }
    }

    @Transactional
    public void setPeopleCount(int userIdx, int peopleCount) throws BaseException{
        try{
            UserEntity userEntity = userRepository.findById(userIdx).get();
            userEntity.setPeopleCount(peopleCount);
        } catch (Exception exception){
            throw new BaseException(BaseResponseStatus.SERVER_ERROR);
        }
    }

    @Transactional
    public int makeIdentification(IdentificationReq identificationReq) throws BaseException{
        try{
            // 중복된 아이디를 가지는 유저가 또 존재하는지 확인
            if(userRepository.existsUserEntityByIdentification(identificationReq.getIdentification())){
                throw new BaseException(BaseResponseStatus.EXISTS_USER);
            }
            UserEntity userEntity = identificationReq.toEntity();
            userRepository.save(userEntity);
            return userEntity.getUserIdx();
        } catch (Exception exception){
            throw new BaseException(BaseResponseStatus.SERVER_ERROR);
        }
    }

    @Transactional
    public void makePassword(IdentificationReq identificationReq) throws BaseException{
        try{

        } catch (Exception exception){
            throw new BaseException(BaseResponseStatus.SERVER_ERROR);
        }
    }
}
