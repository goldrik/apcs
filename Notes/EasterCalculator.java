/**
 * 
 * @author Aurik Sarker
 * @date 04 September 2013
 */

import java.util.Scanner;

public class EasterCalculator
{
    private int year;
    private boolean debug; // true or false (on of off)

    // Every object has a constructor
    // The constructor initializes a private instance variable
    
    // Default constructor
    public EasterCalculator()
    {
        year = 2003;
        debug = false;
    }
    
    // Initializes variables
    public EasterCalculator(int y)
    {
        year = y; // Stores the falue of y in year
        debug = true;
    }

    // Another constructor
    public EasterCalculator(int y, boolean db)
    {
        year = y; // Stores the falue of y in year
        debug = db;
    }

    // Accessor method
    public int getYear()
    // public: access control, int: return type
    {
        return year;
    }

    // Mutator method
    public void setYear(int nuYear)
    {
        if(nuYear > 0)
        {
            year = nuYear;
        }
    }
    
    public void askUserForInput()
    {
        Scanner keyIn = new Scanner(System.in);
        
        System.out.print("Please enter year: ");
        
        //int y = keyIn.nextInt();
        String input = keyIn.nextLine();
        int y = Integer.parseInt(input); 
        
        setYear(y);
    }
    
    // Toggle
    public boolean toggleDebug()
    {
        return (debug = !debug);
        
        /*
        if (debug == true)
        {
            debug = false;
        }
        else if (debug == false)
        {
            debug = true;
        }
        */
       
    }
    
    public void calculateDate()
    {
        int a, b, c, d, e, f, g, h, i, k, r, m, n, p = 0;

        a = year % 19;

        b = year / 100;

        c = year % 100;

        d = b / 4;

        e = b % 4;

        f = (b + 8) / 25;

        g = (b - f + 1) / 3;

        h = (19 * a + b - d - g + 15) % 30;

        i = c / 4;

        k = c % 4;

        r = (32 + 2 * e + 2 * i - h - k) % 7;

        m = (a + 11 * h + 22 * r) / 451;

        n = (h + r - 7 * m + 114) / 31;

        p = (h + r - 7 * m + 114) % 31;

        if (debug)
        {
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("c = " + c);
            System.out.println("d = " + d);
            System.out.println("e = " + e);
            System.out.println("f = " + f);
            System.out.println("g = " + g);
            System.out.println("h = " + h);
            System.out.println("i = " + i);
            System.out.println("k = " + k);
            System.out.println("r = " + r);
            System.out.println("m = " + m);
            System.out.println("n = " + n);
            System.out.println("p = " + p);
        }

        System.out.print("In " + year + ", Easter falls on ");

        String month;
        if(n == 3)
        {
            month = "March";
        }
        else
        {
            month = "April";
        }

        System.out.print(month + " ");
        
        int z = (p + 1);
        String end;
        if(z == 1 || z == 21 || z == 31)
        {
            end = "st";
        }
        else if(z == 2 || z == 22)
        {
            end = "nd";
        }
        else if(z == 3 || z == 23)
        {
            end = "rd";
        }
        else
        {
            end = "th";
        }
        
        System.out.print(z + end);
    }
}