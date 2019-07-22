package com.flaregames.stackoverflow.controller;

import com.flaregames.stackoverflow.resource.QuestionResource;
import com.flaregames.stackoverflow.response.internal.QuestionResponse;
import com.flaregames.stackoverflow.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

/**
 * This class is controller for Question Resource
 */
@RestController
public class QuestionController implements QuestionResource {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public ResponseEntity<List<QuestionResponse>> retrieveAll() {
        return ResponseEntity.status(OK).body(questionService.findAll());
    }

    @Override
    public ResponseEntity<QuestionResponse> retrieveOne(@PathVariable @Valid  int id) {
        QuestionResponse questionResponse = questionService.findById(id);
        return ResponseEntity.status(OK).body(questionResponse);
    }

    @Override
    public ResponseEntity<Void> deleteOne(@PathVariable @NotEmpty @Valid int id) {
        questionService.deleteById(id);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<List<QuestionResponse>> retrieveQuestionByTag(@RequestParam @NotEmpty @NotNull String tagName) {
        List<QuestionResponse> questionResponseList = questionService.findByTag(tagName);
        return ResponseEntity.status(OK).body(questionResponseList);
    }
}
