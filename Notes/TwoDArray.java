import gpdraw.*;
import java.awt.Color;

public class TwoDArray
{
    private DrawingTool brush;
    private SketchPad canvas;
    
    int [][] board = { { 1, 3, 4 }, { 5, 7, 9}, { 2, 8, 6} }; // two rows and three columns (2x3)
    Color [][] picture;
    
    public TwoDArray()
    {
        canvas = new SketchPad(600, 400, 1);
        brush = new DrawingTool(canvas);
        picture = new Color[200][300];
        init();
    }
    
    public void init()
    {
        for(int r = 0; r < picture.length; r++)
        {
            for(int c = 0; c < picture[r].length; c++)
            {
                int rc = (r*3)%255;
                int g = (r*5)%255;
                int b = (c*7)%255;
                picture[r][c] = new Color(rc,g,b);
            }
        }
    }
    
    public void draw()
    {
        for(int r = 0; r < picture.length; r++)
        {
            for(int c = 0; c < picture[r].length; c++)
            {
                brush.setColor(picture[r][c]);
                brush.move(c,r);
            }
        }
    }
    
    public void printBoard()
    {
        int sum = 0;
        for (int r = 0; r < board.length; r++)
        {
            System.out.print( (r+1) + ". " );
            for (int c = 0; c < board[r].length; c++)
            {
                sum += board[r][c];
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("\nSum: " + sum);
    }
    
    public void initArray()
    {
        for (int r = 0; r < board.length; r++)
        {
            for (int c = 0; c < board[r].length; c++)
            {
                board[r][c] = (3*r) + c + 1;
            }
        }
    }
}
