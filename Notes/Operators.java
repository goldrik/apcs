public class Operators
{
    public static void main ( String [] minchuls )
    {
        /*
         * P = parenthesis
         * E = exponents
         * M/D = Multiply/Divide
         * A/S = Addition/Subtraction
         */
        
        // concatenate
        // truncate
        
        // declaring, create memory space to initialize variable
        int days;
        
        // initializing, uses assignment operator
        days = 5;
        
        // ints are limited to -/+ 2^31 - 1
        // long are limited to -/+ 2^63 - 1
        
        int num1 = 2;
        int num2 = 5;
        int num3 = 0;
        int num4 = 8;
        
        // decimals: float or double (more accurate)
        
        double dumb1 = 2.4;
        double dumb2 = 2.0;
        double dumb3 = 3.14E6;
        
        System.out.println(" 2 + 5 = " + (num1 + num2));
        System.out.println(" 5 / 2 = " + ((double)num2 / num1));
        
        System.out.println(" 5 / 2 = " + (num2 / dumb2));
        
        /*
         * Common Operators in JAVA
         *  * (muliplication)
         *  / (division)
         *  + (addition)
         *  - (subtraction) 
         *  
         *  = (assignemnt operator: assigning what's on the right to the left)
         *  ++, --, +=, -=, ^=, /=
         *  
         *  % (modulus (mod): outputs remainder)
         *      5 % 2 => 1
         */
        
        num4 = 10;
        num1 = num1 + num2;
        num1 += num2;
        
        //Pre vs Post Increment and Decrement
        int b;
        b = 5;
        ++b; // pre, increments and stores to b (6)
        System.out.println(b);

        int c = ++b; // First add one to b (increment), then store to b and c (7)
        int d = c++; // First store to d (7), then add one to c (increment) and store to c (8)
        int k = ++c + b++ + --d; // Store to c (9), to b (8), to d (6), to k (9+7+6)
        System.out.println(b + c + d + k);

        //Final
        final int age = 5; // The program can never change that variable
    }
}
