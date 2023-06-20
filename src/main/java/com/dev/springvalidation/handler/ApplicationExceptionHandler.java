package com.dev.springvalidation.handler;

import com.dev.springvalidation.entity.User;
import com.dev.springvalidation.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> invalidInputHandler(MethodArgumentNotValidException methodArgumentNotValidException){
        Map<String, String> exceptionMap = new HashMap<>();
        methodArgumentNotValidException.getBindingResult()
                .getFieldErrors()
                .forEach(fieldError -> {
            exceptionMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return exceptionMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> handleException(UserNotFoundException unfException){
        Map<String, String> exceptionMap = new HashMap<>();
        exceptionMap.put("errorMessage", unfException.getMessage());
        return exceptionMap;
    }
}
