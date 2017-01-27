import java.util.*;

public class Checkers
{
    private int curr, your, movesMove, max;
    private int[][] board;
    private int[][] resetBoard = 
        {{2,-1, 2, -1, 2, -1, 2, -1},
            {-1, 2, -1, 2, -1, 2, -1, 2},
            {2, -1, 2, -1, 2, -1, 2, -1},
            {-1, 0, -1, 0, -1, 0, -1, 0},
            {0, -1, 0, -1, 0, -1, 0, -1},
            {-1, 1, -1, 1, -1, 1, -1, 1},
            {1, -1, 1, -1, 1, -1, 1, -1},
            {-1, 1, -1, 1, -1, 1, -1, 1}};

    private int[][] testBoard = 
        {{0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}};

    private Checker toMove, whereMove;
    private ArrayList<Checker> myPieces = new ArrayList<Checker>();
    private ArrayList<Checker> moves = new ArrayList<Checker>();
    private ArrayList<Checker> jumps = new ArrayList<Checker>();

    ArrayList<ArrayList<Checker>> myMoves = new ArrayList<ArrayList<Checker>>();

    Scanner keyIn = new Scanner(System.in);

    Checkers()
    {
        board = new int[8][8];
    }

    private void resetBoard()
    {
        for (int r = 0; r < board.length; r ++)
        {
            for (int c = 0; c < board[r].length; c ++)
            {
                board[r][c] = resetBoard[r][c];
            }
        }
    }

    public void newGame()
    {
        System.out.println("Let's play CHECKERS!\n"); rules();

        boolean again = true;
        while(again)
        {
            resetBoard();

            curr = 1;
            while(gameOn())
            {
                turn();

                curr = Math.abs(curr-3);
                your = Math.abs(curr-3);
            }
            System.out.println("\nPlayer " + your + " has won!");

            System.out.print("\nPlay again? (Y/N) ");
            if (!keyIn.nextLine().equalsIgnoreCase("y"))
                again = false;
        }

        System.out.println("\nThanks for playing!");
    }

    private void turn()
    {
        System.out.print("\nWhenever you're ready, Player " + curr);
        String placeholder = keyIn.nextLine();

        printBoard();
        System.out.println("\nPlayer " + curr + ", make your move\n");

        if (curr == 1)
            humanMove();
        if (curr == 2)
            AIMove();
    }

    private void humanMove()
    {
        myPieces = getPlayable(curr);

        System.out.print("Available pieces to move: ");
        for (int i = 0; i < myPieces.size(); i ++)
            System.out.print(myPieces.get(i).checkerToString() + " ");

        Checker temp;
        do
        {
            System.out.print("\nEnter coordinate of the piece you'd like to move: ");
            temp = stringToChecker(keyIn.nextLine());
        } 
        while (!isValid(temp.row, temp.col) || !isAPiece(temp));
        toMove = temp;
        moves = getMoves(toMove); jumps = getJumps(toMove);

        System.out.print("\nAvailable locations to move: ");
        for (int i = 0; i < moves.size(); i ++)
            System.out.print(moves.get(i).checkerToString() + " ");

        whereMove = enterMove();
        updateBoard();

        if (Math.abs(toMove.col - whereMove.col) == 2)
        {
            board[(whereMove.row+toMove.row)/2][(whereMove.col+toMove.col)/2] = 0;
            printBoard();

            toMove = new Checker(whereMove.row, whereMove.col);
            moves = getMoves(toMove); jumps = getJumps(toMove);

            while (jumps.size() > 0)
            {
                System.out.print("\nJump Again: ");
                for (int i = 0; i < moves.size(); i ++)
                    System.out.print(moves.get(i).checkerToString() + " ");

                whereMove = enterMove();
                board[(whereMove.row+toMove.row)/2][(whereMove.col+toMove.col)/2] = 0;
                updateBoard();

                toMove = new Checker(whereMove.row, whereMove.col);
                moves = getMoves(toMove); jumps = getJumps(toMove);
            }
        }
    }

    private Checker enterMove()
    {
        Checker a;
        do
        {
            System.out.print("\nEnter coordinate of where you'd like to move: ");
            a = stringToChecker(keyIn.nextLine());
        } 
        while (!validMove(a));

        return a;
    }

    private Checker stringToChecker(String a)
    {
        int x = -1, y = -1;
        boolean next = false;
        for (int i = 0; i < a.length(); i ++)
        {
            char c = a.charAt(i);
            if (!next && Character.isDigit(c))
            {
                x = c - 48;
                next = !next;
            }

            if (next && Character.isDigit(c))
                y = c - 48;
        }

        return new Checker(x,y);
    }

    private void AIMove()
    {
        int movesMove = 0;
        int max = -16;

        int[][] save = new int[8][8]; copy(board, save);

        ArrayList<Move> moves21 = new ArrayList<Move>();
        ArrayList<Move> moves11 = new ArrayList<Move>();
        ArrayList<Move> moves22 = new ArrayList<Move>();
        ArrayList<Move> moves12 = new ArrayList<Move>();
        ArrayList<Move> moves23 = new ArrayList<Move>();
        ArrayList<Move> moves13 = new ArrayList<Move>();
        ArrayList<Move> moves24 = new ArrayList<Move>();
        ArrayList<Move> moves14 = new ArrayList<Move>();

        int[][] board21 = new int[8][8]; 
        int[][] board11 = new int[8][8];
        int[][] board22 = new int[8][8];
        int[][] board12 = new int[8][8];
        int[][] board23 = new int[8][8];
        int[][] board13 = new int[8][8];
        int[][] board24 = new int[8][8];
        int[][] board14 = new int[8][8];

        moves21 = addMoves(2);
        copy(board, board21);
        for (int a = 0; a < moves21.size(); a ++)
        {
            //AIProcedure(board21, moves21, a, moves11, 1, board11);
            copy(board21, board);
            virtualMove(moves21.get(a));

            moves11 = addMoves(1);
            copy(board, board11);
            for (int b = 0; b < moves11.size(); b ++)
            {
                //AIProcedure(board11, moves11, b, moves22, 2, board22);
                copy(board11, board);
                virtualMove(moves11.get(b));

                moves22 = addMoves(2);
                copy(board, board22);
                for (int c = 0; c < moves22.size(); c ++)
                {
                    //AIProcedure(board22, moves22, c, moves12, 1, board12);
                    copy(board22, board);
                    virtualMove(moves22.get(c));

                    moves12 = addMoves(1);
                    copy(board, board12);
                    for (int d = 0; d < moves12.size(); d ++)
                    {
                        //AIProcedure(board12, moves12, d, moves23, 2, board23);
                        copy(board12, board);
                        virtualMove(moves12.get(d));

                        moves23 = addMoves(2);
                        copy(board, board23);
                        for (int e = 0; e < moves23.size(); e ++)
                        {
                            //AIProcedure(board23, moves23, e, moves13, 1, board13);
                            copy(board23, board);
                            virtualMove(moves23.get(e));

                            moves13 = addMoves(1);
                            copy(board, board13);
                            for (int f = 0; f < moves13.size(); f ++)
                            {
                                //AIProcedure(board13, moves13, f, moves24, 2, board24);
                                copy(board13, board);
                                virtualMove(moves13.get(f));

                                moves24 = addMoves(2);
                                copy(board, board24);
                                for (int g = 0; g < moves24.size(); g ++)
                                {
                                    //AIProcedure(board24, moves24, g, moves14, 1, board14);
                                    copy(board24, board);
                                    virtualMove(moves24.get(g));

                                    moves14 = addMoves(1);
                                    copy(board, board14);
                                    for (int h = 0; h < moves14.size(); h ++)
                                    {
                                        //AIProcedure(board14, moves14, h, moves25, 2, board25);
                                        copy(board14, board);
                                        virtualMove(moves14.get(h));

                                        if (AIWinning() >= max)
                                        //if (getPieces(2).size() >= max)
                                        {
                                            max = AIWinning();
                                            //max = getPieces(2).size();
                                            movesMove = a;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        copy(save, board);
        virtualMove(moves21.get(movesMove));

        printBoard();
    }

    private void copy(int[][] original, int[][] copy)
    {
        for (int r = 0; r < board.length; r ++)
        {
            for (int c = 0; c < board[r].length; c ++)
                copy[r][c] = original[r][c];
        }
    }

    private ArrayList<Move> addMoves(int p)
    {
        myPieces = getPlayable(p);

        myMoves.clear();
        for (int i = 0; i < myPieces.size(); i ++)
            myMoves.add(getMoves(myPieces.get(i)));

        ArrayList<Move> allMoves = new ArrayList<Move>();
        for (int r = 0; r < myPieces.size(); r ++)
        {
            for (int c = 0; c < myMoves.get(r).size(); c ++)
                allMoves.add(new Move(myPieces.get(r), myMoves.get(r).get(c)));
        }

        return allMoves;
    }

    private void virtualMove(Move move)
    {
        toMove = move.to;
        whereMove = move.where;

        board[whereMove.row][whereMove.col] = toMove.player;
        board[toMove.row][toMove.col] = 0;
        checkForKings();
        if (Math.abs(toMove.col - whereMove.col) == 2)
        {
            board[(whereMove.row+toMove.row)/2][(whereMove.col+toMove.col)/2] = 0;

            toMove = new Checker(whereMove.row, whereMove.col);
            while (getJumps(toMove).size() > 0)
            {
                whereMove = getJumps(toMove).get(0);

                board[whereMove.row][whereMove.col] = toMove.player;
                board[(whereMove.row+toMove.row)/2][(whereMove.col+toMove.col)/2] = 0;
                board[toMove.row][toMove.col] = 0;
                checkForKings();

                toMove = new Checker(whereMove.row, whereMove.col);
            }
        }
    }

    private void AIProcedure(int[][] b, ArrayList<Move> m, int i, ArrayList<Move> n, int t, int[][] c)
    {
        copy(b, board);
        virtualMove(m.get(i));

        n = addMoves(t);
        c = new int[8][8]; copy(board, c);
    }

    private boolean validMove(Checker a)
    {
        for (int i = 0; i < moves.size(); i ++)
        {
            if (a.row == moves.get(i).row && a.col == moves.get(i).col)
                return true;
        }
        return false;
    }

    private boolean isValid(int row, int col)
    {
        return row >= 0 && col >= 0 && row < 8 && col < 8;
    }

    private boolean isAPiece(Checker a)
    {
        for (int i = 0; i < myPieces.size(); i ++)
        {
            if (a.equals(myPieces.get(i)))
                return true;
        }
        return false;
    }

    private ArrayList<Checker> getPieces(int a)
    {
        ArrayList<Checker> p = new ArrayList<Checker>();
        for (int r = 0; r < board.length; r ++)
        {
            for (int c = 0; c < board[r].length; c ++)
            {
                if (board[r][c] == a || board[r][c] == a+2)
                    p.add(new Checker(r,c));
            }
        }

        return p;
    }

    private ArrayList<Checker> getPlayable(int a)
    {
        ArrayList<Checker> p = getPieces(a);
        for (int i = 0; i < p.size(); i ++)
        {
            if (getMoves(p.get(i)).size() == 0)
            {
                p.remove(i);
                i--;
            }
        }

        ArrayList<Checker> jumpers = new ArrayList<Checker>();
        for (int i = 0; i < p.size(); i ++)
        {
            if (getJumps(p.get(i)).size() > 0)
                jumpers.add(p.get(i));
        }

        if (jumpers.size() > 0)
            return jumpers;
        return p;
    }

    private ArrayList<Checker> getMoves(Checker a)
    {
        ArrayList<Checker> m = new ArrayList<Checker>();
        ArrayList<Checker> j = getJumps(a);

        if (j.size() == 0)
        {
            if (a.player != 2)
            {
                if (isValid(a.row-1, a.col-1))
                {
                    if (board[a.row-1][a.col-1] == 0)
                        m.add(new Checker(a.row-1, a.col-1));
                }
                if (isValid(a.row-1, a.col+1))
                {
                    if (board[a.row-1][a.col+1] == 0)
                        m.add(new Checker(a.row-1, a.col+1));
                }
            }

            if (a.player != 1)
            {
                if (isValid(a.row+1, a.col-1))
                {
                    if (board[a.row+1][a.col-1] == 0)
                        m.add(new Checker(a.row+1, a.col-1));
                }
                if (isValid(a.row+1, a.col+1))
                {
                    if (board[a.row+1][a.col+1] == 0)
                        m.add(new Checker(a.row+1, a.col+1));
                }
            }
        }
        else
            m = j;

        return m;
    }

    private ArrayList<Checker> getJumps(Checker a)
    {
        ArrayList<Checker> j = new  ArrayList<Checker>();

        if (a.player == 1 || a.player == 3)
        {
            if (a.player == 3)
            {
                if (isValid(a.row+1, a.col-1) && isValid(a.row+2, a.col-2))
                {
                    if ((board[a.row+1][a.col-1] == 2 || board[a.row+1][a.col-1] == 4) && board[a.row+2][a.col-2] == 0)
                        j.add(new Checker(a.row+2, a.col-2));
                }
                if (isValid(a.row+1, a.col+1) && isValid(a.row+2, a.col+2))
                {
                    if ((board[a.row+1][a.col+1] == 2 || board[a.row+1][a.col+1] == 4) && board[a.row+2][a.col+2] == 0)
                        j.add(new Checker(a.row+2, a.col+2));
                }
            }
            if (isValid(a.row-1, a.col-1) && isValid(a.row-2, a.col-2))
            {
                if ((board[a.row-1][a.col-1] == 2 || board[a.row-1][a.col-1] == 4) && board[a.row-2][a.col-2] == 0)
                    j.add(new Checker(a.row-2, a.col-2));
            }
            if (isValid(a.row-1, a.col+1) && isValid(a.row-2, a.col+2))
            {
                if ((board[a.row-1][a.col+1] == 2 || board[a.row-1][a.col+1] == 4) && board[a.row-2][a.col+2] == 0)
                    j.add(new Checker(a.row-2, a.col+2));
            }
        }

        if (a.player == 2 || a.player == 4)
        {
            if (a.player == 4)
            {
                if (isValid(a.row-1, a.col+1) && isValid(a.row-2, a.col+2))
                {
                    if ((board[a.row-1][a.col+1] == 1 || board[a.row-1][a.col+1] == 3) && board[a.row-2][a.col+2] == 0)
                        j.add(new Checker(a.row-2, a.col+2));
                }
                if (isValid(a.row-1, a.col-1) && isValid(a.row-2, a.col-2))
                {
                    if ((board[a.row-1][a.col-1] == 1 || board[a.row-1][a.col-1] == 3) && board[a.row-2][a.col-2] == 0)
                        j.add(new Checker(a.row-2, a.col-2));
                }
            }
            if (isValid(a.row+1, a.col+1) && isValid(a.row+2, a.col+2))
            {
                if ((board[a.row+1][a.col+1] == 1 || board[a.row+1][a.col+1] == 3) && board[a.row+2][a.col+2] == 0)
                    j.add(new Checker(a.row+2, a.col+2));
            }
            if (isValid(a.row+1, a.col-1) && isValid(a.row+2, a.col-2))
            {
                if ((board[a.row+1][a.col-1] == 1 || board[a.row+1][a.col-1] == 3) && board[a.row+2][a.col-2] == 0)
                    j.add(new Checker(a.row+2, a.col-2));
            }
        }

        return j;
    }

    private void updateBoard()
    {
        board[whereMove.row][whereMove.col] = toMove.player;
        board[toMove.row][toMove.col] = 0;
        printBoard();

        if (checkForKings())
            System.out.println("\nKing you!");
    }

    private boolean checkForKings()
    {
        for (int c = 0; c < board[0].length; c ++)
        {
            if (board[0][c] == 1)
            {
                board[0][c] += 2;
                return true;
            }

            if (board[7][c] == 2)
            {
                board[7][c] += 2;
                return true;
            }
        }
        return false;
    }

    private int AIWinning()
    {
        return getPieces(2).size() - getPieces(1).size();
    }

    private boolean gameOn()
    {
        return getPlayable(1).size() != 0 && getPlayable(2).size() != 0;
    }

    public void printBoard()
    {
        System.out.println("\f           Current board: ");

        System.out.println("  c 0   1   2   3   4   5   6   7 ");
        System.out.println("r +---+---+---+---+---+---+---+---+");
        for(int r = 0; r < board.length; r++)
        {
            System.out.print(r + " | ");
            for(int c = 0; c < board[r].length; c++)
            {
                switch(board[r][c])
                {
                    case -1:
                    System.out.print("\\"); break;
                    case 1:
                    System.out.print("W"); break;
                    case 2:
                    System.out.print("B"); break;
                    case 3:
                    System.out.print("K"); break;
                    case 4:
                    System.out.print("k"); break;
                    default:
                    System.out.print(" "); break;
                }

                if (c < board[r].length-1)
                    System.out.print(" | ");
            }
            System.out.print(" | ");

            if (r < board.length-1)
                System.out.println("\n  |---|---|---|---|---|---|---|---|");
        }
        System.out.println("\n  +---+---+---+---+---+---+---+---+");
    }

    public static void rules()
    {
        System.out.println("Rules:");
        System.out.println("  Players: 2 ");
        System.out.println("  Objective: To capture or block all of the opponent's pieces");

        System.out.println("\n  Players begin the game with twelve pieces, labeled B or W. W moves first.");
        System.out.println("  Pieces may only move diagonally. ");
        System.out.println("  If a player is able to make a capture, the jump must be made.");
        System.out.println("    A piece may jump over an opponent's piece onto an empty square."); 
        System.out.println("    Only one piece may be captured in a single jump");
        System.out.println("    Multiple jumps are allowed on a single turn.");
        System.out.println("  When a piece reaches the opposite side, it becomes a king. ");
        System.out.println("    Kings may move both forward and backward.");

        System.out.println("  Enter coordinates by typing the row and column of the location you choose");
        System.out.println("    Example: (5, 5) may be entered as '(5,5)' 'r5 c5' or '55'");
    }

    private class Checker
    {
        private int row, col, player;

        Checker(int y, int x)
        {
            col = x;
            row = y;

            player = getPiece();
        }

        private int getRow()
        {
            return row;
        }

        private int getCol()
        {
            return col;
        }

        private boolean isValid()
        {
            return row >= 0 && col >= 0 && row < 8 && col < 8;
        }

        private int getPiece()
        {
            if (!isValid()) 
                return -1;
            return board[row][col];
        }

        private boolean equals(Checker a)
        {
            return this.getRow() == a.getRow() && this.getCol() == a.getCol();
        }

        private String checkerToString()
        {
            return "(" + row + ", " + col + ")";
        }
    }

    private class Move
    {
        private Checker to, where;    

        Move(Checker a, Checker b)
        {
            to = a;
            where = b;
        }
    }
}