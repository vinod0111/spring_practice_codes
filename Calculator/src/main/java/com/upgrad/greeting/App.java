package com.upgrad.greeting;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.upgrad.greeting");
        // GreetingService greetingService = (GreetingService) context.getBean("englishGreetingService");
        EnglishGreetingService greetingService = (EnglishGreetingService) context.getBean("englishGreetingService");
        greetingService.greet("Vinod");
        System.out.println(greetingService.getTimeService().getCurrentTime());


    }
}
