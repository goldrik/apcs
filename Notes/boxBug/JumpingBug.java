/**
 * @author Aurik Sarker 
 * @version 12 March 2014
 * 
 * I, Aurik Sarker, pledge that this program is my own independent 
 * work and conforms to Oxford Academy's Academic Honesty guidelines.
 * However, I did get help from myself.
 */

package projects.boxBug;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class JumpingBug extends Bug
{
    private Grid<Actor> gr;
    private Location loc1;
    private Location next;
    private Location loc2;

    private Actor neighbor;
    private Actor remember;

    private int onFlower = 0;
    private int onRock = 0;

    public JumpingBug()
    {
    }

    public void act()
    {
        gr = getGrid();
        loc1 = getLocation();
        next = loc1.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
        {
            super.turn();
            super.turn();
            next = loc1.getAdjacentLocation(getDirection());
        }
        neighbor = gr.get(next);

        loc2 = next.getAdjacentLocation(getDirection());
        if (canJump())
            remember = gr.get(loc2);

        if (onFlower == 1)
            onFlower++;
        if (onRock == 1)
            onRock++;

        if (neighbor == null)
            move();
        else if (canJump())
        {
            if (remember instanceof Flower)
                onFlower++;
            if (remember instanceof Rock)
                onRock++;
            jump();
        }
        else
        {
            super.turn();
            super.turn();
            move();
        }

        if (onFlower == 2)
        {
            gr.put(loc1, new Flower(new Color(0,0,0)));
            onFlower = 0;
        }

        if (onRock == 2)
        {
            gr.put(loc1, new Rock());
            onRock = 0;
        }
    }

    private boolean canJump()
    {
        return gr.isValid(loc2);
    }

    private void jump()
    {
        moveTo(loc2);
    }
}