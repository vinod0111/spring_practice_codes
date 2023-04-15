package com.ormpractice.ormpractice;

import com.ormpractice.ormpractice.dao.CustomerRepository;
import com.ormpractice.ormpractice.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class OrmpracticeApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrmpracticeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		customerRepository.deleteAll();

		Set<String> phoneNumbers1 = new HashSet<>();
		phoneNumbers1.add("+91-9121346753");
		phoneNumbers1.add("+91-8513216512");

		Customer customer = new Customer();
		customer.setFirstName("customer_1");
		customer.setLastName("last_name_for_customer_1");
		customer.setPhoneNumbers(phoneNumbers1);

		Set<String> phoneNumbers2 = new HashSet<>();
		phoneNumbers2.add("+91-8121346753");
		phoneNumbers2.add("+91-9513216512");

		Customer customer2 = new Customer();
		customer2.setFirstName("customer_2");
		customer2.setLastName("last_name_for_customer_2");
		customer2.setPhoneNumbers(phoneNumbers2);

		customerRepository.save(customer);
		customerRepository.save(customer2);


	}
}
