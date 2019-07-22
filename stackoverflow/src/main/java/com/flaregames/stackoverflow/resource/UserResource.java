package com.flaregames.stackoverflow.resource;


import com.flaregames.stackoverflow.response.internal.UserResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.flaregames.stackoverflow.constants.Constants.GET_USER_RESOURCE_URL;
import static com.flaregames.stackoverflow.constants.Constants.STACK_OVERFLOW_BASE_URL;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * This is Rest API Interface for UserResource
 */
@RequestMapping(STACK_OVERFLOW_BASE_URL)
@Api(description = "REST apis for the user resource", tags = "User Resource")
public interface UserResource {

    /**
     * This method returns user details by his ID from  stack overflow
     */
    @ApiOperation(value = "The endpoint returns a user from stack overflow", response = UserResponse.class)
    @GetMapping(path = GET_USER_RESOURCE_URL, produces = APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<UserResponse> getUser(@ApiParam("The User Id")  String userId);
}
