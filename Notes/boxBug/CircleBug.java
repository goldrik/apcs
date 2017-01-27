package projects.boxBug;
import info.gridworld.actor.Bug;

public class CircleBug extends Bug
{
    private int steps;
    private int r;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public CircleBug(int radius)
    {
        super();
        steps = 0;
        r = radius;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (steps < r && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            steps = 0;
        }
    }
}
