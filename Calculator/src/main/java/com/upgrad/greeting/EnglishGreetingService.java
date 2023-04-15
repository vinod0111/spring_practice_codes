package com.upgrad.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnglishGreetingService implements GreetingService{

    //Field injection
    private TimeService timeService;

    @Autowired
    public EnglishGreetingService(TimeService timeService) {
        this.timeService = timeService;
    }
    @Override
    public void greet(String name) {
        System.out.println("Welcome, "+name);
    }

    public TimeService getTimeService() {
        return timeService;
    }

    @Autowired
    public void setTimeService(TimeService timeService) {
        this.timeService = timeService;
    }
}
