package com.example.postviflandmanagement.model;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;
@AllArgsConstructor
public class ApiErrorResponse {
    private final HttpStatus status;
    private final String message;
    private final Instant timestamp;


    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
