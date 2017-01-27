/**
 * @author Aurik Sarker 
 * @version 7 February 2014
 * 
 * I, Aurik Sarker, pledge that this program is my own independent 
 * work and conforms to Oxford Academy's Academic Honesty guidelines.
 * However, I did get help from myself.
 */

import java.util.*;

public class TicTacToe
{
    char[][] board;
    int p;
    int turn;
    int x;
    int y;

    Scanner keyIn = new Scanner(System.in);

    TicTacToe()
    {
    }

    public void newGame() throws InterruptedException
    {
        String still = "Y";
        while (still.equalsIgnoreCase("Y"))
        {
            board = new char[3][3];
            for(int r = 0; r < board.length; r++)
            {
                for(int c = 0; c < board[r].length; c++)
                    board[r][c] = ' ';
            }

            newNewGame();
            System.out.print("\nPlay again? (Y/N): ");
            still = keyIn.nextLine();
        }
        System.out.println("\nThanks for playing!");
    }

    private void newNewGame() throws InterruptedException
    {
        System.out.print("How many humans will be playing? ");
        int players = Integer.parseInt(keyIn.nextLine());

        if (players >= 0 && players <= 2)
            p = players;
        else
        {
            System.out.println("\nInvalid input. Default 2 Player game");
            p = 2;
        }

        System.out.println("\nTo play, enter the coordinate of \nthe move you would like to make");
        System.out.println("         Coordinates: ");
        System.out.println("          1 | 2 | 3");
        System.out.println("          --|---|--");
        System.out.println("          4 | 5 | 6");
        System.out.println("          --|---|--");
        System.out.println("          7 | 8 | 9");

        if (p == 0){
            System.out.println("\nAI 1 is Player X");
            System.out.println("AI 2 is Player O");
        }
        if (p == 1){
            System.out.println("\nYOU are Player X");
            System.out.println("AI is Player O");
        }

        turn = 1;
        while (stillPlaying() == 0)
        {
            printBoard();
            System.out.println("\n");
            nextTurn(turn%2);
            turn++;
        }

        printBoard();
        switch(whoWon(stillPlaying()))
        {
            case 'X':
            System.out.println("\n\nPlayer X WINS"); break;
            case 'O':
            System.out.println("\n\nPlayer O WINS"); break;
            default:
            System.out.println("\n\n  TIE  GAME"); break;
        }
    }

    private void nextTurn(int next) throws InterruptedException
    {
        x = -1;
        y = -1;

        if (next == 1)
        {
            if (p == 0){
                System.out.println("It is AI 1's turn");
                turnAI();}
            if (p == 1){
                System.out.println("It is YOUR turn");
                turnHuman();}
            if (p == 2){
                System.out.println("It is Player X's turn");
                turnHuman();}

            board[x][y] = 'X';
        }

        if (next == 0)
        {
            if (p == 0){
                System.out.println("It is AI 2's turn");
                turnAI();}
            if (p == 1){
                System.out.println("It is AI's turn");
                turnAI();}
            if (p == 2){
                System.out.println("It is Player O's turn");
                turnHuman();}

            board[x][y] = 'O';
        }
    }

    private void turnHuman()
    {
        System.out.print("Enter coordinate of your next move: ");
        translateCoordinate(Integer.parseInt(keyIn.nextLine()));
        while (!checkTurn())
        {
            System.out.println("Invalid move, try again");

            System.out.print("Enter coordinate of your next move: ");
            translateCoordinate(Integer.parseInt(keyIn.nextLine()));
        }
    }

    private boolean checkTurn()
    {
        if (x != -1 || y != -1)
        {
            if (board[x][y] == ' ')
            {
                return true;
            }
        }

        return false;
    }

    private void turnAI() throws InterruptedException
    {
        Thread.sleep(1000); 
        int temp = turn%2;
        for (int i = 0; i < 2; i++)
        {
            if (temp%2 == 0 && toWin('O') != 0)
            { 
                translateCoordinate(toWin('O'));
                i = 2;
            }
            if (temp%2 == 1 && toWin('X') != 0)
            {  
                translateCoordinate(toWin('X'));
                i = 2;
            }
            temp++;
        }

        if (toWin('X') == 0 && toWin('O') == 0)
        {
            Random rand = new Random();
            while (!checkTurn())
                translateCoordinate(rand.nextInt(10));
        }
    }

    private int toWin(char c)
    {
        if (board[0][0] == ' ')
        {
            if (board[0][1] == c && board[0][2] == c)
                return 1;
            if (board[1][0] == c && board[2][0] == c)
                return 1;
            if (board[1][1] == c && board[2][2] == c)
                return 1;
        }
        if (board[0][1] == ' ')
        {
            if (board[0][0] == c && board[0][2] == c)
                return 2;
            if (board[1][1] == c && board[2][1] == c)
                return 2;
        }
        if (board[0][2] == ' ')
        {
            if (board[0][0] == c && board[0][1] == c)
                return 3;
            if (board[1][2] == c && board[2][2] == c)
                return 3;
            if (board[1][1] == c && board[2][0] == c)
                return 3;
        }
        if (board[1][0] == ' ')
        {
            if (board[1][1] == c && board[1][2] == c)
                return 4;
            if (board[0][0] == c && board[2][0] == c)
                return 4;
        }
        if (board[1][1] == ' ')
        {
            if (board[1][0] == c && board[1][2] == c)
                return 5;
            if (board[0][1] == c && board[2][1] == c)
                return 5;
            if (board[0][0] == c && board[2][2] == c)
                return 5;
            if (board[0][2] == c && board[2][0] == c)
                return 5;
        }
        if (board[1][2] == ' ')
        {
            if (board[1][0] == c && board[1][1] == c)
                return 6;
            if (board[0][2] == c && board[2][2] == c)
                return 6;
        }
        if (board[2][0] == ' ')
        {
            if (board[2][1] == c && board[2][2] == c)
                return 7;
            if (board[0][0] == c && board[1][0] == c)
                return 7;
            if (board[1][1] == c && board[0][2] == c)
                return 7;
        }
        if (board[2][1] == ' ')
        {
            if (board[2][0] == c && board[2][2] == c)
                return 8;
            if (board[0][1] == c && board[1][1] == c)
                return 8;
        }
        if (board[2][2] == ' ')
        {
            if (board[2][0] == c && board[2][1] == c)
                return 9;
            if (board[0][2] == c && board[1][2] == c)
                return 9;
            if (board[0][0] == c && board[1][1] == c)
                return 9;
        }

        return 0;
    }

    private void printBoard()
    {
        System.out.println("\nCurrent board: ");

        for(int r = 0; r < board.length; r++)
        {
            System.out.print("  ");
            for(int c = 0; c < board[r].length; c++)
            {
                System.out.print(board[r][c]);
                if (c < board[r].length-1)
                    System.out.print(" | ");
            }
            if (r < board.length-1)
                System.out.println("\n  --|---|--");
        }
    }

    private void translateCoordinate(Integer c)
    {
        switch(c)
        {
            case 1:
            x = 0; y  = 0; break;
            case 2:
            x = 0; y  = 1; break;
            case 3:
            x = 0; y  = 2; break;
            case 4:
            x = 1; y  = 0; break;
            case 5:
            x = 1; y  = 1; break;
            case 6:
            x = 1; y  = 2; break;
            case 7:
            x = 2; y  = 0; break;
            case 8:
            x = 2; y  = 1; break;
            case 9:
            x = 2; y  = 2; break;
            default:
            x = -1; y  = -1; break;
        }
    }

    private int stillPlaying()
    {
        if (board[0][0] != ' ')
        {
            if (board[0][0] == board[0][1] && board[0][0] == board[0][2])
                return 1;
            if (board[0][0] == board[1][0] && board[0][0] == board[2][0])
                return 1;
        }

        if (board[1][1] != ' ')
        {
            if (board[1][0] == board[1][1] && board[1][0] == board[1][2])
                return 2;
            if (board[0][1] == board[1][1] && board[0][1] == board[2][1])
                return 2;
            if (board[0][0] == board[1][1] && board[0][0] == board[2][2])
                return 2;
            if (board[0][2] == board[1][1] && board[0][2] == board[2][0])
                return 2;
        }

        if (board[2][2] != ' ')
        {
            if (board[2][0] == board[2][1] && board[2][0] == board[2][2])
                return 3;
            if (board[0][2] == board[1][2] && board[0][2] == board[2][2])
                return 3;
        }

        if (turn == 10)
            return 4;

        return 0;
    }

    private char whoWon(int won)
    {
        if (stillPlaying() == 1)
            return board[0][0];
        else if (stillPlaying() == 2)
            return board[1][1];
        else if (stillPlaying() == 3)
            return board[2][2];
        else
            return ' ';
    }
}