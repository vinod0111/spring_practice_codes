package com.lab1.userapp.service;

import com.lab1.userapp.entities.User;
import java.util.List;


public interface UserService {

  public User createUser(User user);

  public User getUserBasedOnId(int id);

  public User updateUser(User user);

  public User deleteUser(User user);

  public List<User>  getAllUsers();
}
