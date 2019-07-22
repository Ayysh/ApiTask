package com.flaregames.stackoverflow.mapper;

import com.flaregames.stackoverflow.domain.Question;
import com.flaregames.stackoverflow.response.external.SOQuestionResponseWrapper;
import com.flaregames.stackoverflow.response.internal.QuestionResponse;

import java.util.List;

/**
 * This is mapper interface used to map Response to domain objects and viceversa
 */
public interface QuestionMapper {

    /**
     * This method converts SOQuestionResponseWrapper to List<Question>
     *
     * @param soQuestionResponseWrapper
     * @return List<Question>
     */
    List<Question> toQuestionList(SOQuestionResponseWrapper soQuestionResponseWrapper);

    /**
     * This method converts List<Question> to List<QuestionResponse>
     *
     * @param questionList
     * @return List<QuestionResponse>
     */
    List<QuestionResponse> toQuestionListResponse(List<Question> questionList);

    /**
     * This method converts Question to QuestionResponse
     *
     * @param question
     * @return
     */
    QuestionResponse toQuestionResponse(Question question);
}
