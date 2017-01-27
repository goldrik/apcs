
/**
 * Write a description of class HelloWorld here.
 * 
 * @author Aurik Sarker 
 * @date 08/28/2013
 * 
 * I, Aurik Sarker, pledge that this program is my own independent 
 * work and conforms to Oxford Academy's Academic Honesty guidelines.
 * However, I did get help from myself. 
 */
public class HelloWorld
{
    public static void main(String [] args)
    {
        int daysSinceStart = 1;
        double pi = 3.14;
        String name = "Aurik";
        while( daysSinceStart < 180)
        {
            System.out.println("Hey " + name + ", It's been " + daysSinceStart + " days since school started");
            daysSinceStart++;
        }

        System.out.println("It's summer again!");
    }
}

