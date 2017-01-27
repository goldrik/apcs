/**
 * @author Aurik Sarker 
 * @version 15 November 2013
 * 
 * I, Aurik Sarker, pledge that this program is my own independent 
 * work and conforms to Oxford Academy's Academic Honesty guidelines.
 * However, I did get help from myself. 
 */

import java.util.*;
import java.io.*;

public class Statistics
{
    private int[] data;
    private int size;

    Statistics()
    {
        data = new int[1000];
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

    Statistics(String fileName)
    {
        data = new int[1000];
        size = 0;

        try
        {
            readInFromFile(fileName);
        }

        catch(IOException e)
        {
            System.err.print(e.getMessage());
        }
    }

    private void readInData() throws IOException
    {
        FileReader file = new FileReader("data116.txt");
        Scanner fileIn = new Scanner(file);

        while(fileIn.hasNext())
        {
            data[size++] = fileIn.nextInt();
        }

        fileIn.close();
    }

    private void readInFromFile(String fileName) throws IOException
    {
        FileReader file = new FileReader(fileName);
        Scanner fileIn = new Scanner(file);

        while(fileIn.hasNext())
        {
            data[size++] = fileIn.nextInt();
        }

        fileIn.close();
    }

    public int getSize()
    {
        return size;
    }

    public int getIndex(int ind)
    {
        return data[ind];
    }

    public String addNumberToData(int number)
    {
        if(size < data.length)
        {
            data[size++] = number;
            return "Input Successful";
        }

        else
            return "Input Unsuccessful";
    }

    public String addNumberAtIndex(int number, int index)
    {
        if(index < data.length)
        {
            data[index] = number;
            return "Input Successful";
        }

        else
            return "Input Unsuccessful";
    }

    public int[] returnData()
    {
        return data;
    }

    public void printData()
    {
        for(int i = 0; i < size; i++)
            System.out.println((i+1) + ". " + data[i]);
    }

    public int sum()
    {
        int sum = 0;

        for(int i = 0; i < size; i++)
            sum += data[i];

        return sum;
    }

    public double mean()
    {
        return (double)sum()/size;
    }

    public double stddev()
    {
        double std = 0;

        for(int i = 0; i < size; i++)
            std += Math.pow((data[i] - (double)sum()/size),2);

        return Math.pow(std/(size-1),.5);
    }

    public int max()
    {
        int max = data[0];

        for(int i = 1; i < size; i++)
        {
            if (data[i] > max)
                max = data[i];
        }

        return max;
    }

    public int min()
    {
        int min = data[0];

        for(int i = 1; i < size; i++)
        {
            if (data[i] < min)
                min = data[i];
        }

        return min;
    }

    public int range()
    {
        return max() - min();
    }

    public int maxIndex()
    {
        int maxInd = 0;

        for(int i = 0; i < size; i++)
        {
            if (data[i] == max())
                maxInd = i;
        }

        return maxInd;
    }

    public int minIndex()
    {
        int minInd = 0;

        for(int i = 0; i < size; i++)
        {
            if (data[i] == min())
                minInd = i;
        }

        return minInd;
    }

    private int minFromIndex(int a, int[] array)
    {
        int min2 = array[a];

        for(int i = a; i < size; i++)
        {
            if (array[i] <= min2)
                min2 = array[i];
        }

        return min2;
    }

    private int minFromIndexAtIndex(int a, int[] array)
    {
        int minInd2 = a;

        for(int i = a; i < size; i++)
        {
            if (array[i] <= minFromIndex(a, array))
                minInd2 = i;
        }

        return minInd2;
    }

    private int[] sortArray()
    {
        int[] sort = new int[size];
        for(int i = 0; i < size; i++)
        {
            sort[i] = data[i];
        }
        return sort;
    }

    public int[] selectionSort()
    {
        int[] sort1 = sortArray();

        for(int i = 0; i < size; i++)
        {
            int b = minFromIndex(i, sort1);
            sort1[minFromIndexAtIndex(i, sort1)] = sort1[i];
            sort1[i] = b;
        }
        return sort1;
    }

    public int[] bubbleSort()
    {
        int[] sort2 = sortArray();

        for (int i = 0; i < size-1; i++)
        {
            for (int j = size-1; j > i; j--)
            {
                if (sort2[j] < sort2[j-1])
                {
                    int a = sort2[j-1];
                    sort2[j-1] = sort2[j];
                    sort2[j] = a;
                }
            }
        }
        return sort2;
    }

    public int[] insertionSort()
    {
        int[] sort3 = new int[size];
        sort3[0] = data[0];

        for (int i = 1; i < size; i++)
        {
            sort3[i] = data[i];
            int a = 1;
            while ((i-a >=0) && (data[i] < sort3[i-a]))
            {
                int temp = sort3[i-a];
                sort3[i-a] = sort3[i-a+1];
                sort3[i-a+1] = temp;
                a++;
            }
        }

        return sort3;
    }

    public int[] mergeSort()
    {
        return data;
    }

    public int median()
    {
        if(size%2==1)
            return selectionSort()[size/2];
        else
            return (selectionSort()[size/2+1] + selectionSort()[size/2])/2;
    }

    public int[] mode()
    {
        int[] count = new int[size];
        for(int i = 0; i < size; i++)
        {
            int repeat = 0;
            for(int j = 0; j < size; j++)
            {
                if(data[i] == data[j])
                    repeat++;
            }
            count[i] = repeat;
        }

        int maxCount = count[0];
        for(int i = 0; i < size; i++)
        {
            if (count[i] >= maxCount)
                maxCount = count[i];
        }

        int countSize = 0;
        for(int i = 1; i < size; i++)
        {
            if (count[i] == maxCount)
                countSize++;
        }

        int[] modeTemp = new int[countSize];
        int modeCount1 = 0;
        for(int i = 0; i < size; i++)
        {
            if(count[i] == maxCount)
            {
                modeTemp[modeCount1] = i;
                modeCount1++;
            }
        }

        for(int i = 0; i < modeCount1; i++)
        {
            modeTemp[i] = data[modeTemp[i]];
        }

        int[] mode = new int[countSize/maxCount];
        int modeCount2 = 0;
        for(int i = 0; i < countSize; i++)
        {
            int modeRecord = 0;
            for (int j = 0; j < mode.length; j++)
            {
                if (modeTemp[i] == mode[j])
                    modeRecord++;
            }
            
            if (modeRecord == 0)
            {
                mode[modeCount2] = modeTemp[i];
                modeCount2++;
            }
        }

        return mode;
    }
}