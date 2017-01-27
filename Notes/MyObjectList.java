/**
 * @author Aurik Sarker 
 * @version 16 December 2013
 * 
 * I, Aurik Sarker, pledge that this program is my own independent 
 * work and conforms to Oxford Academy's Academic Honesty guidelines.
 * However, I did get help from myself. 
 */

import java.util.*;
import java.io.*;

public class MyObjectList
{
    private Book[] myBooks;
    int size;

    MyObjectList()
    {
        myBooks = new Book[10];

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
        FileReader file = new FileReader("data.txt");
        Scanner fileIn = new Scanner(file);

        while(fileIn.hasNext())
        {
            String title = fileIn.nextLine();
            int pages = Integer.parseInt(fileIn.nextLine());
            int words = Integer.parseInt(fileIn.nextLine());

            add(new Book(title, pages, words));
        }

        fileIn.close();
    }

    public boolean add(Book a)
    {
        if (size >= myBooks.length)
            increaseCapacity();
        myBooks[size++] = a;

        return true;
    }

    public void addAtIndex(Book a, int ind)
    {
        if (!inBound(ind))
            add((Book) a);

        else
        {
            if (size >= myBooks.length)
                increaseCapacity();
            shiftRight(ind);
            myBooks[ind] = a;
        }
    }

    public int binarySearch(Book a)
    {
        bubbleSort();

        int left = 0;
        int right = size-1;
        while (left <= right)
        {
            int mid = (left+right)/2;
            if (a.compareTo(myBooks[mid]) == 0)
                return mid;

            if (a.compareTo(myBooks[mid]) > 0)
                left = mid+1;

            if (a.compareTo(myBooks[mid]) < 0)
                right = mid-1;
        }

        return -1;
    }

    public Book[] bubbleSort()
    {
        for (int i = size-1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (myBooks[j].compareTo(myBooks[j+1]) > 0)
                {
                    Book temp = myBooks[j];
                    myBooks[j] = myBooks[j+1];
                    myBooks[j+1] = temp;
                }
            }
        }

        return myBooks;
    }

    public void clear()
    {
        myBooks = new Book[10];
        size = 0;
    }

    public boolean contains(Book a)
    {
        boolean has = false;
        for (int i = 0; i < size; i++)
        {
            if (a.compareTo(myBooks[i]) == 0)
                has = true;
        }
        return has;
    }

    public Book get(int ind)
    {
        if (inBound(ind))
            return myBooks[ind];
        else
            return null;
    }

    private boolean inBound(int num)
    {
        return num >= 0 && num < size;
    }

    private void increaseCapacity()
    {
        Book[] temp = new Book[size];
        for (int i = 0; i < size; i++)
            temp[i] = myBooks[i];

        myBooks = new Book[size+1];
        for (int i = 0; i < size; i++)
            myBooks[i] = temp[i];
    }

    public int indexOf(Book a)
    {
        int ind = -1;
        for (int i = 0; i < size; i++)
        {
            if (a.compareTo(myBooks[i]) == 0)
                ind = i;
        }
        return ind;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void printItems()
    {
        for (Book a: myBooks)
            System.out.println(a);
    }

    public Book remove(int ind)
    {
        Book temp = myBooks[ind];
        shiftLeft(ind);
        return temp;
    }

    public boolean removeBook(Book a)
    {
        int ind = indexOf(a);
        if (ind == -1)
            return false;

        else
        {
            remove(ind);
            return true;
        }
    }

    public Book set(int ind, Book a)
    {
        if (inBound(ind))
            myBooks[ind] = a;
        return a;
    }

    private void shiftRight(int ind)
    {
        for (int i = size; i > ind; i--)
            myBooks[i] = myBooks[i-1];
        size++;
    }

    private void shiftLeft(int ind)
    {
        for (int i = ind; i < size; i++)
            myBooks[i] = myBooks[i+1];
        size--;
    }

    public int size()
    {
        return size;
    }

    public Book[] toArray()
    {
        return myBooks;
    }

    public String toString()
    {
        String books = "";
        for (Book a: myBooks)
            books += a + "; ";
        return books;
    }

    public void trimToSize()
    {
        Book[] temp = new Book[size];
        for (int i = 0; i < size; i++)
            temp[i] = myBooks[i];

        myBooks = new Book[size];
        for (int i = 0; i < size; i++)
            myBooks[i] = temp[i];
    }
}