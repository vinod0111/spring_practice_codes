package com.customer.app.service;

import com.customer.app.dto.CustomerDTO;
import com.customer.app.entity.CustomerEntity;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    public CustomerDTO saveCustomerDetails(CustomerDTO customerDTO);

    public CustomerDTO getCustomerDetails(int id);

}
