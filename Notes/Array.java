public class Array
{
    Array()
    {
        int[] myData = new int[10];
    }

    public void printdata(int[] myData)
    {
        for(int i = 0; i < myData.length; i++)
        {
            System.out.println("%" + (i+1) + ": " + myData[i]);
        }
    }

    public void assignRandomNumbers(int[] myData)
    {
        myData = new int[100];
        Dice roller = new Dice(100);

        for(int i = 0; i < myData.length; i++)
        {
            myData[i] = roller.getNextRoll();
            System.out.println("%" + (i+1) + ": " + myData[i]);
        }

    }

    public static void main(String [] args)
    {
        int[] dataSet1 = new int[1000];
        int[] dataSet2 = {1,2,3,4,5};

        System.out.println(dataSet1.length);

        String[] classRoster = new String[40];
    }
}
