package com.flaregames.stackoverflow.response.internal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;


/**
 * This is internal Response for Question
 */
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionResponse {

    @JsonProperty("question_id")
    private Integer id;

    @JsonProperty("tags")
    private List<String> tags = null;

    @JsonProperty("is_answered")
    private boolean isAnswered;

    @JsonProperty("view_count")
    private int viewCount;

    @JsonProperty("answer_count")
    private int answerCount;

    @JsonProperty("creation_date")
    private String createDate;

    @JsonProperty("user_id")
    private int userId;

    public QuestionResponse() {
    }

    public QuestionResponse(Integer id, List<String> tags, boolean isAnswered, int viewCount, int answerCount, String createDate, int userId) {
        this.id = id;
        this.tags = tags;
        this.isAnswered = isAnswered;
        this.viewCount = viewCount;
        this.answerCount = answerCount;
        this.createDate = createDate;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "QuestionResponse{" +
                "id=" + id +
                ", tags=" + tags +
                ", isAnswered=" + isAnswered +
                ", viewCount=" + viewCount +
                ", answerCount=" + answerCount +
                ", createDate='" + createDate + '\'' +
                ", userId=" + userId +
                '}';
    }

}
