package com.flaregames.stackoverflow.service.impl;

import com.flaregames.stackoverflow.dao.QuestionDao;
import com.flaregames.stackoverflow.mapper.QuestionMapper;
import com.flaregames.stackoverflow.response.external.SOQuestionResponseWrapper;
import com.flaregames.stackoverflow.service.InitalizeDataService;
import com.flaregames.stackoverflow.utility.RestClientProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

import static com.flaregames.stackoverflow.constants.Constants.REMOTE_STACK_OVERFLOW_QUESTION_URL;

/**
 * This class initializes the db during startup .However works only in a default setup and not in integration profile setup
 */
@Component
@ConditionalOnProperty(name = "test.mockedcontext.enabled", havingValue = "false")
public class InitializeDataServiceImpl implements InitalizeDataService {

    //Client
    private RestClientProvider restClientProvider;
    private QuestionMapper questionMapper;
    private QuestionDao questionDao;

    @Autowired
    public InitializeDataServiceImpl(RestClientProvider restClientProvider, QuestionMapper questionMapper, QuestionDao questionDao) {
        this.restClientProvider = restClientProvider;
        this.questionMapper = questionMapper;
        this.questionDao = questionDao;
    }

    // used to execute the method when the spring starts
    @PostConstruct
    public void initializeDB() {

        RestTemplate restTemplate = restClientProvider.getClient();

        SOQuestionResponseWrapper SOQuestionResponseWrapper = restTemplate.getForObject(REMOTE_STACK_OVERFLOW_QUESTION_URL, SOQuestionResponseWrapper.class);

        questionDao.save(questionMapper.toQuestionList(SOQuestionResponseWrapper));
    }

}
