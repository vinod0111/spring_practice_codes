package com.example.jpa_entity_factory.dao;

import com.example.jpa_entity_factory.entities.Customer;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public CustomerDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
    }

    @Override
    public Customer save(Customer customer) {

        Session session = this.sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(customer);

        transaction.commit();
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

        session.detach(mergedCustomer);

        transaction.commit();
        session.close();

    }
}
