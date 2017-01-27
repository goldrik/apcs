/**
 * @author Aurik Sarker 
 * @date 27 September 2013
 * 
 * I, Aurik Sarker, pledge that this program is my own independent 
 * work and conforms to Oxford Academy's Academic Honesty guidelines.
 * However, I did get help from myself. 
 */

import java.util.Scanner;

public class Book implements Comparable
{
    private String title;
    private int pages;
    private int words;

    Book()
    {
        title = "Default Title";
        pages = 0;
        words = 0;
    }

    Book (String t, int p, int w)
    {
        title = t;
        pages = p;
        words = w;
    }

    public void setTitle(String t)
    {
        title = t;
    }

    public void setPages(int p)
    {
        if (p>0)
            pages = p;
        else
        {
            System.err.print("Number of pages cannot be negative");
            pages = 0;
        }
    }

    public void setWords(int w)
    {
        if (w>0)
            words = w;
        else
        {
            System.err.print("Number of words cannot be negative");
            words = 0;
        }
    }

    public String getTitle()
    {
        return title;
    }

    public int getPages()
    {
        return pages;
    }

    public int getWords()
    {
        return words;
    }

    public String toString()
    // String representation of your object, usually just print out contents of private data
    {
        return "Title: " + title + ", Pages: " + pages + ", Words: " + words;
    }

    public void readBook()
    {
        Scanner keyIn = new Scanner (System.in);

        if (title.equals("Default Title"))
        {   System.out.println("Title: ");
            title = keyIn.nextLine();}
        else{}

        while (pages <= 0)
        {
            System.out.println("Pages: ");
            pages = keyIn.nextInt();
            if (pages <=0)
                System.out.println("Pages canot be negative");
            else{}
        }

        while (words <= 0)
        {
            System.out.println("Words: ");
            words = keyIn.nextInt();
            if (words <=0)
                System.out.println("Words canot be negative");
            else{}
        }
        System.out.println(" ");

        System.out.println("Instructions\n\tTo turn the page forward,                 press 1.\n\tTo turn back a page,                      press 2.\n\tTo turn to a specific page in the book,   press 3.\n\tFor a word count of the page you are on,  press 4.");

        int myPage = 0;
        int wordCount = words/pages;

        while (true)
        {
            System.out.println("");
            
            if (myPage == 0)
            {
                System.out.println("  " + title);
                System.out.println("                 _______________ ");
                System.out.println("                |_______________|");
                System.out.println("                |_______________|");
                System.out.println("                |_______________|");
                System.out.println("                |_______________|");
                System.out.println("                |_______________|");
                System.out.println("                |_______________|");
                System.out.println("                |_______________|");
                System.out.println("");
            }

            else if (myPage >= pages)
            {
                System.out.println(title);
                System.out.println(" _______________ ");
                System.out.println("|_______________|");
                System.out.println("|_______________|");
                System.out.println("|____EL FIN_____|");
                System.out.println("|_______________|");
                System.out.println("|_______________|");
                System.out.println("|_______________|");
                System.out.println("|_______________|");
                System.out.println("");
            }

            else
            {
                System.out.println(title);
                System.out.println(" _______________________________ ");
                System.out.println("| "+myPage+" ____________|____________ "+(myPage+1)+" |");
                System.out.println("|_______________|_______________|");
                System.out.println("|_______________|_______________|");
                System.out.println("|_______________|_______________|");
                System.out.println("|_______________|_______________|");
                System.out.println("|_______________|_______________|");
                System.out.println("|_______________|_______________|");
                System.out.println("");
            }

            int num = 0;

            while (!(num>0))
            {
                System.out.print("Operation: ");
                num = keyIn.nextInt();
            }

            switch(num)
            {
                case 1:
                myPage += 2; break;
                case 2:
                myPage -= 2; break;
                case 3:
                System.out.print("Turn to page: "); myPage = keyIn.nextInt(); break;
                case 4:
                System.out.println("This page's word count: " + wordCount); break;
                default:
                System.out.println("I'm sorry [your name], I'm afraid I cannot let you do that");
                System.exit(-1);
            }
        }
    }
    
    public int compareTo(Object object)
    {
        Book otherBook = (Book)object;
        
        return title.compareTo(otherBook.getTitle());
    }
}