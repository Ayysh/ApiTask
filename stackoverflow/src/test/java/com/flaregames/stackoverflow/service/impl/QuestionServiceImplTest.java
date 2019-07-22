package com.flaregames.stackoverflow.service.impl;

import com.flaregames.stackoverflow.dao.QuestionDao;
import com.flaregames.stackoverflow.domain.Question;
import com.flaregames.stackoverflow.domain.Tag;
import com.flaregames.stackoverflow.mapper.QuestionMapper;
import com.flaregames.stackoverflow.response.internal.QuestionResponse;
import com.flaregames.stackoverflow.service.QuestionService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SpringBootTest
public class QuestionServiceImplTest {

    QuestionService questionService;

    QuestionDao questionDaoMock;

    QuestionMapper questionMapperMock;

    @Before
    public void setup() {
        questionDaoMock = Mockito.mock(QuestionDao.class);
        questionMapperMock = Mockito.mock(QuestionMapper.class);
        questionService = new QuestionServiceImpl(questionDaoMock, questionMapperMock);

    }

    @Test
    public void findAll() {

        List<String> tags = new ArrayList<>();
        tags.add("python");
        tags.add("java");
        List<QuestionResponse> questionResponses = new ArrayList<>();
        questionResponses.add(new QuestionResponse(27, tags, false, 20, 0, "2019-07-18T06:00:09", 10));

        List<Question> questionsList = new ArrayList<>();

        Set<Tag> tag = new HashSet<>();
        tag.add(new Tag("python"));
        tag.add(new Tag("java"));

        questionsList.add(new Question(27, tag, false, 20, 0, "2019-07-18T06:00:09", 10));

        Mockito.when(questionDaoMock.findAll()).thenReturn(questionsList);
        Mockito.when(questionMapperMock.toQuestionListResponse(questionsList)).thenReturn(questionResponses);

        List<QuestionResponse> questionResponseList = questionService.findAll();

        Assert.assertEquals(27, questionResponseList.get(0).getId().longValue());

        Assert.assertEquals("python", questionResponseList.get(0).getTags().get(0));
        Assert.assertEquals("java", questionResponseList.get(0).getTags().get(1));

        Assert.assertEquals(false, questionResponseList.get(0).isAnswered());
        Assert.assertEquals(20, questionResponseList.get(0).getViewCount());
        Assert.assertEquals(0, questionResponseList.get(0).getAnswerCount());
        Assert.assertEquals("2019-07-18T06:00:09", questionResponseList.get(0).getCreateDate());
        Assert.assertEquals(10, questionResponseList.get(0).getUserId());

    }

    /**
     *
     */
    @Test
    public void findById() {


        List<String> tags = new ArrayList<>();
        tags.add("python");
        tags.add("java");
        QuestionResponse questionResponse = new QuestionResponse();
        questionResponse.setId(10);
        questionResponse.setAnswerCount(0);
        questionResponse.setViewCount(20);
        questionResponse.setAnswered(false);
        questionResponse.setCreateDate("2019-07-18T06:00:09");
        questionResponse.setUserId(172677);
        questionResponse.setTags(tags);

        Question question = new Question();
        Set<Tag> tag = new HashSet<>();
        tag.add(new Tag("python"));
        tag.add(new Tag("java"));

        question.setId(10);
        question.setAnswerCount(0);
        question.setViewCount(20);
        question.setAnswered(false);
        question.setCreateDate("2019-07-18T06:00:09");
        question.setUserId(172677);
        question.setTags(tag);

        Mockito.when(questionDaoMock.findById(10)).thenReturn(question);
        Mockito.when(questionMapperMock.toQuestionResponse(question)).thenReturn(questionResponse);

        QuestionResponse quesResponse = questionService.findById(10);

        Assert.assertEquals(10, quesResponse.getId().longValue());

        Assert.assertEquals("python", quesResponse.getTags().get(0));
        Assert.assertEquals("java", quesResponse.getTags().get(1));

        Assert.assertEquals(false, quesResponse.isAnswered());
        Assert.assertEquals(20, quesResponse.getViewCount());
        Assert.assertEquals(0, quesResponse.getAnswerCount());
        Assert.assertEquals("2019-07-18T06:00:09", quesResponse.getCreateDate());
        Assert.assertEquals(172677, quesResponse.getUserId());

    }

    /**
     */
    @Test
    public void deleteById() {

        //Data
        Question question = new Question();

        //Expectations
        Mockito.when(questionDaoMock.findById(10)).thenReturn(question);
        Mockito.doNothing().when(questionDaoMock).deleteById(10);

        //ACtual call
        questionService.deleteById(10);

        //Verify that method is called correctly
        Mockito.verify(questionDaoMock).deleteById(10);

    }

    /**
     *
     */
    @Test
    public void findByTag() {

        List<String> tags = new ArrayList<>();
        tags.add("python");
        tags.add("java");
        List<QuestionResponse> questionResponses = new ArrayList<>();
        questionResponses.add(new QuestionResponse(27, tags, false, 20, 0, "2019-07-18T06:00:09", 10));

        List<Question> questionsList = new ArrayList<>();

        Set<Tag> tag = new HashSet<>();
        tag.add(new Tag("python"));
        tag.add(new Tag("java"));

        questionsList.add(new Question(27, tag, false, 20, 0, "2019-07-18T06:00:09", 10));

        Mockito.when(questionDaoMock.findByTag("python")).thenReturn(questionsList);
        Mockito.when(questionMapperMock.toQuestionListResponse(questionsList)).thenReturn(questionResponses);

        List<QuestionResponse> questionResponseList = questionService.findByTag("python");

        Assert.assertEquals(27, questionResponseList.get(0).getId().longValue());

        Assert.assertEquals("python", questionResponseList.get(0).getTags().get(0));
        Assert.assertEquals("java", questionResponseList.get(0).getTags().get(1));

        Assert.assertEquals(false, questionResponseList.get(0).isAnswered());
        Assert.assertEquals(20, questionResponseList.get(0).getViewCount());
        Assert.assertEquals(0, questionResponseList.get(0).getAnswerCount());
        Assert.assertEquals("2019-07-18T06:00:09", questionResponseList.get(0).getCreateDate());
        Assert.assertEquals(10, questionResponseList.get(0).getUserId());
    }
}