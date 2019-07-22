package com.flaregames.stackoverflow.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flaregames.stackoverflow.response.external.SOUserResponseWrapper;
import com.flaregames.stackoverflow.service.RemoteUserService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class is enabled only to work during IntegrationTest
 */
@Service
@ConditionalOnProperty(name = "test.mockedcontext.enabled", havingValue = "true")
public class RemoteUserServiceImplMock implements RemoteUserService {


    @Override
    public SOUserResponseWrapper getUser(String userId) {

        //Data Setup
        ObjectMapper objectMapper = new ObjectMapper();
        //Convert to java object
        ClassLoader classLoader = getClass().getClassLoader();

        String responseString = new Scanner(classLoader.getResourceAsStream("responses/UserResponse.json"), "UTF-8").useDelimiter("\\A").next();

        SOUserResponseWrapper soUserResponseWrapper = new SOUserResponseWrapper();
        try {
            soUserResponseWrapper = objectMapper.readValue(responseString, SOUserResponseWrapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return soUserResponseWrapper;
    }
}
