/**
 * @author Aurik Sarker 
 * @version 7 March 2014
 * 
 * I, Aurik Sarker, pledge that this program is my own independent 
 * work and conforms to Oxford Academy's Academic Honesty guidelines.
 * However, I did get help from myself.
 */

package projects.boxBug;
import info.gridworld.actor.Bug;

import java.util.*;

public class DancingBug extends Bug
{
    int[] nums = new int[20];
    int ind = 0;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public DancingBug()
    {
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++)
            nums[i] = rand.nextInt(9);
        
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (ind == 20)
            ind = 0;

        turn(nums[ind++]);
        if (canMove())
            move();
    }

    public void turn(int a)
    {
        for (int i = 0; i < a; i++)
            super.turn();
    }
}
