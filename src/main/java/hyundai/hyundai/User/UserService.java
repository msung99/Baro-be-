package hyundai.hyundai.User;

import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponseStatus;
import hyundai.hyundai.ExceptionHandler.Validation.CheckValidForm;
import hyundai.hyundai.User.model.LoginUserReq;
import hyundai.hyundai.User.model.LoginUserRes;
import hyundai.hyundai.User.model.SignupUserReq;
import hyundai.hyundai.User.model.UserEntity;
import hyundai.hyundai.utils.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(signupUserReq.getEmail() == null || signupUserReq.getEmail() == ""){
            throw new BaseException(BaseResponseStatus.INVALID_EMAIL_FORM);
        }

        if(!CheckValidForm.isValidEmailForm(signupUserReq.getEmail())){
            throw new BaseException(BaseResponseStatus.INVALID_EMAIL_FORM);
        }

        // 중복된 이메일을 가지는 유저가 또 존재하는지 확인


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
            UserEntity user = userRepository.findUserEntityByEmail(loginUserReq.getEmail());
            int userIdx = jwtService.getUserIdx();

        } catch (Exception exception){
            throw new BaseException(BaseResponseStatus.NOT_EXISTS_USER);
        }
    }
}
