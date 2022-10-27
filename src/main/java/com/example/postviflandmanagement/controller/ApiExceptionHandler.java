package com.example.postviflandmanagement.controller;

import com.example.postviflandmanagement.model.ApiErrorResponse;
import com.example.postviflandmanagement.model.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler({ ApiException.class })
    protected ResponseEntity<ApiErrorResponse> handleApiException(ApiException ex) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(ex.getStatus(), ex.getMessage(), Instant.now());
        return new ResponseEntity<>(apiErrorResponse, ex.getStatus());
    }
}
