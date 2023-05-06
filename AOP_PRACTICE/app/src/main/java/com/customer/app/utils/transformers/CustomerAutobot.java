package com.customer.app.utils.transformers;

import com.customer.app.dto.CustomerDTO;
import com.customer.app.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerAutobot {
    @Autowired
    private ModelMapper modelMapper;

    public CustomerDTO toDTO(CustomerEntity customerEntity) {

        return modelMapper.map(customerEntity, CustomerDTO.class);
    }

    public CustomerEntity toEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }
}
