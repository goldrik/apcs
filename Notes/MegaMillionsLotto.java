/**
 * @author Aurik Sarker 
 * @date 10 October 2013
 * 
 * I, Aurik Sarker, pledge that this program is my own independent 
 * work and conforms to Oxford Academy's Academic Honesty guidelines.
 * However, I did get help from myself. 
 */

import java.util.*;

public class MegaMillionsLotto
{
    private int num1, num2, num3, num4, num5, meganum;
    private int ball1, ball2, ball3, ball4, ball5, megaball;

    Date date = new Date();
    private Random roller;

    MegaMillionsLotto()
    {
        Date date = new Date();

        Dice pong1 = new Dice(56);

        num1 = pong1.getNextRoll();

        num2 = pong1.getNextRoll();
        while (num2 == num1)
            num2 = pong1.getNextRoll();

        num3 = pong1.getNextRoll();
        while (num3 == num2 || num3 == num1)
            num3 = pong1.getNextRoll();

        num4 = pong1.getNextRoll();
        while (num4 == num3 || num4 == num2 || num4 == num1)
            num4 = pong1.getNextRoll();

        num5 = pong1.getNextRoll();
        while (num5 == num4 || num5 == num3 || num5 == num2 || num5 == num1)
            num5 = pong1.getNextRoll();

        Dice pong2 = new Dice(46);

        meganum = pong2.getNextRoll();

        Dice pong3 = new Dice(56);
        ball1 = pong3.getNextRoll();
        ball2 = pong3.getNextRoll();
        while (ball2 == ball1)
            ball2 = pong3.getNextRoll();

        ball3 = pong3.getNextRoll();
        while (ball3 == ball2 || ball3 == ball1)
            ball3 = pong3.getNextRoll();

        num4 = pong3.getNextRoll();
        while (ball4 == ball3 || ball4 == ball2 || ball4 == ball1)
            ball4 = pong3.getNextRoll();

        num5 = pong3.getNextRoll();
        while (ball5 == ball4 || ball5 == ball3 || ball5 == ball2 || ball5 == ball1)
            ball5 = pong3.getNextRoll();

        Dice pong4 = new Dice(46);

        megaball = pong4.getNextRoll();
    }

    MegaMillionsLotto(int n1, int n2, int n3, int n4, int n5, int mn)
    {
        Date date = new Date();

        num1 = n1;
        num2 = n2;
        num3 = n3;
        num4 = n4;
        num5 = n5;
        meganum = mn;

        Dice pong3 = new Dice(56);
        ball1 = pong3.getNextRoll();
        ball2 = pong3.getNextRoll();
        while (ball2 == ball1)
            ball2 = pong3.getNextRoll();

        ball3 = pong3.getNextRoll();
        while (ball3 == ball2 || ball3 == ball1)
            ball3 = pong3.getNextRoll();

        num4 = pong3.getNextRoll();
        while (ball4 == ball3 || ball4 == ball2 || ball4 == ball1)
            ball4 = pong3.getNextRoll();

        num5 = pong3.getNextRoll();
        while (ball5 == ball4 || ball5 == ball3 || ball5 == ball2 || ball5 == ball1)
            ball5 = pong3.getNextRoll();

        Dice pong4 = new Dice(46);

        megaball = pong4.getNextRoll();
    }

    public void printTicket()
    {
        System.out.println(date);
        System.out.println("Number 1: " + num1);
        System.out.println("Number 2: " + num2);
        System.out.println("Number 3: " + num3);
        System.out.println("Number 4: " + num4);
        System.out.println("Number 5: " + num5);
        System.out.println("Megaball: " + meganum);
        System.out.println(" ");
    }

    public void generateLottoTicket()
    {
        Date date = new Date();

        Dice pong1 = new Dice(56);

        num1 = pong1.getNextRoll();

        num2 = pong1.getNextRoll();
        while (num2 == num1)
            num2 = pong1.getNextRoll();

        num3 = pong1.getNextRoll();
        while (num3 == num2 || num3 == num1)
            num3 = pong1.getNextRoll();

        num4 = pong1.getNextRoll();
        while (num4 == num3 || num4 == num2 || num4 == num1)
            num4 = pong1.getNextRoll();

        num5 = pong1.getNextRoll();
        while (num5 == num4 || num5 == num3 || num5 == num2 || num5 == num1)
            num5 = pong1.getNextRoll();

        Dice pong2 = new Dice(46);

        meganum = pong2.getNextRoll();
    }

    public void checkUserNumbers()
    {
        int matches = 0;
        int megamatch = 0;

        if (ball1 == num1 || ball1 == num2 || ball1 == num3 || ball1 == num4 || ball1 == num5)
            matches++;
        else{}

        if (ball2 == num1 || ball2 == num2 || ball2 == num3 || ball2 == num4 || ball2 == num5)
            matches++;
        else{}

        if (ball3 == num1 || ball3 == num2 || ball3 == num3 || ball3 == num4 || ball3 == num5)
            matches++;
        else{}

        if (ball4 == num1 || ball4 == num2 || ball4 == num3 || ball4 == num4 || ball4 == num5)
            matches++;
        else{}

        if (ball5 == num1 || ball5 == num2 || ball5 == num3 || ball5 == num4 || ball5 == num5)
            matches++;
        else{}

        if (megaball == meganum)
            megamatch++;
        else{}

        System.out.println("Your numbers:    " + num1 + " " + num2 + " " + num3 + " " + num4 + " " + num5 + " (" + meganum + ")");
        System.out.println("Winning numbers: " + ball1 + " " + ball2 + " " + ball3 + " " + ball4 + " " + ball5 + " (" + megaball + ")\n");
        System.out.print("You Won ");

        if (matches == 0 && megamatch == 1)
            System.out.print("$2");

        if (matches == 1 && megamatch == 1)
            System.out.print("$3");

        if (matches == 2 && megamatch == 1)
            System.out.print("$10");

        if (matches == 3 && megamatch == 0)
            System.out.print("$7");

        if (matches == 3 && megamatch == 1)
            System.out.print("$150");

        if (matches == 4 && megamatch == 0)
            System.out.print("$150");

        if (matches == 4 && megamatch == 1)
            System.out.print("$10000");

        if (matches == 5 && megamatch == 0)
            System.out.print("$250000");

        if (matches == 5 && megamatch == 1)
            System.out.print("JACKPOT");

        else
            System.out.print("$0");
    }

    public String toString()
    {
        return "" + num1 + " " + num2 + " " + num3 + " " + num4 + " " + num5 + " " + meganum;
    }
}
