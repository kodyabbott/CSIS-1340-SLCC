package user.input.kody.abbott;

public class UserInputKodyAbbott
{

public static void main(String[] args)
    {
        String name;
        Keyboard k;
        
        k = new Keyboard();
        System.out.println("Enter your full name: ");
        name = k.readLine();
        System.out.println("Hello " + name);
    }
    
}