package projects.critters;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class KingCrab extends CrabCritter
{
    private int distanceFrom(Location loc1, Location loc2)
    {
        return 0;
    }
    
    public void processActors(ArrayList<Actor> actors)
    {
        for (int i = 0; i < actors.size(); i ++)
        {
            if (!moveOne(actors.get(i)))
            {
                actors.get(i).removeSelfFromGrid();
            }
        }
    }
    
    private boolean moveOne(Actor a)
    {
        ArrayList<Location> locs = getGrid().getEmptyAdjacentLocations(a.getLocation());
        for(Location loc:locs)
        {
            if(distanceFrom(getLocation(), loc) > 1)
            {
                a.moveTo(loc);
                return true;
            }
        }
        return false;
    }
} 