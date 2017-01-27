/**
 * @author Aurik Sarker
 * @version 13 September 2013
 */

import java.util.Scanner;

public class Coins
{
    private int myChange;
    
    public Coins()
    {
        myChange = -1;
    }
    
    public Coins(int change)
    {
        if (change > -1)
        {
            myChange = change;
        }
        
        else
        {
            System.err.print("Change cannot be negative.");
            myChange = 0;
        }
    }
    
    
    public void setChange(int change)
    {
        if (change > -1)
        {
            myChange = change;
        }
        
        else
        {
            System.err.print("Change cannot be negative");
            myChange = 0;
        }
    }
    
    public int getChange()
    {
        return myChange;
    }
    
    // Calculate change method
    public void calculateChange()
    {
        if (myChange >= 0)
        {
        }
        
        else
        {
            while (myChange < 0)
            {
                Scanner keyIn = new Scanner(System.in);
                
                System.out.print("Please enter change: ");
                myChange = keyIn.nextInt();
                
                if (myChange >= 0)
                {
                }
                
                else
                {
                    System.out.println("Change cannot be negative.");
                    System.out.println(" ");
                }
            }
        }
        
        int quarters = myChange / 25;
        int dimes = (myChange % 25) / 10;
        int nickels = ((myChange % 25) % 10) / 5;
        int pennies = ((myChange % 25) % 10) % 5;
        
        System.out.println("Change for $" + (myChange/100) + "." + (myChange%100));
        
        switch (quarters)
        {
            case 0: System.out.print(""); break;
            case 1: System.out.println(quarters + " Quarter"); break;
            default: System.out.println(quarters + " Quarters"); break;
        }
        
        switch (dimes)
        {
            case 0: System.out.print(""); break;
            case 1: System.out.println(dimes + " Dime"); break;
            default: System.out.println(dimes + " Dimes"); break;
        }
        
        switch (nickels)
        {
            case 0: System.out.print(""); break;
            case 1: System.out.println(nickels + " Nickel"); break;
            default: System.out.println(nickels + " Nickels"); break;
        }
        
        switch (pennies)
        {
            case 0: System.out.print(""); break;
            case 1: System.out.println(pennies + " Penny"); break;
            default: System.out.println(pennies + " Pennies"); break;
        }
    }
    
    public void resetChange()
    {
        myChange = -1;
    }
    
    public int calculateCents(int qAmt, int dAmt, int nAmt, int pAmt)
    {
        return ((25*qAmt) + (10*dAmt) + (5*nAmt) + (1*pAmt));
    }
}