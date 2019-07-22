package com.flaregames.stackoverflow.dao.impl;


import com.flaregames.stackoverflow.dao.QuestionDao;
import com.flaregames.stackoverflow.domain.Question;
import com.flaregames.stackoverflow.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class QuestionDaoImpl implements QuestionDao {


   private QuestionRepository questionRepository;

    @Autowired
    public QuestionDaoImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> save(List<Question> questionList) {

        return questionRepository.saveAll(questionList);
    }

    @Override
    public List<Question> findAll() {

        return questionRepository.findAll();
    }

    @Override
    public Question findById(int id) {

        Optional<Question> questionOptional = questionRepository.findById(id);
        if(questionOptional.isPresent())
        {
            return questionOptional.get();
        }
       else
        {
            return null;
        }
    }

    @Override
    public void deleteById(int id) {

        questionRepository.deleteById(id);
    }

    @Override
    public List<Question> findByTag(String tagName){

        return questionRepository.findByTag(tagName);
    }
}
