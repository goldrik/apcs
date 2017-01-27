/**
 * @author Aurik Sarker 
 * @version 11 September 2013
 */

import java.util.Random;

public class Dice implements Comparable
{
    private int mySides;
    private Random roller;
    private int previousRoll;
    private int rollCount;
    
    // Two constructors
    Dice()
    {
        mySides = 6;
        roller = new Random();
        previousRoll = -1;
        rollCount = 0;
    }
    
    Dice(int sides)
    {
        setSides(sides);
        roller = new Random();
        previousRoll = -1;
        rollCount = 0;
    }
    
    Dice(int sides, long seed)
    {
        setSides(sides);
        roller = new Random(seed);
    }
    
    public void resetRoller()
    {
        roller = new Random();
    }
    
    // Mutator / Modifier 
    public void setSides(int sides)
    {
        if (sides >= 2 && sides <= 100) // Input is valid
            mySides = sides;
        
        else
            mySides = 6;
    }
    
    // Accessor
    // Access, return type, method name, (parameter)
    public int getSides()
    {
        return mySides;
    }
    
    public int getPreviousRoll()
    {
        return previousRoll;
    }
    
    public int getRollCount()
    {
        return rollCount;
    }
    
    // Action
    public int getNextRoll()
    {
        previousRoll = roller.nextInt(mySides) + 1; 
        rollCount++;
        return previousRoll;
    }
    
    public int compareTo(Object ob)
    {
        Dice otherDice = (Dice)ob;
        
        return mySides - otherDice.getSides();
        
        // return myName.compareTo(otherPerson.getName());
    }

}