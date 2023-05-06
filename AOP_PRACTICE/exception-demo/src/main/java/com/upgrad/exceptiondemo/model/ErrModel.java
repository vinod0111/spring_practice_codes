package com.upgrad.exceptiondemo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrModel {

    private String errCode;
    private String errMessage;
}
