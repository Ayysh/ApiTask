package com.flaregames.stackoverflow.service.impl;

import com.flaregames.stackoverflow.response.external.SOUserResponseWrapper;
import com.flaregames.stackoverflow.service.RemoteUserService;
import com.flaregames.stackoverflow.utility.RestClientProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.flaregames.stackoverflow.constants.Constants.REMOTE_STACK_OVERFLOW_USER_URL;

@Service
@ConditionalOnProperty(name = "test.mockedcontext.enabled", havingValue = "false")
public class RemoteUserServiceImpl implements RemoteUserService {

    private RestClientProvider restClientProvider;

    @Autowired
    public RemoteUserServiceImpl(RestClientProvider restClientProvider) {
        this.restClientProvider = restClientProvider;
    }

    @Override
    public SOUserResponseWrapper getUser(String userId) {
        RestTemplate restTemplate = restClientProvider.getClient();
        return restTemplate.getForObject(String.format(REMOTE_STACK_OVERFLOW_USER_URL, userId), SOUserResponseWrapper.class);
    }
}
