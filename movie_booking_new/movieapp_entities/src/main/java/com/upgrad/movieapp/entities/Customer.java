package com.upgrad.movieapp.entities;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "Customer")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int customerId;

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
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_type_id")
  private UserType userType;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "language_id")
  private Language language;

  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
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

  public UserType getUserType() {
    return userType;
  }

  public void setUserType(UserType userType) {
    this.userType = userType;
  }


  public Language getLanguage() {
    return language;
  }

  public void setLanguage(Language language) {
    this.language = language;
  }

  @Override
  public String toString() {
    return "Customer{" +
            "customerId=" + customerId +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", dateOfBirth=" + dateOfBirth +
            ", userType=" + userType +
            ", language=" + language +
            '}';
  }
}
