package com.lab1.userapp.dao;

import com.lab1.userapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Integer> {

}
