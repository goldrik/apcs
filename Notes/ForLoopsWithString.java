public class ForLoopsWithString
{
    public static void printEachLetterOnSeparateLines(String word)
    {
        for (int i = 0; i < word.length(); i++)
        {
            System.out.println(word.charAt(i));
        }
    }
    
    public static void printBackwards(String word)
    {
        for (int i = word.length()-1; i >= 0; i--)
        {
            System.out.print(word.substring(i,i+1));
        }
    }
    
    public static String getReversedWord(String word)
    {
        String drow = "";
        
        for (int i = word.length()-1; i >= 0; i--)
        {
            drow += word.charAt(i);
        }
        
        return drow;
    }
}
