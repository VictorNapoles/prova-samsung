package com.samsung.samsungevaluationapi.controller.handler;

import com.samsung.samsungevaluationapi.exception.NoContentException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerHandler {

    @ExceptionHandler(value = NoContentException.class)
    public ResponseEntity<String> exception(NoContentException exception) {
        return new ResponseEntity<String>("No Data found", HttpStatus.NO_CONTENT);
    }
    
}