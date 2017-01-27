import java.util.*;
import java.io.*;

public class KTour1
{
    int[][] board;
    int move;
    int x;
    int y;
    int r;
    int c;

    Scanner keyIn = new Scanner(System.in);
    //(char)9816 ♘

    public KTour1()
    {
        board = new int[8][8];
        x = 0;
        y = 0;
    }

    public KTour1(int row, int column)
    {
        board = new int[8][8];
        x = 0;
        y = 0;
        if (inBound(row - 1, column - 1))
        {
            x = column - 1;
            y = row - 1;
        }
    }

    public void runKnight() throws InterruptedException
    {
        String still = "Y";
        while (still.equalsIgnoreCase("Y"))
        {
            System.out.print("\f");
            board = new int[8][8];
            newKnight();
            System.out.print("\nTry again? (Y/N): ");
            still = keyIn.nextLine();
        }
        System.out.println("\nThanks for touring!");
    }

    private void newKnight() throws InterruptedException
    {
        System.out.println("Welcome to Knight Tour I");

        move = 1;
        board[y][x] = move;
        printBoard();
        move++;

        System.out.print("\nPress enter to continue... "); String nothing = keyIn.nextLine();

        while(!isDone())
        {
            nextMove();
            board[y][x] = move;
            System.out.print("\f");
            printBoard();
            move++;
            Thread.sleep(200);
        }

        if (move == 64)
            System.out.println("\nYour knight has travelled to every square");
        else
            System.out.println("\nYour knight is stuck after " + (move-1) + " moves");
    }

    private void nextMove()
    {
        Random rand = new Random();
        do 
        {
            r = y;
            c = x;
            translate(rand.nextInt(9));
        }
        while (!inBound(r,c));

        y = r;
        x = c;
    }

    private void translate(int a)
    {
        switch(a)
        {
            case 1:
            r -= 2; c -= 1; break;
            case 2:
            r -= 2; c += 1; break;
            case 3:
            r -= 1; c -= 2; break;
            case 4:
            r -= 1; c += 2; break;
            case 5:
            r += 1; c -= 2; break;
            case 6:
            r += 1; c += 2; break;
            case 7:
            r += 2; c -= 1; break;
            case 8:
            r += 2; c += 1; break;
        }
    }

    private boolean inBound(int a, int b)
    {
        if (a < 0 || b < 0 || a > 7 || b > 7)
            return false;
        if (board[r][c] != 0)
            return false;
        return true;
    }

    private boolean isDone()
    {
        if (move > 64)
            return true;
        for (int i = 1; i < 9; i++)
        {
            r = y;
            c = x;
            translate(i);
            if (inBound(r,c))
                return false;
        }
        return true;
    }

    private void printBoard()
    {
        System.out.println("\nMove: " + move);

        for(int r = 0; r < board.length; r++)
        {
            System.out.print(" ");
            for(int c = 0; c < board[r].length; c++)
            {
                if (board[r][c] == 0)
                    System.out.print("  ");
                else
                {
                    if (board[r][c] < 10)
                        System.out.print("0" + board[r][c]);
                    else
                        System.out.print(board[r][c]);
                }
                if (c < board[r].length-1)
                    System.out.print(" | ");
            }

            if (r < board.length-1)
                System.out.println("\n----|----|----|----|----|----|----|----");
        }
        System.out.print("\n");
    }

    public int row()
    {
        return y + 1;
    }

    public int column()
    {
        return x + 1;
    }
}
