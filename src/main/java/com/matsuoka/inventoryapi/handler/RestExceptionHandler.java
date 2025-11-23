package com.matsuoka.inventoryapi.handler;

import com.matsuoka.inventoryapi.exception.ExceptionDetails;
import com.matsuoka.inventoryapi.exception.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ExceptionDetails> handleException(ResourceNotFound exception) {
    ExceptionDetails exceptionDetails = new ExceptionDetails("Resource not found",
            HttpStatus.NOT_FOUND.value(), exception.getMessage(),
            exception.getClass().getName(), LocalDateTime.now());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDetails);
    }
}
