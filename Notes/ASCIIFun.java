public class ASCIIFun
{
    public static void main(String [] args)
    {
        // char is another primitive data type
        // Initializing char requires SINGLE quotation marks, ONE character
        
        char ch1 = 'A';
        char ch2 = 'B';
        char ch3 = 'a';
        
        System.out.println("ch contains " + ch1 + " and has a value of " + (int)ch1);
        
        for(int i = 0; i >= 0; i++)
        {
            try 
            {
                Thread.sleep(250);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            
            char ch = (char)i;
            System.out.println("ch contains " + ch + " and has a value of " + (int)ch);
        }
        
        
    }
}
