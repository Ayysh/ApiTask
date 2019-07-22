package com.flaregames.stackoverflow.service;

import com.flaregames.stackoverflow.response.internal.QuestionResponse;

import java.util.List;

/**
 * This is Service interface for Question
 */
public interface QuestionService {

    /**
     * This method retrieves all the Questions
     *
     * @return List<QuestionResponse>
     */
    List<QuestionResponse> findAll();

    /**
     * This method retrieves QuestionResponse for a given QuestionId
     *
     * @param questionId
     * @return
     */
    QuestionResponse findById(int questionId);

    /**
     * This method deletes Question for a given QuestionId
     *
     * @param questionId
     */
    void deleteById(int questionId);

    /**
     * This method retrieves all questions by tagName
     *
     * @param tagName
     * @return List<QuestionResponse>
     */
    List<QuestionResponse> findByTag(String tagName);
}
