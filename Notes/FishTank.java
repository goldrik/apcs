public class FishTank
{
   private int gallons;
   private double length;
   private double width;
   private double height;
   private String hairColor;
   
   // Need constructor(s)
   
   FishTank()
   {}
   
   FishTank (int g, double l, double w, double h)
   {
   }
   
   // Create get and set methods for all private data
   
   // Creae one other USEFUL method
   
   public String toString()
   // String representation of your object, usually just print out contents of private data
   {
       return "Gallons: " + gallons + "Width: " + width + "Length: " + length + "Height: " + height;
   }
}
