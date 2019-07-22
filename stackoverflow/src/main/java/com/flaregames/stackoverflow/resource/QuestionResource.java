package com.flaregames.stackoverflow.resource;

import com.flaregames.stackoverflow.response.internal.QuestionResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.flaregames.stackoverflow.constants.Constants.GET_QUESTIONBYID_RESOURCE_URL;
import static com.flaregames.stackoverflow.constants.Constants.GET_QUESTIONS_RESOURCE_URL;
import static com.flaregames.stackoverflow.constants.Constants.GET_QUESTION_TAG_RESOURCE_URL;
import static com.flaregames.stackoverflow.constants.Constants.STACK_OVERFLOW_BASE_URL;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * This is Rest API Interface for Question
 */
@RequestMapping(STACK_OVERFLOW_BASE_URL)
@Api(description = "REST apis for the Question resource", tags = "Question Resource")
public interface QuestionResource {

    /**
     * This method retrieves a list of Questions
     *
     * @return ResponseEntity<List < QuestionResponse>>
     */
    @ApiOperation(value = "The endpoint returns a list of questions from the DB", response = QuestionResponse.class)
    @GetMapping(path = GET_QUESTIONS_RESOURCE_URL, produces = APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<QuestionResponse>> retrieveAll();

    /**
     * This method returns a question by id
     *
     * @param id
     * @return ResponseEntity<QuestionResponse>
     */
    @ApiOperation(value = "The endpoint returns a question by id", response = QuestionResponse.class)
    @GetMapping(path = GET_QUESTIONBYID_RESOURCE_URL, produces = APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<QuestionResponse> retrieveOne(@ApiParam("The Question Id") int id);

    /**
     * This method deletes a question by id from the DB
     *
     * @param id
     * @return ResponseEntity<Void>
     */
    @ApiOperation(value = "The endpoint deletes a question by id from the DB", response = QuestionResponse.class)
    @DeleteMapping(path = GET_QUESTIONBYID_RESOURCE_URL, produces = APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<Void> deleteOne(@ApiParam("The Question Id") int id);

    /**
     * This method returns list of questions by tag
     *
     * @param tagName
     * @return ResponseEntity<List < QuestionResponse>>
     */
    @ApiOperation(value = "The endpoint returns a questions by tag", response = QuestionResponse.class)
    @GetMapping(path = GET_QUESTION_TAG_RESOURCE_URL, produces = APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<QuestionResponse>> retrieveQuestionByTag(@ApiParam("Tag") String tagName);

}

