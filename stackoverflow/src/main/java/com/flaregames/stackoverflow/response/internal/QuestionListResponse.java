package com.flaregames.stackoverflow.response.internal;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * This is internal Response for Question List
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionListResponse {

    @JsonProperty("list")
    private List<QuestionResponse> questionResponseList = new ArrayList<>();

    @Override
    public String toString() {
        return "QuestionListResponse{" +
                "questionResponseList=" + questionResponseList +
                '}';
    }
}
