package com.flaregames.stackoverflow.controller;


import com.flaregames.stackoverflow.mapper.UserMapper;
import com.flaregames.stackoverflow.resource.UserResource;
import com.flaregames.stackoverflow.response.external.SOUserResponseWrapper;
import com.flaregames.stackoverflow.response.internal.UserResponse;
import com.flaregames.stackoverflow.service.RemoteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import static org.springframework.http.HttpStatus.OK;

/**
 * This class  acts as a Proxy for User Resource
 */
@RestController
public class UserProxyController implements UserResource {

    private RemoteUserService remoteUserService;
    private UserMapper userMapper;

    @Autowired
    public UserProxyController(RemoteUserService remoteUserService, UserMapper userMapper) {
        this.remoteUserService = remoteUserService;
        this.userMapper = userMapper;
    }

    @Override
    @Cacheable("users")
    public ResponseEntity<UserResponse> getUser(@PathVariable @Valid String userId) {

        SOUserResponseWrapper sOUserResponseWrapper = remoteUserService.getUser(userId);
        return ResponseEntity.status(OK).body(userMapper.toUserResponse(sOUserResponseWrapper));
    }
}
