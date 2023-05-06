package com.customer.app.controller;

import com.customer.app.dto.CustomerDTO;
import com.customer.app.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customerApi")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping(value = "/live")
    public Object checkStatus(){
        return ResponseEntity.ok().body("Customer service is up and running");
    }

    @PostMapping(value = "/v1/customer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDTO> saveCustomerDetails(@RequestBody CustomerDTO customerDTO){

        CustomerDTO savedCustomer = customerService.saveCustomerDetails(customerDTO);

        return new ResponseEntity(savedCustomer, HttpStatus.OK);

    }

    @GetMapping(value = "/v1/customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCustomerDetails(@PathVariable(name="customerId") int customerId){

        CustomerDTO customerDTO =  customerService.getCustomerDetails(customerId);

        return new ResponseEntity(customerDTO, HttpStatus.OK);

    }
}
