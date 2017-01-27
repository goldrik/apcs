package projects.boxBug;
import info.gridworld.actor.Bug;

public class RectangleBug extends Bug
{
    private int count;
    private int steps;
    private int sideLength;
    private int sideWidth;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public RectangleBug(int length, int width)
    {
        count = 0;
        steps = 0;
        sideLength = length;
        sideWidth = width;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if(count == 1)
        {
            if (steps < sideLength && canMove())
            {
                move();
                steps++;
            }
            else
            {
                turn();
                steps = 0;
                count = 0;
            }
        }
        
        if(count == 0)
        {
            if (steps < sideWidth && canMove())
            {
                move();
                steps++;
            }
            else
            {
                turn();
                steps = 0;
                count = 1;
            }
        }
    }

    public void turn()
    {
        super.turn();
        super.turn();
    }
}
