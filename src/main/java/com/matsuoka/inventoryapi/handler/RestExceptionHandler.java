package com.matsuoka.inventoryapi.handler;

import com.matsuoka.inventoryapi.exception.HttpMessageNotReadableExceptionDetails;
import com.matsuoka.inventoryapi.exception.MethodArgumentNotValidExceptionDetails;
import com.matsuoka.inventoryapi.exception.ResourceNotFoundDetails;
import com.matsuoka.inventoryapi.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResourceNotFoundDetails>
    handlerResourceNotFoundException(ResourceNotFoundException exception) {
        ResourceNotFoundDetails resourceNotFoundDetails = new ResourceNotFoundDetails("Resource not found",
                HttpStatus.NOT_FOUND.value(), exception.getMessage(),
                exception.getClass().getName(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resourceNotFoundDetails);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MethodArgumentNotValidExceptionDetails>
    handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
        String fieldMessages = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));

        MethodArgumentNotValidExceptionDetails methodArgumentNotValidExceptionDetails =
                new MethodArgumentNotValidExceptionDetails("Arguments not valid",
                        HttpStatus.BAD_REQUEST.value(), "check the fields errors",
                        exception.getClass().getName(), LocalDateTime.now(), fields, fieldMessages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(methodArgumentNotValidExceptionDetails);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HttpMessageNotReadableExceptionDetails>
    handleMethodArgumentNotValidException(HttpMessageNotReadableException exception) {

        HttpMessageNotReadableExceptionDetails httpMessageNotReadableExceptionDetails =
                new HttpMessageNotReadableExceptionDetails("Message not readable",
                        HttpStatus.BAD_REQUEST.value(), exception.getMessage(),
                        exception.getClass().getName(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(httpMessageNotReadableExceptionDetails);
    }
}
