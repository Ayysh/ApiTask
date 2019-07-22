package com.flaregames.stackoverflow.service.impl;

import com.flaregames.stackoverflow.dao.QuestionDao;
import com.flaregames.stackoverflow.domain.Question;
import com.flaregames.stackoverflow.exception.NoQuestionFoundException;
import com.flaregames.stackoverflow.mapper.QuestionMapper;
import com.flaregames.stackoverflow.response.internal.QuestionResponse;
import com.flaregames.stackoverflow.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    public QuestionServiceImpl(QuestionDao questionDao, QuestionMapper questionMapper) {
        this.questionDao = questionDao;
        this.questionMapper = questionMapper;
    }


    private QuestionDao questionDao;

    //@Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<QuestionResponse> findAll() {
        List<Question> questionList = questionDao.findAll();
        // check if any model exists in the list
        if (questionList.isEmpty()) {
            throw new NoQuestionFoundException("No questions found");
        }
        return questionMapper.toQuestionListResponse(questionList);
    }

    @Override
    public QuestionResponse findById(int questionId) {
        Question question = questionDao.findById(questionId);
        // to check if user is present using optional, we do <obj>.isPresent
        if (question == null) {
            throw new NoQuestionFoundException(questionId + " not found");
        }
        return questionMapper.toQuestionResponse(question);
    }

    @Override
    public void deleteById(int questionId) {
        Question question = questionDao.findById(questionId);
        // to check if user is present using optional, we do <obj>.isPresent
        if (question == null) {
            throw new NoQuestionFoundException(questionId + " not found");
        }
        questionDao.deleteById(questionId);
    }

    @Override
    public List<QuestionResponse> findByTag(String tagName){
        List<Question> questionResponseList = questionDao.findByTag(tagName);
        if (questionResponseList.isEmpty()) {
            throw new NoQuestionFoundException("No questions found");
        }
        return questionMapper.toQuestionListResponse(questionResponseList);
    }
}
