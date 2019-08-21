package com.flaregames.stackoverflow.response.internal;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;


/**
 * This is internal Response for User
 */
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {

    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("creation_date")
    private String creationDate;
    @JsonProperty("display_name")
    private String displayName;

    public UserResponse() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public UserResponse(Integer userId, String creationDate, String displayName) {
        this.userId = userId;
        this.creationDate = creationDate;
        this.displayName = displayName;
    }
}
