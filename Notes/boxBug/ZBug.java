package projects.boxBug;
import info.gridworld.actor.Bug;

public class ZBug extends Bug
{
    private int count;
    private int steps;
    private int sideLength;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public ZBug(int length)
    {
        count = 1;
        steps = 0;
        sideLength = length;
        turn(); turn();
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        int a = count%3;
        if(a == 1)
        {
            if (steps < sideLength && canMove())
            {
                move();
                steps++;
            }
            else
            {
                turn(); turn(); turn();
                steps = 0;
                count++;
            }
        }
        
        else if(a == 2 || a == 4)
        {
            if (steps < sideLength && canMove())
            {
                move();
                steps++;
            }
            else
            {
                turn(); turn(); turn(); turn(); turn();
                steps = 0;
                count++;
            }
        }
        
        else if(a == 0)
        {
            if (steps < sideLength && canMove())
            {
                move();
                steps++;
            }
            else
            {
                turn(); turn(); turn(); turn();
                steps = 0;
                count++;
            }
        }
    }
}
