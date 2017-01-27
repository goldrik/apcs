/**
 * @author Aurik Sarker 
 * @version 2 December 2013
 * 
 * I, Aurik Sarker, pledge that this program is my own independent 
 * work and conforms to Oxford Academy's Academic Honesty guidelines.
 * However, I did get help from myself. 
 */

import java.util.*;
import java.io.*;

public class Compact
{
    private int[] data;
    private int size;

    Compact()
    {
        data = new int[100];
        size = 0;

        try
        {
            readInData();
        }

        catch(IOException e)
        {
            System.err.print(e.getMessage());
        }
    }
    
    private void readInData() throws IOException
    {
        FileReader file = new FileReader("compact.txt");
        Scanner fileIn = new Scanner(file);

        while(fileIn.hasNext())
        {
            data[size++] = fileIn.nextInt();
        }

        fileIn.close();
    }
    
    public void removeZeros()
    {
        int ind = 0;
        for (int i = 0; i < size; i++)
        {
            if (data[i] != 0)
            {
                int temp = data[i];
                data[i] = data[ind];
                data[ind++] = temp;
            }
        }
    }
}