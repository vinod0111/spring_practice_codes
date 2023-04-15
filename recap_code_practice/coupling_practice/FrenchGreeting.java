package coupling_practice;

public class FrenchGreeting implements Greetings {

    @Override
    public void greet(String name){

        System.out.println("!Hola "+name);
    }

}