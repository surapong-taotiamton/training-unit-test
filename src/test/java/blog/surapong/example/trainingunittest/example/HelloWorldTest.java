package blog.surapong.example.trainingunittest.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HelloWorldTest {

    @Before
    public void before() {
        System.out.println("Before");
    }

    @After
    public void after() {
        System.out.println("After");
    }

    @Test
    public void helloWorld_CaseBell_ReturnCorrect() throws Exception {
        ///////////////
        // ARRANGE
        ///////////////

        ///////////////
        // ACT
        ///////////////
        System.out.println("IN CASE BELL");

        ///////////////
        // ASSERT
        //////////////
    }

    @Test
    public void helloWorld_CaseNull_ReturnHelloWorld() throws Exception {
        ///////////////
        // ARRANGE
        ///////////////

        ///////////////
        // ACT
        ///////////////
        System.out.println("IN CASE NULL");

        ///////////////
        // ASSERT
        //////////////
    }
}