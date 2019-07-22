package com.flaregames.stackoverflow.service;


import com.flaregames.stackoverflow.response.external.SOUserResponseWrapper;

public interface RemoteUserService {

    /**
     *
     * @param userId
     * @return
     */
    SOUserResponseWrapper getUser(String userId);
}
