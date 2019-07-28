package blog.surapong.example.trainingunittest.api.controller;

import blog.surapong.example.trainingunittest.api.dto.request.GetIdolRequestDto;
import blog.surapong.example.trainingunittest.api.dto.response.GetIdolResponseDto;
import blog.surapong.example.trainingunittest.api.service.DatabaseIdolService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class IdolControllerTest {


    private MockMvc mvc;
    private JacksonTester<Object> jacksonReq;
    private JacksonTester<GetIdolResponseDto> jacksonRes;

    @Mock
    DatabaseIdolService databaseIdolService;

    @InjectMocks
    private IdolController idolController;


    private static final String GET_IDOL_URL = "/api/idol/get";



    @Before
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
        mvc = MockMvcBuilders.standaloneSetup(idolController).build();
//        System.out.println("IN BEFORE SETUP");
//        mvc.getDispatcherServlet().getHandlerMappings().stream().map( handlerMapping -> {
//            System.out.println(handlerMapping.toString());
//            return handlerMapping.toString();
//        } );
    }


    @Test
    public void get_CaseSuccess_ReturnCorrect() throws Exception {
        ///////////////
        // ARRANGE
        ///////////////

        GetIdolRequestDto requestDto = new GetIdolRequestDto();
        requestDto.setName("pin");
        when(databaseIdolService.getIdol(eq("pin"))).thenReturn("pin:meltmallow");

        GetIdolResponseDto expectResponse = new GetIdolResponseDto()
                                                    .setCode("0")
                                                    .setMessage("success")
                                                    .setData("pin:meltmallow");

        ///////////////
        // ACT
        ///////////////

        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.post(GET_IDOL_URL)
                .contentType(MediaType.APPLICATION_JSON).content(jacksonReq.write(requestDto).getJson()))
                .andReturn().getResponse();

        ///////////////
        // ASSERT
        //////////////

        System.out.println("Response is : " + response.getContentAsString());

        GetIdolResponseDto actualResponseDto = jacksonRes.parseObject(response.getContentAsString());
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(expectResponse.getCode(), actualResponseDto.getCode());
        assertEquals(expectResponse.getMessage(), actualResponseDto.getMessage());
        assertEquals(expectResponse.getData(), actualResponseDto.getData());
    }


    @Test
    public void get_CaseNotFound_ReturnError() throws Exception {
        ///////////////
        // ARRANGE
        ///////////////

        GetIdolRequestDto requestDto = new GetIdolRequestDto();
        requestDto.setName("pin");
        when(databaseIdolService.getIdol(anyString())).thenReturn(null);

        GetIdolResponseDto expectResponse = new GetIdolResponseDto()
                .setCode("404")
                .setMessage("not found")
                .setData(null);

        ///////////////
        // ACT
        ///////////////

        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.post(GET_IDOL_URL)
                .contentType(MediaType.APPLICATION_JSON).content(jacksonReq.write(requestDto).getJson()))
                .andReturn().getResponse();

        ///////////////
        // ASSERT
        //////////////

        GetIdolResponseDto actualResponseDto = jacksonRes.parseObject(response.getContentAsString());
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(expectResponse.getCode(), actualResponseDto.getCode());
        assertEquals(expectResponse.getMessage(), actualResponseDto.getMessage());
        assertEquals(expectResponse.getData(), actualResponseDto.getData());
    }
}