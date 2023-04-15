package com.upgrad.movieapp.DAO;

import com.upgrad.movieapp.entities.Customer;

public interface CustomerDAO {

    public Customer save(Customer customer);
    public Customer findById(int id);
    public Customer update(Customer customer);
    public void delete(Customer customer);
}
