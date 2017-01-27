package projects.boxBug;

/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Rock;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class BoxBugRunner
{
    public static void BoxBugRunner(String[] args)
    {
        ActorWorld world = new ActorWorld();
        BoxBug alice = new BoxBug(6);
        alice.setColor(Color.ORANGE);
        BoxBug bob = new BoxBug(3);
        world.add(new Location(7, 8), alice);
        world.add(new Location(5, 5), bob);
        world.show();
    }
    
    public static void RectangleBugRunner(String[] args)
    {
        ActorWorld world = new ActorWorld();
        RectangleBug alice = new RectangleBug(6,3);
        alice.setColor(Color.ORANGE);
        RectangleBug bob = new RectangleBug(3,2);
        world.add(new Location(7, 8), alice);
        world.add(new Location(5, 5), bob);
        world.show();
    }
    
    public static void CircleBugRunner(String[] args)
    {
        ActorWorld world = new ActorWorld();
        CircleBug bob = new CircleBug(7);
        world.add(new Location(0, 0), bob);
        world.show();
    }
    
    public static void SpiralOutBugRunner(String[] args)
    {
        ActorWorld world = new ActorWorld();
        SpiralOutBug bob = new SpiralOutBug(10);
        world.add(new Location(0, 0), bob);
        world.show();
    }
    
    public static void SpiralInBugRunner(String[] args)
    {
        ActorWorld world = new ActorWorld();
        SpiralInBug bob = new SpiralInBug(10);
        world.add(new Location(0, 0), bob);
        world.show();
    }
    
    public static void ZBugRunner(String[] args)
    {
        ActorWorld world = new ActorWorld();
        ZBug bob = new ZBug(5);
        world.add(new Location(2, 0), bob);
        ZBug collin = new ZBug(5);
        world.add(new Location(1, 2), collin);
        collin.setColor(Color.YELLOW);
        ZBug alice = new ZBug(5);
        world.add(new Location(0, 4), alice);
        alice.setColor(Color.BLUE);
        world.show();
    }
    
    public static void DancingBugRunner(String[] args)
    {
        ActorWorld world = new ActorWorld();
        DancingBug alpha = new DancingBug();
        world.add(new Location(0, 0), alpha);
        //DancingBug beta = new DancingBug();
        //world.add(new Location(0, 1), beta);
        //beta.setColor(new Color(0, 255, 255));
        //DancingBug delta = new DancingBug();
        //world.add(new Location(1, 1), delta);
        //delta.setColor(new Color(255, 0, 255));
        //DancingBug gamma = new DancingBug();
        //world.add(new Location(1, 0), gamma);
        //gamma.setColor(new Color(0, 255, 0));
        //DancingBug epsilon = new DancingBug();
        //world.add(new Location(2, 2), epsilon);
        //epsilon.setColor(new Color(255, 255, 255));
        world.show();
        //world.setGrid(new UnboundedGrid());
    }
    
    public static void JumpingBugRunner(String[] args)
    {
        ActorWorld world = new ActorWorld();
        JumpingBug bob = new JumpingBug();
        world.add(new Location(4, 4), bob);
        world.add(new Location(2, 4), new Rock());
        world.show();
    }
}