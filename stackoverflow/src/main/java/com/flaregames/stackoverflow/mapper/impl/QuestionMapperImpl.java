package com.flaregames.stackoverflow.mapper.impl;

import com.flaregames.stackoverflow.domain.Question;
import com.flaregames.stackoverflow.domain.Tag;
import com.flaregames.stackoverflow.mapper.QuestionMapper;
import com.flaregames.stackoverflow.response.external.SOQuestionResponseWrapper;
import com.flaregames.stackoverflow.response.internal.QuestionResponse;
import com.flaregames.stackoverflow.utility.DateConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class QuestionMapperImpl implements QuestionMapper {
    @Override
    public List<Question> toQuestionList(SOQuestionResponseWrapper soQuestionResponseWrapper) {

        List<Question> questionList = new ArrayList<>();

        soQuestionResponseWrapper.getSOItems().forEach(
                item -> {
                    Question question = Question.builder()
                            .id(item.getQuestionId())
                            .isAnswered(item.isAnswered())
                            .viewCount(item.getViewCount())
                            .answerCount(item.getAnswerCount())
                            .createDate(DateConverter.convertToDate(String.valueOf(item.getCreationDate())))
                            .userId(item.getSOOwner().getUserId())
                            .tags(new HashSet<>())
                            .build();

                    item.getTags().forEach(tagString -> {
                        Tag tag = new Tag(tagString);
                        question.addTag(tag);
                    });

                    questionList.add(question);
                }
        );
        return questionList;
    }

    public List<QuestionResponse> toQuestionListResponse(List<Question> questionList) {

        List<QuestionResponse> questionListResponse = new ArrayList<>();
        questionList.forEach(
                question -> {
                    QuestionResponse questionResponse = toQuestionResponse(question);
                    questionListResponse.add(questionResponse);
                });

        return questionListResponse;
    }

    /**
     * This method converts Question from DB to a question Response
     *
     * @param question
     * @return QuestionResponse
     */
    public QuestionResponse toQuestionResponse(Question question) {

        QuestionResponse questionResponse = QuestionResponse.builder()
                .id(question.getId())
                .isAnswered(question.isAnswered())
                .viewCount(question.getViewCount())
                .answerCount(question.getAnswerCount())
                .createDate(question.getCreateDate())
                .userId(question.getUserId())
                .tags(new ArrayList<>())
                .build();

        question.getTags().forEach(tag -> {
            questionResponse.getTags().add(tag.getTagName());

        });

        return questionResponse;
    }

}