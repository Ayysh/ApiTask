package com.flaregames.stackoverflow.service.impl;

import com.flaregames.stackoverflow.response.external.SOUserResponseWrapper;
import com.flaregames.stackoverflow.response.internal.UserResponse;
import com.flaregames.stackoverflow.service.RemoteUserService;
import com.flaregames.stackoverflow.utility.RestClientProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.flaregames.stackoverflow.constants.Constants.REMOTE_STACK_OVERFLOW_USER_URL;

public class RemoteUserServiceImplTest {


    RemoteUserService remoteUserService;

    RestClientProvider restClientProviderMock;


    @Before
    public void setup() {
        restClientProviderMock = Mockito.mock(RestClientProvider.class);
        remoteUserService = new RemoteUserServiceImpl(restClientProviderMock);

    }

    /**
     */
    @Test
    public void getUser() {

        //Data
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);

        SOUserResponseWrapper soUserResponseWrapper= new SOUserResponseWrapper();

        List<UserResponse> userResponses = new ArrayList<>();
        UserResponse  userResponse = UserResponse.builder().userId(10).creationDate("2011-07-17T11:01:27").displayName("kneidels").build();
        userResponses.add(userResponse);
        soUserResponseWrapper.setUserResponses(userResponses);

        //Expectation
        Mockito.when(restTemplate.getForObject(String.format(REMOTE_STACK_OVERFLOW_USER_URL, 10),SOUserResponseWrapper.class)).thenReturn(soUserResponseWrapper);

        Mockito.when(restClientProviderMock.getClient()).thenReturn(restTemplate);

        //Actual Call
        //SOUserResponseWrapper getUser(String userId)
        SOUserResponseWrapper soUserResponse = remoteUserService.getUser("10");

        //Verify
        Assert.assertEquals(10,soUserResponse.getUserResponses().get(0).getUserId().longValue());
        Assert.assertEquals("2011-07-17T11:01:27",soUserResponse.getUserResponses().get(0).getCreationDate());
        Assert.assertEquals("kneidels",soUserResponse.getUserResponses().get(0).getDisplayName());

    }
}