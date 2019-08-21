package com.flaregames.stackoverflow.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flaregames.stackoverflow.response.external.SOUserResponseWrapper;
import com.flaregames.stackoverflow.service.RemoteUserService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
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
        //Get the classloader from object
        ClassLoader classLoader = getClass().getClassLoader();
        //First get inputStream to file "responses/UserResponse.json" in resources folder by
        // using getResourceAsStream method  in classLoader
        InputStream inputStream = classLoader.getResourceAsStream("responses/UserResponse.json");
        //Scanner is used to read the input from inputStream
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        //read the stream into String Object
        String responseString = scanner.useDelimiter("\\A").next();
        SOUserResponseWrapper soUserResponseWrapper = new SOUserResponseWrapper();
        try {
            //ObjectMapper is jackson lib that converts json string into corresponding java object
            soUserResponseWrapper = objectMapper.readValue(responseString, SOUserResponseWrapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return soUserResponseWrapper;
    }
}
