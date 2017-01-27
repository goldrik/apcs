package projects.critters;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.awt.Color;

import java.util.ArrayList;

public class QuickCrab extends CrabCritter
{
    private Grid g;
    private Location loc;
    private int dir;
    
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        loc = getLocation();
        dir = getDirection();
        g = getGrid();
        
        addMove(locs, dir + 90);
        addMove(locs, dir + 270);
        
        if (locs.size() == 0)
            return super.getMoveLocations();
        return locs;
    }

    private void addMove(ArrayList<Location> locs, int direction)
    {
        Location temp = loc.getAdjacentLocation(direction);
        if(g.isValid(temp) && g.get(temp) == null)
        {
            Location loc2 = temp.getAdjacentLocation(direction);
            if(g.isValid(loc2) && g.get(loc2)== null)
                locs.add(loc2);
        }
    }
} 