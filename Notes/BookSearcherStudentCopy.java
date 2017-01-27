import java.io.*;
import java.util.*;


public class BookSearcherStudentCopy
{
 private ArrayList<String> theBook;
 private String[] words; // all the words in the book
 
 BookSearcherStudentCopy()
 {
     theBook = new ArrayList<String>();
 }
 
 public void readInBookByLine() throws IOException 
 {
    FileReader fin = new FileReader("Rendezvous with Rama.txt");
    StringTokenizer strTok;  // newly added
    String line = new String();  // changed name from input to line
    String wrd;  // newly added
    Scanner src = new Scanner(fin);
    while (src.hasNextLine()) 
    {
        line = src.nextLine();
        strTok = new StringTokenizer(line);
        //System.out.println(input); // echo book to console
        while(strTok.hasMoreTokens())
        {
            wrd = strTok.nextToken();
            theBook.add(wrd);
        }
        theBook.add("\n");
    } 
    System.out.println("book size: " + theBook.size());
 }
 
 public void printBook()
 {
     for (int i = 0; i < theBook.size(); i++)
         System.out.print(theBook.get(i) + " ");
 }
}