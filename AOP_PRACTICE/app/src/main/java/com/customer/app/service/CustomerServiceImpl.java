package com.customer.app.service;

import com.customer.app.dto.CustomerDTO;
import com.customer.app.entity.CustomerEntity;
import com.customer.app.exceptions.RecordNotFoundException;
import com.customer.app.repository.CustomerRepository;
import com.customer.app.utils.transformers.CustomerAutobot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerAutobot customerAutobot;

    @Override
    public CustomerDTO saveCustomerDetails(CustomerDTO customerDTO) {


        CustomerEntity savedCustomerentity = customerRepository.save(customerAutobot.toEntity(customerDTO));


        return customerAutobot.toDTO(savedCustomerentity);
    }

    @Override
    public CustomerDTO getCustomerDetails(int customerId) {

        CustomerEntity customerEntity = customerRepository.findById(customerId)
                .orElseThrow(() -> new RecordNotFoundException("Customer Details for customer-ID : "+customerId+" Doesnot exists"));

        return customerAutobot.toDTO(customerEntity);

    }

}
