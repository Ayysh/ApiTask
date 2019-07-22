
package com.flaregames.stackoverflow.response.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * This is ResponseWrapper for Questions fetched from StackOverflow
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SOQuestionResponseWrapper {

    @JsonProperty("items")
    private List<SOItem> SOItems = new ArrayList<>();

    public List<SOItem> getSOItems() {
        return SOItems;
    }

    public void setSOItems(List<SOItem> SOItems) {
        this.SOItems = SOItems;
    }

    @Override
    public String toString() {
        return "QuestionSOResponseWrapper{" +
                "items=" + SOItems +
                '}';
    }
}
