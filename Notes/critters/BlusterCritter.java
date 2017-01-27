package projects.critters;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

import java.util.ArrayList;

public class BlusterCritter extends Critter
{
    private int courage;
    private double factor;

    public BlusterCritter(int f)
    {
        super();
        courage = f;
        factor = 0.01;
    }

    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Location loc = getLocation();
        for(int r = loc.getRow() - 2; r <= loc.getRow() + 2; r++ )
        {
            for(int c = loc.getCol() - 2; c <= loc.getCol() + 2; c++)
            {
                Location temp = new Location(r,c);
                if(getGrid().isValid(temp))
                {
                    Actor a = getGrid().get(temp);
                    if(a != null && a != this)
                        actors.add(a);
                }
            }
        }
        return actors;
    }

    public void processActors(ArrayList<Actor> actors)
    {
        int count = 0;
        for(int i = 0; i < actors.size(); i ++)
        {
            if(actors.get(i) instanceof Critter)
                count++;
        }
        
        if(count >= courage)
            factor *= -1;
        colorChange();
    }

    private void colorChange()
    {
        Color c = getColor();
        int red = (int)(c.getRed() * (1 + factor));
        int green = (int)(c.getGreen() * (1 + factor));
        int blue = (int)(c.getBlue() * (1 + factor));

        setColor(new Color(red, green, blue));
    }
} 