package projects.critters;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

import java.util.ArrayList;

/**
 * A <code>ChameleonCritter</code> takes on the color of neighboring actors as
 * it moves through the grid. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ChameleonKid extends ChameleonCritter
{
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Location loc = getLocation();
        
        Grid gr = getGrid();
        int[] directions = {Location.AHEAD, Location.HALF_CIRCLE};
        ArrayList<Location> locs = new ArrayList<Location>();
        for (int i = 0; i < directions.length; i ++)
        {
            Location neighbor = loc.getAdjacentLocation(getDirection() + i);
            if (gr.isValid(neighbor))
                locs.add(neighbor);
        }
        
        for (int i = 0; i < locs.size(); i ++)
        {
            Actor a = getGrid().get(locs.get(i));
            if (a != null)
                actors.add(a);
        } 
        return actors;
    }
} 
