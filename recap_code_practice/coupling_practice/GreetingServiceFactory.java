package coupling_practice;

public class GreetingServiceFactory {
    
    public Greetings getGreetings(String language) {
        if (language.equalsIgnoreCase("fr")) {
            return new FrenchGreeting();
        }

        return new EnglishGreeting();
    }
}
