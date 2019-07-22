package com.flaregames.stackoverflow.mapper.impl;

import com.flaregames.stackoverflow.utility.DateConverter;
import com.flaregames.stackoverflow.mapper.UserMapper;
import com.flaregames.stackoverflow.response.external.SOUserResponseWrapper;
import com.flaregames.stackoverflow.response.internal.UserResponse;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;


@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse toUserResponse(@NotNull SOUserResponseWrapper soUserResponseWrapper) {

        return UserResponse.builder()
                .userId(soUserResponseWrapper.getUserResponses().get(0).getUserId())
                .creationDate(DateConverter.convertToDate(soUserResponseWrapper.getUserResponses().get(0).getCreationDate().toString()))
                .displayName(soUserResponseWrapper.getUserResponses().get(0).getDisplayName())
                .build();
    }
}
