package com.example.queryparamvalidation.exceptions;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
@RequestMapping(produces = "application/json")
@ResponseBody
public class RestControllerAdvice {


    @ExceptionHandler(QueryParameterNotSupportedException.class)
    public ResponseEntity<Map<String,Object>> unrecogonizedParameter(final QueryParameterNotSupportedException e){
        Map<String,Object> errorInfo = new LinkedHashMap<>();
        errorInfo.put("timestamp",new Date());
        errorInfo.put("errorMessage",e.getMessage());
        errorInfo.put("allowableParameters",e.getValidArgs());
        return new ResponseEntity<Map<String, Object>>(errorInfo,HttpStatus.BAD_REQUEST);
    }



}