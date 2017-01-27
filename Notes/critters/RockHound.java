package projects.critters;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * Write a description of class RockHound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RockHound extends Critter
{
    public void processActors(ArrayList<Actor> actors)
    {
        for (int i = 0; i < actors.size(); i ++)
        {
            if (actors.get(i) instanceof Rock)
                actors.get(i).removeSelfFromGrid();
        }
    }
}
