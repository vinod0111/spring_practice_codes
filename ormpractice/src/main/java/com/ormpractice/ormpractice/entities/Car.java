package com.ormpractice.ormpractice.entities;

import jakarta.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private int carId;

    private String carName;

    @OneToOne
    private Engine engine;

}
