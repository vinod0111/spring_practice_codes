package com.example.mongo_jpa_practice.dao;

import com.example.mongo_jpa_practice.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);

}
