import java.util.*;

public class Game2048
{
    private int[][] board;
    int goal;

    Game2048()
    {
        board = new int[4][4];
        goal = 2048;
    }

    public void newGame()
    {
        play(true);
    }

    private void play(boolean newGame)
    {
        if (newGame)
        {
            board = new int[4][4];
            addNumber();
        }
        Scanner keyIn = new Scanner(System.in);
        while (!checkWinner(goal))
        {
            printBoard();
            String move;
            System.out.print("Please enter your move: ");
            move = keyIn.nextLine().toLowerCase();
            while (!(move.equals("w") || move.equals("a") || move.equals("s") || move.equals("d") || move.equals("p") || move.equals("n")))
            {
                System.out.println("The move you entered is not valid.");
                System.out.print("Please try again: ");
                move = keyIn.nextLine().toLowerCase();
            }
            if (move.equals("w")) 
            {
                if (up(board)) addNumber();
            }
            else if (move.equals("d"))
            {
                if (right(board)) addNumber();
            }
            else if (move.equals("a"))
            {
                if (left(board)) addNumber();
            }
            else if (move.equals("s"))
            {
                if (down(board)) addNumber();
            }
            else if (move.equals("p"))
            {
                return;
            }
            else if (move.equals("n"))
            {
                play(true);
                return;
            }
            int[][] copied = copy(board);
            if (!up(copied) && !down(copied) && !left(copied) && !right(copied))
            {
                printBoard();
                System.out.println("Game over!");
                System.out.print("Play again? (Y/N) ");
                String play = keyIn.nextLine().toUpperCase();
                if (play.equals("Y"))
                {
                    play(true);
                    return;
                }
                return;
            }
        }
        printBoard();
        System.out.println("Congratulations! You win!");
        System.out.print("Want to keep going? (Y/N) ");
        String play = keyIn.nextLine().toUpperCase();
        if (play.equals("Y"))
        {
            goal = -1;
            addNumber();
            play(false);
            return;
        }
    }

    private void addNumber()
    {
        int r = (int)(Math.random()*4);
        int c = (int)(Math.random()*4);
        while (board[r][c] != 0)
        {
            r = (int)(Math.random()*4);
            c = (int)(Math.random()*4);
        }
        if (Math.random() < .075)
        {
            board[r][c] = 4;
        }
        else
        {
            board[r][c] = 2;
        }
    }

    private int getScore()
    {
        int out = 0;
        for (int r=0; r<4; r++)
        {
            for (int c=0; c<4; c++)
            {
                if (board[r][c] !=0)
                {
                    out+=((int)(Math.log(board[r][c])/Math.log(2))-1)*board[r][c];
                }
            }
        }
        return out;
    }

    private void printBoard()
    {
        System.out.println("\f");
        System.out.println("2048");
        System.out.println("Score: " + getScore());
        System.out.println("------------------------");
        for (int i=0; i<4; i++)
        {
            for (int j=0; j<4; j++)
            {
                System.out.print(printNumber(board[i][j]));
            }
            System.out.println();
            System.out.println("------------------------");
        }
    }

    private String printNumber(int num)
    {
        if (num == 0)
        {
            return "|    |";
        }
        else if (num < 10)
        {
            return "| " + num + "  |";
        }
        if (num < 100)
        {
            return "| " + num + " |";
        }
        if (num < 1000)
        {
            return "|" + num + " |";
        }
        return "|" + num + "|";
    }

    private boolean checkWinner(int goal)
    {
        for (int r=0; r<4; r++)
        {
            for (int c=0; c<4; c++)
            {
                if (board[r][c] == goal) return true;
            }
        }
        return false;
    }

    private boolean up(int[][] nums)
    {
        int[][] copied = copy(nums);
        for (int r=0; r<3; r++)
        {
            for (int c=0; c<4; c++)
            {
                if (nums[r][c] != 0 && nums[r+1][c] == nums[r][c])
                {
                    nums[r][c]*=2;
                    nums[r+1][c] = 0;
                }
                else if (nums[r][c] !=0 && nums[r+1][c] == 0 && r<2 && nums[r+2][c] == nums[r][c])
                {
                    nums[r][c]*=2;
                    nums[r+2][c] = 0;
                }
                else if (nums[r][c] !=0 && nums[r+1][c] == 0 && r<1 && nums[r+2][c] == 0 && nums[r+3][c] == nums[r][c])
                {
                    nums[r][c]*=2;
                    nums[r+3][c] = 0;
                }
            }
        }
        for (int i=0; i<3; i++)
        {
            for (int r=3; r>0; r--)
            {
                for (int c=0; c<4; c++)
                {
                    if(nums[r-1][c] == 0)
                    {
                        nums[r-1][c] = nums[r][c];
                        nums[r][c] = 0;
                    }
                }
            }
        }
        return !areSame(nums,copied);
    }

    private boolean left(int[][] nums)
    {
        int[][] copied = copy(nums);
        for (int c=0; c<3; c++)
        {
            for (int r=0; r<4; r++)
            {
                if (nums[r][c] != 0 && nums[r][c+1] == nums[r][c])
                {
                    nums[r][c]*=2;
                    nums[r][c+1] = 0;
                }
                else if (nums[r][c] != 0 && nums[r][c+1] == 0 && c<2 && nums[r][c+2] == nums[r][c])
                {
                    nums[r][c]*=2;
                    nums[r][c+2] = 0;
                }
                else if (nums[r][c] != 0 && nums[r][c+1] == 0 && c<1 && nums[r][c+2] == 0 && nums[r][c+3] == nums[r][c])
                {
                    nums[r][c]*=2;
                    nums[r][c+3] = 0;
                }
            }
        }
        for (int i=0; i<3; i++)
        {
            for (int c=3; c>0; c--)
            {
                for (int r=0; r<4; r++)
                {
                    if (nums[r][c-1] == 0)
                    {
                        nums[r][c-1] = nums[r][c];
                        nums[r][c] = 0;
                    }
                }
            }
        }
        return !areSame(nums,copied);
    }

    private boolean down(int[][] nums)
    {
        int[][] copied = copy(nums);
        for (int r=3; r>0; r--)
        {
            for (int c=0; c<4; c++)
            {
                if (nums[r][c] != 0 && nums[r-1][c] == nums[r][c])
                {
                    nums[r][c]*=2;
                    nums[r-1][c] = 0;
                }
                else if (nums[r][c] != 0 && nums[r-1][c] == 0 && r>1 && nums[r-2][c] == nums[r][c])
                {
                    nums[r][c]*=2;
                    nums[r-2][c] = 0;
                }
                else if (nums[r][c] != 0 && nums[r-1][c] == 0 && r>2 && nums[r-2][c] == 0 && nums[r-3][c] == nums[r][c])
                {
                    nums[r][c]*=2;
                    nums[r-3][c] = 0;
                }
            }
        }
        for (int i=0; i<3; i++)
        {
            for (int r=0; r<3; r++)
            {
                for (int c=0; c<4; c++)
                {
                    if (nums[r+1][c] == 0)
                    {
                        nums[r+1][c] = nums[r][c];
                        nums[r][c] = 0;
                    }
                }
            }
        }
        return !areSame(nums,copied);
    }

    private boolean right(int[][] nums)
    {
        int[][] copied = copy(nums);
        for (int c=3; c>0; c--)
        {
            for (int r=0; r<4; r++)
            {
                if (nums[r][c] != 0 && nums[r][c-1] == nums[r][c])
                {
                    nums[r][c]*=2;
                    nums[r][c-1] = 0;
                }
                else if (nums[r][c] != 0 && nums[r][c-1] == 0 && c>1 && nums[r][c-2] == nums[r][c])
                {
                    nums[r][c]*=2;
                    nums[r][c-2] = 0;
                }
                else if (nums[r][c] != 0 && nums[r][c-1] == 0 && c>2 && nums[r][c-2] == 0 && nums[r][c-3] == nums[r][c])
                {
                    nums[r][c]*=2;
                    nums[r][c-3] = 0;
                }
            }
        }
        for (int i=0; i<3; i++)
        {
            for (int c=0; c<3; c++)
            {
                for (int r=0; r<4; r++)
                {
                    if (nums[r][c+1] == 0)
                    {
                        nums[r][c+1] = nums[r][c];
                        nums[r][c] = 0;
                    }
                }
            }
        }
        return !areSame(nums,copied);
    }

    private int[][] copy(int[][] nums)
    {
        int[][] out = new int[4][4];
        for (int i=0; i<4; i++)
        {
            for (int j=0; j<4; j++)
            {
                out[i][j] = nums[i][j];
            }
        }
        return out;
    }

    private boolean areSame(int[][] a, int[][] b)
    {
        for (int i=0; i<4; i++)
        {
            for (int j=0; j<4; j++)
            {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }
}