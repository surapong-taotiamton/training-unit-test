package blog.surapong.example.trainingunittest.api.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class GetIdolResponseDto {
    private String code;
    private String message;
    private String data;
}
