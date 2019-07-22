
package com.flaregames.stackoverflow.response.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SOOwner {

    @JsonProperty("user_id")
    private Integer userId;

    @Override
    public String toString() {
        return "Owner{" +
                "userId=" + userId +
                '}';
    }
}
