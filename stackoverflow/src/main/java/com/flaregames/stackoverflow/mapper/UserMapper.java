package com.flaregames.stackoverflow.mapper;

import com.flaregames.stackoverflow.response.external.SOUserResponseWrapper;
import com.flaregames.stackoverflow.response.internal.UserResponse;


/**
 * This is mapper interface used to map Response to domain objects and viceversa
 */
public interface UserMapper {

    /**
     * This method converts SOUserResponseWrapper to UserResponse
     * @param soUserResponseWrapper
     * @return UserResponse
     */
    UserResponse toUserResponse(SOUserResponseWrapper soUserResponseWrapper);
}
