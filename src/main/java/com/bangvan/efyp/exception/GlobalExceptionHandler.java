package com.bangvan.efyp.exception;


import com.bangvan.efyp.dto.response.ApiResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // handle specific exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest)
    {
        ApiResponse apiResponse = ApiResponse.error(404, exception.getMessage());
        webRequest.getDescription(false);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ApiResponse> handleAppException(AppException exception, WebRequest webRequest){
        ApiResponse apiResponse = ApiResponse.error(exception.getErrorCode().getCode(), exception.getErrorCode().getMessage());
        webRequest.getDescription(false);
        return new ResponseEntity<>(apiResponse,exception.getErrorCode().getStatus());
    }

    // Global exception handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGlobalException(Exception exception) {
        ApiResponse apiResponse= ApiResponse.error(500, exception.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiResponse> handleAccessDeniedException(AccessDeniedException exception) {
        ApiResponse apiResponse = ApiResponse.error(403, exception.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.FORBIDDEN);
    }

}



