package com.upgrad.exceptiondemo.controller.advice;

import com.upgrad.exceptiondemo.exceptions.RequestedResourceNotFoundException;
import com.upgrad.exceptiondemo.model.ErrModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(RequestedResourceNotFoundException.class)
    ResponseEntity<ErrModel> handleRequestedResourceNotFoundException(){

        return new ResponseEntity(
                ErrModel.builder()
                    .errCode("ERR_RESOURCE_404")
                    .errMessage("Requested Resource Not Found")
                    .build(),
                HttpStatus.BAD_REQUEST);
    }
}
