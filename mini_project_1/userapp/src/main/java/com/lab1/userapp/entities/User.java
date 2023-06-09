package com.lab1.userapp.entities;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;
import java.util.Set;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int userId;

  @Column(name = "first_name", length = 20, nullable = false)
  private String firstName;

  @Column(length = 20)
  private String lastName;

  @Column(length = 20, nullable = false, unique = true)
  private String username;

  @Column(length = 20, nullable = false)
  private String password;

  @Column(nullable = false)
  private LocalDateTime dateOfBirth;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "customer_contact_number", joinColumns = @JoinColumn(name = "customer_id"))
  @Column(name = "mobile_number", nullable = false)
  private Set<Integer> phoneNumbers;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public LocalDateTime getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDateTime dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Set<Integer> getPhoneNumbers() {
    return phoneNumbers;
  }

  public void setPhoneNumbers(Set<Integer> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
  }
}