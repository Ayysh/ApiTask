package com.flaregames.stackoverflow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This exception is thrown when Question is not found
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoQuestionFoundException extends RuntimeException{

        public NoQuestionFoundException(String message) {
            super(message);
        }
    }

