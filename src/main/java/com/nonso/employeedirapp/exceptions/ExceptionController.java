package com.nonso.employeedirapp.exceptions;

import com.nonso.employeedirapp.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public ResponseEntity<ApiResponse> handleException(RuntimeException ex) {
        return new ResponseEntity<>(new ApiResponse<>(ex.getMessage(), false), HttpStatus.BAD_REQUEST);
    }
}
