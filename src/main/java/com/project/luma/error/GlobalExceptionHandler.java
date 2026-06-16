package com.project.luma.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException ex) {
        log.error("Resource not found: {} with id : {}", ex.getResourceName(), ex.getResourceId());
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getResourceName() + " with id " + ex.getResourceId() + " not found");
        return ResponseEntity.status(apiError.status()).body(apiError);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequestException(BadRequestException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
        log.error(apiError.toString(), ex);
        return ResponseEntity.status(apiError.status()).body(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException ex){
        var fieldErrors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ApiError.ApiFieldError(error.getField(),error.getDefaultMessage()))
                .toList();

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Validation failed", fieldErrors);
        log.error(apiError.toString(), ex);
        return ResponseEntity.status(apiError.status()).body(apiError);
    }
}
