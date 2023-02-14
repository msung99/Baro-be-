package hyundai.hyundai.Category;

import hyundai.hyundai.Category.model.CategoryEntity;
import hyundai.hyundai.Category.model.GetPeopleCategory;
import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponseStatus;
import hyundai.hyundai.User.UserRepository;
import hyundai.hyundai.User.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository,
                           UserRepository userRepository){
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    void selectCategory(int categoryIdx, int userIdx) throws BaseException {
        try {
            CategoryEntity categoryEntity = categoryRepository.findById(categoryIdx).get();
            UserEntity userEntity = userRepository.findById(userIdx).get();
            userEntity.setCategory(categoryEntity);
            System.out.println(userEntity.getCategory().getCategoryName());
            System.out.println(userEntity.getCategory().getCategoryIdx());
        } catch (Exception exception){
            throw new BaseException(BaseResponseStatus.SERVER_ERROR);
        }
    }

    GetPeopleCategory getSelectInfo(int userIdx) throws BaseException{
        try{
            GetPeopleCategory getPeopleCategory = userRepository.getSelectInfo(userIdx);
            return getPeopleCategory;
        } catch (Exception exception){
            throw new BaseException(BaseResponseStatus.SERVER_ERROR);
        }
    }
}
