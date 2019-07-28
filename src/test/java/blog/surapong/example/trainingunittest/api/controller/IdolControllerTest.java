package blog.surapong.example.trainingunittest.api.controller;

import blog.surapong.example.trainingunittest.api.dto.request.GetIdolRequestDto;
import blog.surapong.example.trainingunittest.api.dto.response.GetIdolResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

public class IdolControllerTest {


    private MockMvc mvc;
    private JacksonTester<Object> jacksonReq;
    private JacksonTester<GetIdolResponseDto> jacksonRes;

    private IdolController idolController;
    private static final String GET_IDOL_URL = "/api/idol/user";



    @Before
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
        mvc = MockMvcBuilders.standaloneSetup(idolController).build();
    }


    @Test
    public void get_CaseSuccess_ReturnCorrect() throws Exception {
        ///////////////
        // ARRANGE
        ///////////////

        GetIdolRequestDto requestDto = new GetIdolRequestDto();
        requestDto.setName("pin");


        ///////////////
        // ACT
        ///////////////

        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.post(GET_IDOL_URL)
                .contentType(MediaType.APPLICATION_JSON).content(jacksonReq.write(requestDto).getJson()))
                .andReturn().getResponse();

        ///////////////
        // ASSERT
        //////////////

        GetIdolResponseDto responseDto = jacksonRes.parseObject(response.getContentAsString());
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }


    @Test
    public void get_CaseNotFound_ReturnError() throws Exception {
        ///////////////
        // ARRANGE
        ///////////////

        ///////////////
        // ACT
        ///////////////

        ///////////////
        // ASSERT
        //////////////
    }
}