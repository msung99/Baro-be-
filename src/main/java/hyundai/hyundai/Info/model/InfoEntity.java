package hyundai.hyundai.Info.model;

import io.swagger.annotations.Api;
import lombok.*;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;


@Entity
@Table(name = "info")
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
}
