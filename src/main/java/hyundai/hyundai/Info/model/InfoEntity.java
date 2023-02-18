package hyundai.hyundai.Info.model;

import io.swagger.annotations.Api;
import lombok.*;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;


@Entity
@Table(name = "Info")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter @Builder
public class InfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int infoIdx;

    private int infoNumber;
    private String imageUrl;
    private String name;

    public InfoEntity(int infoNumber, String imageUrl, String name){
        this.infoNumber = infoNumber;
        this.imageUrl = imageUrl;
        this.name = name;
    }
}
