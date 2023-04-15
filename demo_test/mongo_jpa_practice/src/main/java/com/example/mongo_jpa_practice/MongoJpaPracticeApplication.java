package com.example.mongo_jpa_practice;

import com.example.mongo_jpa_practice.dao.CustomerRepository;
import com.example.mongo_jpa_practice.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MongoJpaPracticeApplication implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepository;

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(MongoJpaPracticeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Customer customer1 = new Customer(1, "vinod", "patil", "vinod.patil");
        Customer customer2 = new Customer(2, "vishwa", "patil", "vishwa.patil");

        customerRepository.save(customer1);
        customerRepository.save(customer2);

        for (Customer customer: customerRepository.findAll()) {
            System.out.println(customer);
        }

        System.out.println(customerRepository.findByFirstName("vinod"));
    }
}
