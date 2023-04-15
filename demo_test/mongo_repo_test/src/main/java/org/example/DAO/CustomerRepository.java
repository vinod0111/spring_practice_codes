package org.example.DAO;

import org.example.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer> {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
}
