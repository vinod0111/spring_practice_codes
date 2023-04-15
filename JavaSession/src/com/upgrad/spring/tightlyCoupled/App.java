package com.upgrad.spring.tightlyCoupled;

public class App {
    public static void main(String[] args) {
        GreetingService greetingService = new GreetingService();
        greetingService.greet("Vinod");
        //concreete dependency in greeting service
    }
}