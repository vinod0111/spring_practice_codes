package com.upgrad.movieapp.DAO;

import com.upgrad.movieapp.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    private SessionFactory sessionFactory;

    public CustomerDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
    }

    @Override
    public Customer save(Customer customer) {

        Session session = this.sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(customer);
        session.close();
        return customer;
    }

    @Override
    public Customer findById(int id) {
        Session session = this.sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class, id);

        transaction.commit();

        session.close();

        return customer;
    }

    @Override
    public Customer update(Customer customer) {

        Session session = this.sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.update(customer);

        transaction.commit();
        session.close();
        return customer;
    }

    @Override
    public void delete(Customer customer) {

        Session session = this.sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Customer mergedCustomer = (Customer) session.merge(customer);

        session.delete(customer);

        transaction.commit();
        session.close();

    }
}
