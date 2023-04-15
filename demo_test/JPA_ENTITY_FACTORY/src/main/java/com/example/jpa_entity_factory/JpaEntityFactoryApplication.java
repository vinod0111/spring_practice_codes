package com.example.jpa_entity_factory;

import com.example.jpa_entity_factory.dao.CustomerDAO;
import com.example.jpa_entity_factory.dao.MovieDao;
import com.example.jpa_entity_factory.entities.Customer;
import com.example.jpa_entity_factory.entities.Movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@SpringBootApplication
public class JpaEntityFactoryApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext =  SpringApplication.run(JpaEntityFactoryApplication.class, args);

//        CustomerDAO customerDAO = applicationContext.getBean(CustomerDAO.class);
//
//        Customer customer = new Customer();
//        customer.setFirstName("Vinod");
//        customer.setLastName("patil");
//        customer.setUserName("vinod.patil");
//        customer.setDataOfBirth(LocalDate.of(1997, 9, 22));
//
//        System.out.println("Before Saving:"+customer);
//
//        Customer afterSave = customerDAO.save(customer);
//
//        System.out.println("After Saving:"+customer);
//
//        afterSave.setLastName("Patil");
//
//        Customer afterupdate = customerDAO.update(afterSave);
//
//        System.out.println("After Update : "+afterupdate);
//
//        System.out.println("Deleting Customer........");
//
//        customerDAO.delete(afterupdate);
//
//        System.out.println("Deleted Customer");


        MovieDao movieDao = applicationContext.getBean(MovieDao.class);
        System.out.println(movieDao);

        Movie movie = new Movie();

        movie.setMovieName("Kirik Party");
        movie.setDuration(3.0);

        System.out.println("Before save : "+movie);

        Movie afterSave = movieDao.save(movie);

        System.out.println("After Saving : "+afterSave);

        Movie retrivedMovie = movieDao.findById(1).orElse(null);

        System.out.println("After Rettriving : "+retrivedMovie);

        afterSave.setDuration(4.0);

        movie = movieDao.save(afterSave);

        System.out.println("After UPdate:"+movie);

        movieDao.delete(movie);

        retrivedMovie = movieDao.findById(1).orElse(null);

        System.out.println("After deleting : "+retrivedMovie);

    }

}
