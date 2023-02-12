package hyundai.hyundai.Aws;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
@Api(value = "file", tags = "AWS 파일 관리 API")
public class AmazonS3Controller {
    private final AwsS3Service awsS3Service;
    @PostMapping("/uploadFile")
    @Operation(summary = "파일 업로드", description = "(백엔드 더미데이터 관련 API이니, 이 API는 무시하세요)MultipartFiles 을 리스트 형태로 입력")
    public ResponseEntity<List<String>> uploadFile(List<MultipartFile> multipartFiles){
         return ResponseEntity.ok(awsS3Service.uploadFile(multipartFiles));
    }

    @DeleteMapping("/deleteFile")
    @Operation(summary = "파일 삭제", description = "(백엔드 더미데이터 관련 API이니, 이 API는 무시하세요)fileName 에 해당하는 파일 삭제")
    public ResponseEntity<String> deleteFile(@RequestParam String fileName){
        awsS3Service.deleteFile(fileName);
        return ResponseEntity.ok(fileName);
    }
}
