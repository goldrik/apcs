package project;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

import java.util.ArrayList;

public class Car extends Critter
{
    private boolean canMove = true;
    private boolean light = false;

    public void processActors(ArrayList<Actor> actors)
    {
        Color c = getColor();
        int red = (int) (c.getRed() * (1 - 0.01));
        int green = (int) (c.getGreen() * (1 - 0.01));
        int blue = (int) (c.getBlue() * (1 - 0.01));

        setColor(new Color(red, green, blue));

        for (Actor a : actors)
        {
            if (a instanceof Car)
            {
                a.removeSelfFromGrid();
                removeSelfFromGrid();
            }
            
            else if (a instanceof Pedestrian)
                a.removeSelfFromGrid();
            
            else if (a instanceof Gas)
                setColor(Color.BLUE);

            if (getGrid().isValid(getLocation().getAdjacentLocation(getDirection())))
            {
                Location front = getLocation().getAdjacentLocation(getDirection());

                Actor b = null;
                if (getGrid().get(front) != null)
                    b = getGrid().get(front);

                if (b instanceof Light)
                {
                    light = true;
                    if (b.getColor() == Color.GREEN)
                        canMove = true;
                    else
                        canMove = false;
                }
                else if (b instanceof Gas)
                {
                    light = true;
                    canMove = true;
                }
                else if (b instanceof Pedestrian)
                {
                    b.removeSelfFromGrid();
                    light = false;
                    canMove = true;
                }
                else
                    light = false;
            }
        }
    }

    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();

        Location temp = getLocation().getAdjacentLocation(getDirection());
        while (!getGrid().isValid(temp) || getGrid().get(temp) instanceof Pedestrian)
        {
            rotate();
            temp = getLocation().getAdjacentLocation(getDirection());
        }
        locs.add(temp);

        return locs;
    }

    public Location selectMoveLocation(ArrayList<Location> locs)
    {
        if (!light)
        {
            return locs.get(0);
        }

        else
        {
            if (canMove)
                return locs.get(0).getAdjacentLocation(getDirection());
            else
                return getLocation();
        }
    }

    public void makeMove(Location loc)
    {
        if (loc == null)
            removeSelfFromGrid();
        else
        { 
            if (!light)
                rotate();
            moveTo(loc);
        }
    }

    public void rotate()
    {
        ArrayList<Integer> dir = new ArrayList<Integer>();
        for (int i = 0; i < 360; i += 90)
        {
            Location t = getLocation().getAdjacentLocation(i);
            if (getGrid().isValid(t) && getGrid().get(t) == null)
                dir.add(i);
        }

        int n = dir.size();
        int d = (int) (Math.random() * n);
        setDirection(dir.get(d));
    }
}
