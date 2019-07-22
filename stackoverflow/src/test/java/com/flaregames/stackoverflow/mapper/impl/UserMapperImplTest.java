package com.flaregames.stackoverflow.mapper.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flaregames.stackoverflow.response.external.SOUserResponseWrapper;
import com.flaregames.stackoverflow.response.internal.UserResponse;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Scanner;


@SpringBootTest
public class UserMapperImplTest {

    UserMapperImpl userMapper = new UserMapperImpl();

    @Test
    public void toUserResponse() throws IOException {

        //Data Setup
        ObjectMapper objectMapper = new ObjectMapper();
        //Convert to java object
        ClassLoader classLoader = getClass().getClassLoader();

        String responseString = new Scanner(classLoader.getResourceAsStream("responses/UserResponse.json"), "UTF-8").useDelimiter("\\A").next();

        SOUserResponseWrapper SOUserResponseWrapper = objectMapper.readValue(responseString, SOUserResponseWrapper.class);

        UserResponse userResponse = userMapper.toUserResponse(SOUserResponseWrapper);

        Assert.assertEquals(848513, userResponse.getUserId().longValue());
        Assert.assertEquals("2011-07-17T11:01:27", userResponse.getCreationDate());
        Assert.assertEquals("kneidels", userResponse.getDisplayName());
    }
}