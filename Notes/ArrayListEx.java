import java.util.*;

public class ArrayListEx
{
    private ArrayList<Integer> data;
    
    ArrayListEx()
    {
        data = new ArrayList<Integer> ();
    }
    
    public void addSomeValues()
    {
        data.add(88); // 88 is an int, not an Integer, but works because autoboxing
        
        Integer objectInt = new Integer(99);
        data.add(objectInt);
        
        for (int i = 1; i <= 10; i++)
        {
            data.add(i+153);
        }
        
        data.add(234);
        data.add(34);
        data.add(3);
        data.add(2104);
    }
    
    public void printData()
    {
        for (int i = 0; i < data.size(); i++)
        {
            System.out.println(i + ". " + data.get(i));
        }
    }
    
    public void messWithData()
    {
        int i = data.indexOf(34);
        
        if (i != -1)
          data.remove(i);
        
        data.remove(3);
        data.remove(new Integer (3));
        data.remove(data.indexOf(157));
        
        data.set(0, data.get(0) * -1);
    }
}