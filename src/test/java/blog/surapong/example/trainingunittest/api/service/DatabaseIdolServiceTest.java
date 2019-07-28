package blog.surapong.example.trainingunittest.api.service;

import blog.surapong.example.trainingunittest.api.model.Idol;
import blog.surapong.example.trainingunittest.api.repository.IdolRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class DatabaseIdolServiceTest {

    IdolRepository idolRepository;

    @Test
    public void getIdol_CaseFound_ReturnCorrect() throws Exception {
        ///////////////
        // ARRANGE
        ///////////////
        String IDOL_NAME = "pin";
        String IDOL_DESCRIPTION = "pin:meltmallow";

        idolRepository = mock(IdolRepository.class);
        Idol returnModel = new Idol().setName(IDOL_NAME).setDescription(IDOL_DESCRIPTION);
        when(idolRepository.findById(eq("pin"))).thenReturn(Optional.of(returnModel));

        DatabaseIdolService databaseIdolService = new DatabaseIdolService(idolRepository);
        ///////////////
        // ACT
        ///////////////

        String returnData = databaseIdolService.getIdol(IDOL_NAME);

        ///////////////
        // ASSERT
        //////////////

        assertEquals(IDOL_DESCRIPTION, returnData);
    }

    @Test
    public void getIdol_CaseNotFound_ReturnNull() throws Exception {
        ///////////////
        // ARRANGE
        ///////////////
        idolRepository = mock(IdolRepository.class);
        when(idolRepository.findById(anyString())).thenReturn(Optional.empty());

        DatabaseIdolService databaseIdolService = new DatabaseIdolService(idolRepository);
        ///////////////
        // ACT
        ///////////////

        String returnData = databaseIdolService.getIdol("pin");


        ///////////////
        // ASSERT
        //////////////

        assertEquals(null, returnData);
    }

}