
package com.flaregames.stackoverflow.response.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SOItem {

    @JsonProperty("tags")
    private List<String> tags = null;

    @JsonProperty("is_answered")
    private boolean isAnswered;

    @JsonProperty("view_count")
    private int viewCount;

    @JsonProperty("answer_count")
    private int answerCount;

    @JsonProperty("creation_date")
    private long creationDate;

    @JsonProperty("question_id")
    private int questionId;

    @JsonProperty("owner")
    private SOOwner SOOwner;

    @Override
    public String toString() {
        return "Item{" +
                "tags=" + tags +
                ", isAnswered=" + isAnswered +
                ", viewCount=" + viewCount +
                ", answerCount=" + answerCount +
                ", creationDate=" + creationDate +
                ", questionId=" + questionId +
                '}';
    }
}
