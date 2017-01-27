/**
 *
 * @author Aurik Sarker
 * @date 20 September 2013
 * 
 * I, Aurik Sarker, pledge that this program is my own independent 
 * work and conforms to Oxford Academy's Academic Honesty guidelines.
 * However, I did get help from myself. 
 */

import java.util.Scanner;

public class LoveCalculator
{
   public static void main( String args [] )
   {
       String me;
       String you;
       
       Scanner keyIn = new Scanner (System.in);
       
       System.out.println("Enter Person 1: ");
       me = keyIn.nextLine();
       String lowerMe = me.toLowerCase();
       double myHashCode1 = lowerMe.hashCode();
       
       System.out.println(" ");
       
       System.out.println("Enter Person 2: ");
       you = keyIn.nextLine();
       String lowerYou = you.toLowerCase();
       double yourHashCode1 = lowerYou.hashCode();
       
       System.out.println(" ");
       
       double yourHashCode2 = Math.abs(yourHashCode1);
       double myHashCode2 = Math.abs(myHashCode1);
       
       yourHashCode2 = Math.log(yourHashCode2)*4.5;
       myHashCode2 = Math.log(myHashCode2)*4.5;
       
       double com;
       
       if (yourHashCode1 == -1.88634397E9 || myHashCode1 == -1.88634397E9);
       com = 0.0;
       
       if (yourHashCode2 > myHashCode2)
       com = myHashCode2 / yourHashCode2;
       
       else
       com = yourHashCode2 / myHashCode2;
       
       com = (com*100)-((com*100)%0.1);
       
       System.out.println(me + " and " + you + " are " + com + "% compatible.");
   }
}
