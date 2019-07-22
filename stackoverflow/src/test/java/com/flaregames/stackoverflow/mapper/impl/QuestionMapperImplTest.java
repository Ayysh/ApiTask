package com.flaregames.stackoverflow.mapper.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flaregames.stackoverflow.domain.Question;
import com.flaregames.stackoverflow.domain.Tag;
import com.flaregames.stackoverflow.response.external.SOQuestionResponseWrapper;
import com.flaregames.stackoverflow.response.internal.QuestionResponse;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@SpringBootTest
public class QuestionMapperImplTest {

    QuestionMapperImpl classUnderTest = new QuestionMapperImpl();

    @Test
    public void toQuestionList() throws IOException {

        //Data Setup
        ObjectMapper objectMapper = new ObjectMapper();
        //Convert to java object
        ClassLoader classLoader = getClass().getClassLoader();

        String responseString = new Scanner(classLoader.getResourceAsStream("responses/SOQuestionResponse.json"), "UTF-8").useDelimiter("\\A").next();

        SOQuestionResponseWrapper SOQuestionResponseWrapper = objectMapper.readValue(responseString, SOQuestionResponseWrapper.class);

        List<Question> questions = classUnderTest.toQuestionList(SOQuestionResponseWrapper);

        Assert.assertEquals(57086935,questions.get(0).getId().longValue());
        Assert.assertEquals(false,questions.get(0).isAnswered());
        Assert.assertEquals(67,questions.get(0).getViewCount());
        Assert.assertEquals(0,questions.get(0).getAnswerCount());
        Assert.assertEquals(172677,questions.get(0).getUserId());

        Object[] tagArray= questions.get(0).getTags().toArray();

        Assert.assertEquals("pandas",((Tag)tagArray[0]).getTagName());
        Assert.assertEquals("python",((Tag)tagArray[1]).getTagName());
        Assert.assertEquals("numpy",((Tag)tagArray[2]).getTagName());

        Assert.assertEquals("2019-07-18T06:00:09",questions.get(0).getCreateDate());

    }
/*
List<QuestionResponse> toQuestionListResponse(List<Question> questionList)
 */

    @Test
    public void toQuestionListResponse() {

        List<Question> questions = new ArrayList<>();

        Set<Tag> tag = new HashSet<>();
        tag.add(new Tag("python"));
        tag.add(new Tag("java"));

        questions.add(new Question(57086935, tag,false,20,0,"2019-07-18T06:00:09",172677));

        List<QuestionResponse> questionResponseList =  classUnderTest.toQuestionListResponse(questions);
        Assert.assertEquals(57086935,questionResponseList.get(0).getId().longValue());

        Assert.assertEquals("java",questionResponseList.get(0).getTags().get(0));
        Assert.assertEquals("python",questionResponseList.get(0).getTags().get(1));

        Assert.assertEquals(false,questionResponseList.get(0).isAnswered());
        Assert.assertEquals(20,questionResponseList.get(0).getViewCount());
        Assert.assertEquals(0,questionResponseList.get(0).getAnswerCount());
        Assert.assertEquals("2019-07-18T06:00:09",questionResponseList.get(0).getCreateDate());
        Assert.assertEquals(172677,questionResponseList.get(0).getUserId());
    }

    /**
     * QuestionResponse toQuestionResponse(Question question)
     */

    @Test
    public void toQuestionResponse() {

        Question question = new Question();
        Set<Tag> tag = new HashSet<>();
        tag.add(new Tag("python"));
        tag.add(new Tag("java"));

        question.setId(57086935);
        question.setAnswerCount(0);
        question.setViewCount(20);
        question.setAnswered(false);
        question.setCreateDate("2019-07-18T06:00:09");
        question.setUserId(172677);
        question.setTags(tag);

        QuestionResponse questionResponse =  classUnderTest.toQuestionResponse(question);
        Assert.assertEquals(57086935,questionResponse.getId().longValue());

        Assert.assertEquals("java",questionResponse.getTags().get(0));
        Assert.assertEquals("python",questionResponse.getTags().get(1));
        Assert.assertEquals(false,questionResponse.isAnswered());
        Assert.assertEquals(20,questionResponse.getViewCount());
        Assert.assertEquals(0,questionResponse.getAnswerCount());
        Assert.assertEquals("2019-07-18T06:00:09",questionResponse.getCreateDate());
        Assert.assertEquals(172677,questionResponse.getUserId());
    }
}