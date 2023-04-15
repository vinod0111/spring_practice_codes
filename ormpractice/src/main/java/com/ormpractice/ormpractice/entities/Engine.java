package com.ormpractice.ormpractice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Engine {

    @Id
    @GeneratedValue
    private int engineId;

    private String engineName;

    @OneToOne
    private Car car;
}

