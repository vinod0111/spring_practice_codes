package com.upgrad.spring.looselyCoupled;


public class App {
    public static void main(String[] args) {

        GreetingServiceFactory greetingServiceFactory = new GreetingServiceFactory();

        GreetingService greetingService = greetingServiceFactory.getGreetingService("english");

        greetingService.greet("Vinod");

        greetingService = greetingServiceFactory.getGreetingService("kannada");

        greetingService.greet("Vinod");

        greetingService = greetingServiceFactory.getGreetingService("spanish");

        greetingService.greet("Vinod");
    }
}
