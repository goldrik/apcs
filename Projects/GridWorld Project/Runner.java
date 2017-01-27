package project;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.awt.Color;

public class Runner
{
    public static void CarRunner()
    {
        ActorWorld world = new ActorWorld(new BoundedGrid(20, 20));;
        world.add(new Location(7, 4), new Car());
        world.add(new Location(15, 14), new Car());
        world.add(new Location(1, 1), new Light());
        world.add(new Location(1, 5), new Light());
        world.add(new Location(1, 9), new Light());
        world.add(new Location(1, 13), new Light());
        world.add(new Location(1, 17), new Light());
        world.add(new Location(3, 3), new Light());
        world.add(new Location(3, 7), new Light());
        world.add(new Location(3, 11), new Light());
        world.add(new Location(3, 15), new Light());
        world.add(new Location(5, 1), new Light());
        world.add(new Location(5, 5), new Light());
        world.add(new Location(5, 9), new Light());
        world.add(new Location(5, 13), new Light());
        world.add(new Location(5, 17), new Light());
        world.add(new Location(7, 3), new Light());
        world.add(new Location(7, 7), new Light());
        world.add(new Location(7, 11), new Light());
        world.add(new Location(7, 15), new Light());
        world.add(new Location(9, 1), new Light());
        world.add(new Location(9, 5), new Light());
        world.add(new Location(9, 9), new Light());
        world.add(new Location(9, 13), new Light());
        world.add(new Location(9, 17), new Light());
        world.add(new Location(11, 3), new Light());
        world.add(new Location(11, 7), new Light());
        world.add(new Location(11, 11), new Light());
        world.add(new Location(11, 15), new Light());
        world.add(new Location(13, 1), new Light());
        world.add(new Location(13, 5), new Light());
        world.add(new Location(13, 9), new Light());
        world.add(new Location(13, 13), new Light());
        world.add(new Location(13, 17), new Light());
        world.add(new Location(15, 3), new Light());
        world.add(new Location(15, 7), new Light());
        world.add(new Location(15, 11), new Light());
        world.add(new Location(15, 15), new Light());
        world.add(new Location(17, 1), new Light());
        world.add(new Location(17, 5), new Light());
        world.add(new Location(17, 9), new Light());
        world.add(new Location(17, 13), new Light());
        world.add(new Location(17, 17), new Light());
        world.add(new Location(5, 7), new Gas());
        world.add(new Location(13, 11), new Gas());
        world.add(new Location(5, 6), new Pedestrian());
        world.add(new Location(2, 6), new Pedestrian());
        world.add(new Location(4, 1), new Pedestrian());
        world.add(new Location(14, 12), new Pedestrian());
        world.show();
    }
}