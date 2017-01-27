package project;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

import java.util.ArrayList;

public class Light extends Actor
{
    public Light()
    {
        setColor(Color.GREEN);
    }

    public void act()
    {
        int r = (int)(Math.random() * 2);
        if (r == 1)
            setColor(Color.RED);

        else
            setColor(Color.GREEN);
    }
}