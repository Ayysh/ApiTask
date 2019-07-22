package com.flaregames.stackoverflow.dao.impl;

import com.flaregames.stackoverflow.dao.QuestionDao;
import com.flaregames.stackoverflow.domain.Question;
import com.flaregames.stackoverflow.domain.Tag;
import com.flaregames.stackoverflow.repository.QuestionRepository;
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
public class QuestionDaoImplTest {

    QuestionDao questionDao;
    QuestionRepository questionRepositoryMock;

    @Before
    public void setup() {

        questionRepositoryMock = Mockito.mock(QuestionRepository.class);
        questionDao = new QuestionDaoImpl(questionRepositoryMock);
    }


    @Test
    public void save() {

        List<Question> questionList = new ArrayList<>();
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

        questionList.add(question);

        Mockito.when(questionRepositoryMock.saveAll(questionList)).thenReturn(questionList);

        List<Question> questions = questionDao.save(questionList);

        Assert.assertEquals(10, questions.get(0).getId().longValue());

        Object[] tagArray = questions.get(0).getTags().toArray();

        Assert.assertEquals("java", ((Tag) tagArray[0]).getTagName());
        Assert.assertEquals("python", ((Tag) tagArray[1]).getTagName());

        Assert.assertEquals(false, questions.get(0).isAnswered());
        Assert.assertEquals(20, questions.get(0).getViewCount());
        Assert.assertEquals(0, questions.get(0).getAnswerCount());
        Assert.assertEquals("2019-07-18T06:00:09", questions.get(0).getCreateDate());
        Assert.assertEquals(172677, questions.get(0).getUserId());

    }

    /**
     *
     */
    @Test
    public void findAll() {

        List<Question> questionList = new ArrayList<>();
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

        questionList.add(question);

        Mockito.when(questionRepositoryMock.findAll()).thenReturn(questionList);
        List<Question> questions = questionDao.findAll();

        Assert.assertEquals(10, questions.get(0).getId().longValue());

        Object[] tagArray = questions.get(0).getTags().toArray();

        Assert.assertEquals("java", ((Tag) tagArray[0]).getTagName());
        Assert.assertEquals("python", ((Tag) tagArray[1]).getTagName());

        Assert.assertEquals(false, questions.get(0).isAnswered());
        Assert.assertEquals(20, questions.get(0).getViewCount());
        Assert.assertEquals(0, questions.get(0).getAnswerCount());
        Assert.assertEquals("2019-07-18T06:00:09", questions.get(0).getCreateDate());
        Assert.assertEquals(172677, questions.get(0).getUserId());
    }


    @Test
    public void findById() {

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

        Mockito.when(questionRepositoryMock.findById(10)).thenReturn(java.util.Optional.of(question));
        Question ques = questionDao.findById(10);
        Assert.assertEquals(10, ques.getId().longValue());

        Object[] tagArray = ques.getTags().toArray();

        Assert.assertEquals("java", ((Tag) tagArray[0]).getTagName());
        Assert.assertEquals("python", ((Tag) tagArray[1]).getTagName());

        Assert.assertEquals(false, ques.isAnswered());
        Assert.assertEquals(20, ques.getViewCount());
        Assert.assertEquals(0, ques.getAnswerCount());
        Assert.assertEquals("2019-07-18T06:00:09", ques.getCreateDate());
        Assert.assertEquals(172677, ques.getUserId());

    }


    @Test
    public void deleteById() {

        Mockito.doNothing().when(questionRepositoryMock).deleteById(10);
        questionDao.deleteById(10);
        Mockito.verify(questionRepositoryMock).deleteById(10);
    }

    @Test
    public void findByTag() {
        List<Question> questionList = new ArrayList<>();
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

        questionList.add(question);

        Mockito.when(questionRepositoryMock.findByTag("java")).thenReturn(questionList);
        List<Question> questions = questionDao.findByTag("java");

        Assert.assertEquals(10, questions.get(0).getId().longValue());

        Object[] tagArray = questions.get(0).getTags().toArray();

        Assert.assertEquals("java", ((Tag) tagArray[0]).getTagName());
        Assert.assertEquals("python", ((Tag) tagArray[1]).getTagName());

        Assert.assertEquals(false, questions.get(0).isAnswered());
        Assert.assertEquals(20, questions.get(0).getViewCount());
        Assert.assertEquals(0, questions.get(0).getAnswerCount());
        Assert.assertEquals("2019-07-18T06:00:09", questions.get(0).getCreateDate());
        Assert.assertEquals(172677, questions.get(0).getUserId());
    }
}