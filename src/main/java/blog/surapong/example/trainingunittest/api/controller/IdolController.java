package blog.surapong.example.trainingunittest.api.controller;


import blog.surapong.example.trainingunittest.api.dto.response.GetIdolResponseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/idol")
public class IdolController {

    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public GetIdolResponseDto getIdol() {
        return null;
    }


}
