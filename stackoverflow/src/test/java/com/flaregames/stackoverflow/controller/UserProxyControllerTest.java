package com.flaregames.stackoverflow.controller;

import com.flaregames.stackoverflow.mapper.UserMapper;
import com.flaregames.stackoverflow.response.external.SOUserResponseWrapper;
import com.flaregames.stackoverflow.response.internal.UserResponse;
import com.flaregames.stackoverflow.service.RemoteUserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.testng.Assert.assertEquals;

public class UserProxyControllerTest {

    private RemoteUserService remoteUserServiceMock;
    private UserMapper userMapperMock;
    private UserProxyController classUnderTest;

    @Before
    public void setup() {

        remoteUserServiceMock = Mockito.mock(RemoteUserService.class);
        userMapperMock = Mockito.mock(UserMapper.class);
        classUnderTest = new UserProxyController(remoteUserServiceMock, userMapperMock);
    }

    @Test
    public void testGetUser() {

        //Data
        SOUserResponseWrapper sOUserResponseWrapper = new SOUserResponseWrapper();
        UserResponse userResponse = new UserResponse();

        //Expectation
        Mockito.when(remoteUserServiceMock.getUser("12345")).thenReturn(sOUserResponseWrapper);
        Mockito.when(userMapperMock.toUserResponse(sOUserResponseWrapper)).thenReturn(userResponse);

        ResponseEntity<UserResponse> responseEntity = classUnderTest.getUser("12345");

        assertEquals(200, responseEntity.getStatusCode().value());

    }
}