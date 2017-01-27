/**
 * @author Aurik Sarker 
 * @date 11 October 2013
 * 
 * I, Aurik Sarker, pledge that this program is my own independent 
 * work and conforms to Oxford Academy's Academic Honesty guidelines.
 * However, I did get help from myself. 
 */

import java.util.Scanner;

public class PiggyBank
{
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;

    PiggyBank()
    {
        quarters = 0;
        dimes = 0;
        nickels = 0;
        pennies = 0;
    }

    PiggyBank(int q, int d, int n, int p)
    {
        if (q<0 || d<0 || n<0 || p<0) 
        {
            System.err.print("Nunber of coins cannot be negative");
            quarters = 0;
            dimes = 0;
            nickels = 0;
            pennies = 0;
        } 
        else 
        {
            quarters = q;
            dimes = d;
            nickels = n;
            pennies = p;
        }
    }

    public void setQuarters(int q)
    {
        if (q>=0)
            quarters = q;
        else
        {
            System.err.print("Number of quarters cannot be negative");
            quarters = 0;
        }
    }

    public void setDimes(int d)
    {
        if (d>=0)
            dimes = d;
        else
        {
            System.err.print("Number of dimes cannot be negative");
            dimes = 0;
        }
    }

    public void setNickels(int n)
    {
        if (n>=0)
            nickels = n;
        else
        {
            System.err.print("Number of nickels cannot be negative");
            nickels = 0;
        }
    }

    public void setPennies(int p)
    {
        if (p>=0)
            pennies = p;
        else
        {
            System.err.print("Number of pennies cannot be negative");
            pennies = 0;
        }
    }

    public void insertQuarter()
    {
        quarters++;
    }

    public void insertDime()
    {
        dimes++;
    }

    public void insertNickel()
    {
        nickels++;
    }

    public void insertPenny()
    {
        pennies++;
    }

    public int getQuarters()
    {
        return quarters;
    }

    public int getDimes()
    {
        return dimes;
    }

    public int getNickels()
    {
        return nickels;
    }

    public int getPennies()
    {
        return pennies;
    }

    public void breakPiggy()
    {
        Scanner keyIn = new Scanner (System.in);

        int i = 0;
        char choice = 0;
        while (!(choice == 'Y' || choice == 'N' || choice == 'y' || choice == 'n')) // If the input is invalid
        {
            System.out.print("Are you sure you want to break your piggy? \nYou will lose all your change (Y/N)");
            String input = keyIn.nextLine();
            choice = input.charAt(0);
        }

        switch(choice)
        {
            case 'Y': case 'y':
            System.out.println("Breaking Piggy Bank...\n "); break;
            case 'N': case 'n':
            System.out.println("Goodbye"); i=1; break;
        }

        if (i==0)
        {
            System.out.print("You have ");
            if (quarters == 0){}
            if (quarters == 1)
                System.out.print(quarters + " quarter, ");
            else
                System.out.print(quarters + " quarters, ");

            if (dimes == 0){}
            if (dimes == 1)
                System.out.print(dimes + " dime, ");
            else
                System.out.print(dimes + " dimes, ");

            if (nickels == 0){}
            if (nickels == 1)
                System.out.print(nickels + " nickel, ");
            else
                System.out.print(nickels + " nickles, ");

            if (pennies == 0){}
            if (pennies == 1)
                System.out.println(pennies + " penny ");
            else
                System.out.println(pennies+ " pennies ");

            int change = quarters * 25 + dimes * 10 + nickels * 5 + pennies;

            System.out.print("Total: $" + change/100 + "." + change%100);

            quarters = 0;
            dimes = 0;
            nickels = 0;
            pennies = 0;
        }
        else{}
    }

    public String countChange()
    {
        int change = pennies*1 + nickels*5 + dimes*10 + quarters*25;
        return "You have " + change/100 + " dollars and " + change%100 + " cents";
    }
    
    public String toString()
    {
        return "You have " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels, and " + pennies + " pennies.";
    }
}
