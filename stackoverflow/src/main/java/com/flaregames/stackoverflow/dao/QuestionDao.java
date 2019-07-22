package com.flaregames.stackoverflow.dao;

import com.flaregames.stackoverflow.domain.Question;
import com.flaregames.stackoverflow.response.internal.QuestionResponse;

import java.util.List;

/**
 * This is Dao for Question
 */
public interface QuestionDao {

    /**
     * Saves list of Questions into DB
     * @param questionList
     * @return
     */
    List<Question> save(List<Question> questionList);

    /**
     * Retrieves all questions from DB
     * @return
     */
     List<Question> findAll();

    /**
     * Retrieves one question from DB
     * @param id
     * @return
     */
    Question findById(int id);

    /**
     * Deletes one question by id
     * @param id
     */
    void deleteById(int id);

    /**
     * Finds List of Question for a given Tag
     * @param tagName
     * @return
     */
    List<Question> findByTag(String tagName);
}
