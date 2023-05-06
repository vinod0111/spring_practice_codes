package com.upgrad.exceptiondemo.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ErrModel {

    private String errCode;
    private String errMessage;
    private List<String> errFieldsList;

}
