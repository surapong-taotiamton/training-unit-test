package blog.surapong.example.trainingunittest.api.controller;


import blog.surapong.example.trainingunittest.api.dto.request.GetIdolRequestDto;
import blog.surapong.example.trainingunittest.api.dto.response.GetIdolResponseDto;
import blog.surapong.example.trainingunittest.api.model.Idol;
import blog.surapong.example.trainingunittest.api.service.DatabaseIdolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/idol")
public class IdolController {

    @Autowired
    private DatabaseIdolService databaseIdolService;

    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public GetIdolResponseDto getIdol(@RequestBody  GetIdolRequestDto request) {

        System.out.println("Name is : " + request.getName());
        String returnData = this.databaseIdolService.getIdol(request.getName());

        if (returnData != null) {
            GetIdolResponseDto responseDto = new GetIdolResponseDto().setCode("0").setMessage("success").setData(returnData);
            return responseDto;
        } else {
            GetIdolResponseDto responseDto = new GetIdolResponseDto().setCode("404").setMessage("not found").setData(returnData);
            return responseDto;
        }

    }


}
