package com.flaregames.stackoverflow.service.impl;

import com.flaregames.stackoverflow.dao.QuestionDao;
import com.flaregames.stackoverflow.domain.Question;
import com.flaregames.stackoverflow.mapper.QuestionMapper;
import com.flaregames.stackoverflow.response.external.SOQuestionResponseWrapper;
import com.flaregames.stackoverflow.service.InitalizeDataService;
import com.flaregames.stackoverflow.utility.RestClientProvider;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.flaregames.stackoverflow.constants.Constants.REMOTE_STACK_OVERFLOW_QUESTION_URL;

@SpringBootTest
public class InitializeDataServiceImplTest {

    InitalizeDataService initalizeDataService;

    RestClientProvider restClientProviderMock;

    QuestionDao questionDaoMock;

    QuestionMapper questionMapperMock;

    @Before
    public void setup() {
        questionDaoMock = Mockito.mock(QuestionDao.class);
        questionMapperMock = Mockito.mock(QuestionMapper.class);
        restClientProviderMock = Mockito.mock(RestClientProvider.class);
        initalizeDataService = new InitializeDataServiceImpl(restClientProviderMock, questionMapperMock, questionDaoMock);

    }


    @Test
    public void initializeDB(){

        //Data
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        SOQuestionResponseWrapper SOQuestionResponseWrapper = new SOQuestionResponseWrapper();
        List<Question> questionList = new ArrayList<>();

        //Expectation
        Mockito.when(restTemplate.getForObject(REMOTE_STACK_OVERFLOW_QUESTION_URL, SOQuestionResponseWrapper.class)).thenReturn(SOQuestionResponseWrapper);
        Mockito.when(questionMapperMock.toQuestionList(SOQuestionResponseWrapper)).thenReturn(questionList);
        Mockito.when(questionDaoMock.save(questionList)).thenReturn(questionList);
        Mockito.when(restClientProviderMock.getClient()).thenReturn(restTemplate);

        //Actual Call
        initalizeDataService.initializeDB();

        //Verify if a certain method of a mock object has been called by specific number of times
        Mockito.verify(questionMapperMock).toQuestionList(SOQuestionResponseWrapper);
        Mockito.verify(questionDaoMock).save(questionList);
        Mockito.verify(restClientProviderMock).getClient();
    }
}