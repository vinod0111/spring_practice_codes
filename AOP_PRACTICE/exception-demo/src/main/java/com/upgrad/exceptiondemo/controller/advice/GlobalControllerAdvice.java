package com.upgrad.exceptiondemo.controller.advice;

import com.upgrad.exceptiondemo.exceptions.RequestedResourceNotFoundException;
import com.upgrad.exceptiondemo.model.ErrModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.stream.Collectors;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrModel> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ResponseEntity(ErrModel.builder()
                .errCode("ERR_INVALID_PAYLOAD_300")
                .errMessage("Invalid payload in the request")
                .errFieldsList(e.getBindingResult().getFieldErrors().stream().map(fe -> fe.getDefaultMessage()).collect(Collectors.toList()))
                .build(),
                HttpStatus.BAD_REQUEST
        );
    }
}

