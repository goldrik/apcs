/**
 * @author Aurik Sarker 
 * @version 25 October 2013
 * 
 * I, Aurik Sarker, pledge that this program is my own independent 
 * work and conforms to Oxford Academy's Academic Honesty guidelines.
 * However, I did get help from myself. 
 */

import java.util.*;

public class StringUtil
{
    public static void main(String args[])
    {
        String output = "";

        System.out.println("Menu Items: ");
        System.out.println("1. Reverse a Word");
        System.out.println("2. Test for Palindrome");
        System.out.println("3. Convert to Pig Latin");
        System.out.println("4. Convert to ShortHand");

        Scanner keyIn = new Scanner(System.in);

        int i = 1;
        while (i == 1)
        {
            System.out.print("\nEnter a phrase: ");
            String input = keyIn.nextLine();

            System.out.print("Enter a menu item: ");
            int num = keyIn.nextInt();

            switch(num)
            {
                case 1:
                output = "Reverse: " + StringUtil.reverse(input); break;
                case 2:
                if (StringUtil.isPalindrome(input)){output = "The phrase is a palindrome";} 
                else{output = "The phrase is not a palindrome";} break;
                case 3:
                output = "Pig Latin: " + StringUtil.toPigLatin(input); break;
                case 4:
                output = "ShortHand: " + StringUtil.toShortHand(input); break;
                default:
                output = "I'm sorry [your name], I'm afraid I cannot let you do that";
                
            }

            System.out.println(output);

            System.out.println("\nTry again? (y/n) ");
            String a = keyIn.nextLine();

            if (a.equals("y"))
                i = 1;
            else
                i = 0;
            
            System.out.println("");
        }
    }

    public static String reverse(String word)
    {
        String drow = "";
        for (int i = word.length()-1; i >= 0; i--)
        {
            drow += word.charAt(i);
        }
        return drow;
    }

    private static String sentenceScrubber(String sentence)
    {
        String clean = "";
        for (int i = 0; i < sentence.length(); i++)
        {
            if ((sentence.charAt(i) >= '0' && sentence.charAt(i) <= '0') || 
            (sentence.charAt(i) >= 'a' && sentence.charAt(i) <= 'z') || 
            (sentence.charAt(i) >= 'A' && sentence.charAt(i) <= 'Z'))
                clean += sentence.charAt(i);
        }
        return clean.toLowerCase();
    }

    public static boolean isPalindrome(String sentence)
    {
        String sent = sentenceScrubber(sentence);
        return sent.equals(reverse(sent));
    }

    private static int hasVowelAtIndex(String word)
    {
        String word2 = sentenceScrubber(word);

        int x = -1;
        for (int i = 0; i < word2.length(); i++)
        {
            char ch = word2.charAt(i);
            if ((ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') && x == -1)
                x = i;

            else{}
        }
        return x;
    }

    private static String wordToPigLatin(String word)
    {
        int x = hasVowelAtIndex(word);

        if (x == -1)
            return word.substring(0,1).toUpperCase() + word.substring(1) + "ay";

        if (x == 0)
            return word.substring(0,1).toUpperCase() + word.substring(1) + "yay";

        else
            return word.substring(x,x+1).toUpperCase() + word.substring(x+1) + word.substring(0,x) + "ay";
    }

    private static String shortHand(String word)
    {
        word = sentenceScrubber(word);

        if (word.equals("and"))
            return "&";

        if (word.equals("to"))
            return "2";

        if (word.equals("you"))
            return "U";

        if (word.equals("for"))
            return "4";

        else
        {
            String shorthand = "";
            for (int i = 0; i < word.length(); i++)
            {
                char ch = word.charAt(i);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){}
                else
                    shorthand += ch;
            }

            if (shorthand.equals(""))
                return "";

            else
                return shorthand.substring(0,1).toUpperCase() + shorthand.substring(1);
        }
    }

    private static String[] sentenceSeparator(String sentence)
    {
        String clean = "";
        for (int i = 0; i < sentence.length(); i++)
        {
            if ((sentence.charAt(i) >= '0' && sentence.charAt(i) <= '0') || 
            (sentence.charAt(i) >= 'a' && sentence.charAt(i) <= 'z') || 
            (sentence.charAt(i) >= 'A' && sentence.charAt(i) <= 'Z') || 
            (sentence.charAt(i) == ' '))
                clean += sentence.charAt(i);
        }
        return clean.toLowerCase().split(" ");
    }

    public static String toPigLatin(String sentence)
    {
        String[] words = sentenceSeparator(sentence);
        String piglatin = " ";

        for(int i = 0; i < words.length; i++)
        {
            piglatin += wordToPigLatin(words[i]) + " ";
        }

        return piglatin.trim();
    }

    public static String toShortHand(String sentence)
    {
        String[] words = sentenceSeparator(sentence);
        String shorthand = " ";

        for(int i = 0; i < words.length; i++)
        {
            shorthand += shortHand(words[i]) + " ";
        }

        return shorthand.trim();
    }
}
