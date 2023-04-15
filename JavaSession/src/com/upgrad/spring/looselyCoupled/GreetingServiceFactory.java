package com.upgrad.spring.looselyCoupled;

public class GreetingServiceFactory {

    public GreetingService getGreetingService(String language) {
        switch (language) {
            case "english":
                return new EnglishGreetingService();
            case "french":
                return new FrenchGreetingService();
            case "kannada":
                return new KannadaGreetingService();
            case "spanish":
                return new SpanishGreetingService();
            default: throw new RuntimeException("Invalid language");
        }
    }
}
