package com.example.alpha_test.api.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiError {
    private HttpStatus status;
    private String message;
    private String timestamp;

    public ApiError() {
        timestamp = LocalDateTime.now().toString();
    }
    public ApiError(HttpStatus status, String message) {
        this();
        this.status = status;
        this.message = message;
    }
}
