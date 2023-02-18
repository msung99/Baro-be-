package hyundai.hyundai.Info.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInfoRes {
    private int infoNumber;
    private String imageUrl;
    private String name;
}
