package coupling_practice;

public class EnglishGreeting implements Greetings{
    
    @Override
    public void greet(String name) {
        System.out.println("!Welcome "+name);
    }
}
