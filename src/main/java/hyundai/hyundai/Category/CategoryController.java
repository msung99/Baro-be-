package hyundai.hyundai.Category;


import hyundai.hyundai.Category.model.CategoryReq;
import hyundai.hyundai.ExceptionHandler.BaseException;
import hyundai.hyundai.ExceptionHandler.BaseResponse;
import hyundai.hyundai.utils.JwtService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/category")
@RestController
@Api(value = "Category", tags = "카테코리 관련 API")
public class CategoryController {
    private final CategoryService categoryService;
    private final JwtService jwtService;

    @Autowired
    public CategoryController(CategoryService categoryService, JwtService jwtService){
        this.categoryService = categoryService;
        this.jwtService = jwtService;
    }

    @ResponseBody
    @PostMapping("/selectCategory")
    @Operation(summary = "카테고리 선택", description = "7가지의 카테고리중 원하는 것을 선택")
    public BaseResponse selectCategory(@RequestBody CategoryReq categoryReq) {
        try{
            int userIdx = jwtService.getUserIdx();
            categoryService.selectCategory(categoryReq.getCategoryIdx(), userIdx);
            return new BaseResponse();
        } catch (BaseException baseException){
            return new BaseResponse(baseException.getStatus());
        }
    }
}
