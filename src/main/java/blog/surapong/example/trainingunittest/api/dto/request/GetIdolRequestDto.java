package blog.surapong.example.trainingunittest.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class GetIdolRequestDto {

    private String name;

}
