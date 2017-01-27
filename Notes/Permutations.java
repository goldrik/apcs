/**
 * @author Aurik Sarker 
 * @version 20 December 2013
 * 
 * I, Aurik Sarker, pledge that this program is my own independent 
 * work and conforms to Oxford Academy's Academic Honesty guidelines.
 * However, I did get help from myself. 
 */

import java.util.ArrayList;
import java.util.Random;

public class Permutations
{
    private ArrayList<Integer> nums;
    private ArrayList<Integer> perm;
    private Random rand = new Random();

    Permutations()
    {
        loadNumbers();
    }

    private void loadNumbers()
    {
        nums = new ArrayList<Integer> ();
        for (int i = 1; i <= 10; i++)
            nums.add(i);
    }

    public void nextPermutation()
    {
        loadNumbers();
        perm = new ArrayList<Integer> ();
        for (int i = 1; i <= 10; i++)
        {
            int temp = rand.nextInt(nums.size());
            perm.add(nums.get(temp));
            nums.remove(temp);
        }
    }

    public void printPermutations()
    {
        for (int i = 0; i < 10; i++)
        {
            nextPermutation();
            System.out.println(perm);
        }
    }
}
