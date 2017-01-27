import java.util.Scanner;

public class SwitchSample
{
   // Imagine a menu system with different choices
   // Alternative to an if-else structure
   
   public void menuInput()
   {
       Scanner keyIn = new Scanner(System.in);
       
       System.out.println("1.Add a class\n2.Drop a class\n3.print class schedule\n4.Print transcript\n5.Exit program\n ");
       System.out.print("Enter Choice => ");
       //int choice = keyIn.nextInt();
       String input = keyIn.nextLine();
       char choice = input.charAt(0);
       
       while (!(choice >= 'A' && choice <= 'E')) // If the input is invalid
       {
           System.out.println("Invalid Choice!");
           System.out.print("Please enter choice again => ");
           
           input = keyIn.nextLine();
           choice = input.charAt(0);
       }
       
       switch(choice)
       {
           case 'a': case 'A':
           System.out.println("Let's add Computer Science"); break;
           case 'b': case 'B':
           System.out.println("Let's drop Choir and Physics"); break;
           case 'c': case 'C':
           System.out.println("Your Fall Schedule"); break;
           case 'd': case 'D':
           System.out.println("Report Card: All A's!"); break;
           case 'e': case 'E':
           System.out.println("Goodbye"); break;
           default:
           System.out.println("Invalid menu chioce");
           System.out.println("Goodbye");
           System.exit(-1);
           
       }
   }
}
