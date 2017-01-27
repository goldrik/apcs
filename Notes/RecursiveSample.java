public class RecursiveSample
{
    public static void printXTimes(int x, String msg)
    {
        if (x <= 0)
            return;
        else
            printXTimes(x-1, msg + msg.substring(msg.length()- 1));
        System.out.println(msg);
    }

    public static double goldenRatio(int x)
    {
        if (x == 1)
            return 1;
        else
            return 1 + 1/goldenRatio(x-1);
    }

    public static int sumOfDigits(int x)
    {
        if (x < 10)
            return x;
        else
            return x%10 + sumOfDigits(x/10);
    }

    public static int productOfDigits(int x)
    {
        if (x < 10)
            return x;
        else
        {
            if (x%10 == 0)
                return productOfDigits(x/10);
            return x%10 * productOfDigits(x/10);
        }
    }

    public static long factorial(int x)
    {
        if (x <= 0)
            return 1;
        else
            return x * factorial(x - 1);
    }
}