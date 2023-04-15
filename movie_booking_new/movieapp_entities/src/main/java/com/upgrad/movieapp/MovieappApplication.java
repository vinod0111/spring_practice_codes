package com.upgrad.movieapp;

		import com.upgrad.movieapp.DAO.CustomerDAO;
		import com.upgrad.movieapp.entities.Customer;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.context.ApplicationContext;
		import org.springframework.web.bind.annotation.RestController;

		import java.time.LocalDateTime;


@RestController
@SpringBootApplication
public class MovieappApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(MovieappApplication.class, args);

		CustomerDAO customerDAO = context.getBean(CustomerDAO.class);

		Customer customer = new Customer();

		customer.setFirstName("Bob");
		customer.setLastName("Stone");
		customer.setUsername("Bob12Stone");
		customer.setPassword("****");
		customer.setDateOfBirth(LocalDateTime.of(1988, 11, 6, 0, 0));

		System.out.println("Before Saving : "+customer.toString());

		Customer savedCustomer = customerDAO.save(customer);
		System.out.println("After Saving : "+savedCustomer.toString());

		Customer retrivedCustomer = customerDAO.findById(1);

		System.out.println("RETRIVED customer : "+retrivedCustomer);

		customer.setFirstName("Emma");

		Customer afterUdate = customerDAO.update(customer);
		System.out.println("After update : "+afterUdate);

		customerDAO.delete(afterUdate);

		System.out.println("After Deleting : "+customerDAO.findById(afterUdate.getCustomerId()));
	}
}
