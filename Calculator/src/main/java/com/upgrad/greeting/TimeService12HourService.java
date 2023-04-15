package com.upgrad.greeting;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TimeService12HourService implements TimeService{

    @Override
    public int getCurrentTime() {

        int hour = LocalDateTime.now().getHour();
        return hour;
    }
}
