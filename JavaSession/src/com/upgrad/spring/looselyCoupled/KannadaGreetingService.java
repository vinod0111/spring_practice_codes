package com.upgrad.spring.looselyCoupled;

public class KannadaGreetingService implements GreetingService{
    @Override
    public void greet(String name) {
        System.out.println("Suswagata, "+name);
    }
}
