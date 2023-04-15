package com.upgrad.spring.looselyCoupled;

public class EnglishGreetingService implements GreetingService {
    @Override
    public void greet(String name) {
        System.out.println("Hello, "+name);
    }
}
