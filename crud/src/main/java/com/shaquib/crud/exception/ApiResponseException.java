package com.shaquib.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@ControllerAdvice
public class ApiResponseException {
    @ExceptionHandler(CustomerBusinessException.class)
    public ResponseEntity<Map<String,Object>> handleCustomerBusinessException(CustomerBusinessException customerBusinessException,
                                                                              WebRequest request){
        Map<String,Object> errorMap = new HashMap<>();
        errorMap.put("message",customerBusinessException.getMessage());
        errorMap.put("timestamp", LocalDateTime.now());
        errorMap.put("path",request.getContextPath());
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
}
