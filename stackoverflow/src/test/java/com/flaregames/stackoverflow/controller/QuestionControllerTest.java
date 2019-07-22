package com.flaregames.stackoverflow.controller;

import com.flaregames.stackoverflow.response.internal.QuestionResponse;
import com.flaregames.stackoverflow.service.QuestionService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

@SpringBootTest
public class QuestionControllerTest {


    QuestionService questionServiceMock;
    QuestionController classUnderTest;

    @Before
    public void setup() {

        questionServiceMock = Mockito.mock(QuestionService.class);
        classUnderTest = new QuestionController(questionServiceMock);
    }

    @Test
    public void testRetrieveAll() {
        //Data
        List<QuestionResponse> questionResponseList = new ArrayList<>();
        //Expectation
        Mockito.when(questionServiceMock.findAll()).thenReturn(questionResponseList);
        //Call
        ResponseEntity<List<QuestionResponse>> response = classUnderTest.retrieveAll();
        List<QuestionResponse> questionResponses = response.getBody();
        //Assert
        assertEquals(questionResponseList, questionResponses);
    }

    @Test
    public void testRetrieveOne() {
        QuestionResponse questionResponse = new QuestionResponse();
        //Expectation
        Mockito.when(questionServiceMock.findById(10)).thenReturn(questionResponse);
        //Call
        ResponseEntity<QuestionResponse> response = classUnderTest.retrieveOne(10);
        QuestionResponse actualResponse = response.getBody();
        //Assert
        assertEquals(questionResponse, actualResponse);
    }

    @Test
    public void testDeleteOne() {

        Mockito.doNothing().when(questionServiceMock).deleteById(10);
        //ACtual call
        ResponseEntity<Void> response = classUnderTest.deleteOne(10);

        //Verify that method is called correctly
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals(204, response.getStatusCode().value());
    }

    /*

     */
    @Test
    public void testRetrieveQuestionByTag() {

        List<QuestionResponse> questionResponseList = new ArrayList<>();

        Mockito.when(questionServiceMock.findByTag("java")).thenReturn(questionResponseList);

        ResponseEntity<List<QuestionResponse>> actualResponseEntity = classUnderTest.retrieveQuestionByTag("java");

        List<QuestionResponse> actualQuestionResponse = actualResponseEntity.getBody();

        //Verify that method is called correctly
        assertEquals(HttpStatus.OK, actualResponseEntity.getStatusCode());
        assertEquals(questionResponseList, actualQuestionResponse);

    }
}