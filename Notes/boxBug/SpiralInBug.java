package projects.boxBug;

import info.gridworld.actor.Bug;

public class SpiralInBug extends Bug
{
    private int count;
    private int steps;
    private int sideLength;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public SpiralInBug(int length)
    {
        count = 0;
        steps = 0;
        sideLength = length;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            turn();
            steps = 0;
            
            if (count%2 == 0)
                sideLength --;
            count++;
        }
    }
}
