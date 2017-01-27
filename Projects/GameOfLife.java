/**
 * @author Aurik Sarker 
 * @version 14 February 2014
 * 
 * I, Aurik Sarker, pledge that this program is my own independent 
 * work and conforms to Oxford Academy's Academic Honesty guidelines.
 * However, I did get help from myself.
 */

import java.util.*;
import java.io.*;
import java.lang.*;

public class GameOfLife
{
    boolean [][] dish;
    boolean [][] next;
    int gen = 0;
    
    Scanner keyIn = new Scanner(System.in);

    GameOfLife()
    {
        dish = new boolean[40][80];
        next = new boolean[40][80];
        //dish = new boolean[21][21];
        //next = new boolean[21][21];

        try
        {
            readInData();
        }

        catch(IOException e)
        {
            System.err.print(e.getMessage());
        }
        
        copy(dish, next);
        printDish();
    }

    private void readInData() throws IOException
    {
        //FileReader file = new FileReader("life100.txt");
        FileReader file = new FileReader("life80.txt");
        Scanner fileIn = new Scanner(file);

        int max = fileIn.nextInt();
        for (int i = 0; i < max; i++)
            dish[fileIn.nextInt()][fileIn.nextInt()] = true;

        fileIn.close();
    }
    
    public void oneGeneration()
    {
        gen++;
        for(int r = 0; r < dish.length; r++)
        {
            for(int c = 0; c < dish[r].length; c++)
            {
                int n = neighbors(r,c);
                if (dish[r][c] && !(n > 1 && n < 4))
                    next[r][c] = false;
                if (!dish[r][c] && n == 3)
                    next[r][c] = true;
            }
        }
        copy(next,dish);
        
        printDish();
    }
    
    public void manyGenerations(int n) throws InterruptedException
    {
        for (int i = 0; i < n; i++)
        {
            System.out.print("\f");
            oneGeneration();
            Thread.sleep(150);
        }
    }
    
    public void runGenerations() throws InterruptedException
    {
        int i = -1;
        while (i != 0)
        {
            System.out.print("\nFor how many generations would you like to run the simulation? ");
            i = Integer.parseInt(keyIn.nextLine());
            manyGenerations(i);
        }
    }
    
    private int neighbors(int row, int col)
    {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++)
        {
            for (int c = col - 1; c <= col + 1; c++)
            {
                if (inBound(r,c) && dish[r][c])
                    count++;
            }
        }
        if (dish[row][col])
            count--;
        return count;
    }

    private boolean inBound(int row, int col)
    {
        return row >= 0 && row < dish.length && col >= 0 && col < dish[0].length;
    }

    public void printDish()
    {
        System.out.println("Generation " + gen + ": Population " + totalLives());
        for(int r = 0; r < dish.length; r++)
        {
            for(int c = 0; c < dish[r].length; c++)
            {
                if (dish[r][c])
                    //System.out.print("☻");
                    System.out.print("#");
                if (!dish[r][c])
                    System.out.print(" ");
                    //System.out.print(neighbors(r,c));
            }
            System.out.print("\n");
        }
    }
    
    private void copy(boolean[][] original, boolean[][] copy)
    {
        for(int r = 0; r < original.length; r++)
        {
            for(int c = 0; c < original[r].length; c++)
            {
                copy[r][c] = original[r][c];
            }
        }
    }

    public int rowLives(int row)
    {
        int count = 0;
        for (int i = 0; i < dish[row].length; i++)
        {
            if (dish[row][i])
                count++;
        }
        return count;
    }

    public int columnLives(int col)
    {
        int count = 0;
        for (int i = 0; i < dish.length; i++)
        {
            if (dish[i][col])
                count++;
        }
        return count;
    }

    public int totalLives()
    {
        int count = 0;
        for(int r = 0; r < dish.length; r++)
        {
            for(int c = 0; c < dish[r].length; c++)
            {
                if (dish[r][c])
                    count++;
            }
        }
        return count;
    }
}