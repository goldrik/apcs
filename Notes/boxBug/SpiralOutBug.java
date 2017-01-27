package projects.boxBug;

import info.gridworld.actor.Bug;

public class SpiralOutBug extends Bug
{
    private int count;
    private int steps;
    private int sideLength;
    private int max;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public SpiralOutBug()
    {
        count = 0;
        steps = 0;
        sideLength = 1;
    }

    public SpiralOutBug(int maximum)
    {
        count = 0;
        steps = 0;
        sideLength = 1;
        max = maximum;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (steps < sideLength && canMove() && sideLength <= max)
        {
            move();
            steps++;
        }
        else
        {
            turn();
            turn();
            steps = 0;

            if (count%2 == 1)
                sideLength ++;
            count++;
        }
    }
}
