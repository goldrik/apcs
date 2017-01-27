package project;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

import java.util.ArrayList;

public class Pedestrian extends Critter
{
    int count;
    public Pedestrian()
    {
        setColor(Color.BLACK);
        count = 1;
    }

    public void processActors(ArrayList<Actor> actors)
    {
    }
    
    public void act()
    {
        /**
        if (count%10 == 0)
        {
            Location temp = new Location((int)(20*Math.random()), (int)(20*Math.random()));
            if (getGrid().isValid(temp) && getGrid().get(temp) == null)
                getGrid().put(temp, new Pedestrian());
        }
        count++;
        **/
        
        super.act();
    }
}