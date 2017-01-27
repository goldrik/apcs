/**
 * @author Aurik Sarker 
 * @version 25 October 2013
 * 
 * I, Aurik Sarker, pledge that this program is my own independent 
 * work and conforms to Oxford Academy's Academic Honesty guidelines.
 * However, I did get help from myself. 
 */

public class BaseConverter
{
    private static String decimalToBaseN(long dec, long base)
    {
        String baseN = "";
        
        while(dec>0)
        {
            long a = dec%base;
            if (a >= 10)
                baseN = (char)(a + 55) + baseN;
            else
                baseN = a + baseN;

            dec/=base;
        }
        return baseN;
    }

    private static long baseNToDecimal(String baseN, long base)
    {
        long dec = 0;
        int x = 0;
        
        for(int i = 0; i < baseN.length(); i++)
        {
            if (baseN.charAt(i)>=48 && baseN.charAt(i)<=57)
                dec += ((long)(baseN.charAt(i))-48)*(Math.pow(base,x));
            else
                dec += ((long)(baseN.charAt(i))-55)*(Math.pow(base,x));
            x++;
        }
        return dec;
    }

    public static String baseNtoBaseN (String num, int base1, int base2)
    {
        if (base1 > 0 && base2 > 0 && base1 < 37 && base2 < 37)
        {
            long dec = baseNToDecimal(num, base1);
            return decimalToBaseN(dec, base2);
        }

        else
            return "ERROR: Base out of range";
    }
}
