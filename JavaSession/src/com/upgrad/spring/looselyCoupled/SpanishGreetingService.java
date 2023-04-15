package com.upgrad.spring.looselyCoupled;

public class SpanishGreetingService implements GreetingService{
    @Override
    public void greet(String name) {
        System.out.println("Hola, "+name);
    }
}
