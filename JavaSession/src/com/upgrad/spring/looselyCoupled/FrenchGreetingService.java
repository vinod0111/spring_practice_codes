package com.upgrad.spring.looselyCoupled;

public class FrenchGreetingService implements GreetingService{

    @Override
    public void greet(String name) {
        System.out.println("Bonjor, "+name);
    }
}
