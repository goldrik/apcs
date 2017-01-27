public class Strings
{
    public static void main(String [] args)
    {
        // Every character in a String is assigned an index value
        String school = "Oxford";
        //   indices     012345 <= Last index is always String.length() - 1
        
        System.out.println(school.charAt(2)); // returns "f"
        System.out.println(school.charAt(0)); // returns "O"
        System.out.println(school.charAt(school.length() - 1)); // returns "d"
        
        // All methods end with ()
        
        // substring(int) or substring(int, int);
        // Grab part of the string between integers, first int inclusive, second int exclusive
        
        school.substring(school.length() - 1); // returns the last letter of the string
        
        // "oxford" => "ordoxf"
        System.out.println(school.substring(3) + school.substring(0,3));
        // If length is not known
        System.out.println(school.substring((school.length())/2) + school.substring(0,(school.length())/2));
        
        System.out.println(school.toUpperCase());
        // or
        school = school.toUpperCase();
        System.out.println(school);
        
        // Strings are immutable; the string values themselves cannot be changed, must reassign String
        
        String name1 = "Mickey";
        String name2 = "Mickey";
        
        // If you use == on String, you are comparing their address values
        if (name1 == name2)
            System.out.println("They are equal");
        
        else
            System.out.println("They are not equal");
        
        // use .equals() to compare Strings
        if (name1.equals(name2))
            System.out.println("They are the same");
        
        else
            System.out.println("They are not the same");
    }
}
