package com.example.jpa_entity_factory.dao;

import com.example.jpa_entity_factory.entities.Customer;

public interface CustomerDAO {

    public Customer save(Customer customer);
    public Customer findById(int id);
    public Customer update(Customer customer);
    public void delete(Customer customer);
}
