package com.customer.app.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {

    private int cutomerId;

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private String emailId;

    private String address;
}