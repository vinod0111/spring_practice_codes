package com.upgrad.exceptiondemo.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@Builder
public class Student {

    private String studentId;

    @NotBlank(message = "Student name cannot be blank")
    @Size(min=5, max=20, message = "Student can be between 5 and 20 chars")
    private String studentName;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Dateof birth shoud be in the foramt of YYYY-MM-DD")
    private String studentDob;

    @NotBlank(message = "Mobile nuber cannot be blank")
    @Pattern(regexp = "^[0-9]{10}", message = "Invalid mobile number")
    private String mobile;



}
