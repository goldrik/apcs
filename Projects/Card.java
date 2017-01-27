public class Card
{
    private String suit;
    private int num;

    public Card(String a, int b)
    {
        suit = a;
        num = b;
    }

    public String suit()
    {
        return suit;
    }

    public int num()
    {
        return num;
    }

    public String toString()
    {
        return suit+num;
    }

    public static Card toCard(String a)
    {
        if (a.length() == 2)
            return new Card(a.substring(0,1), Integer.parseInt(a.substring(1)));
        else if (a.length() == 3)
            return new Card(a.substring(0,1), Integer.parseInt(a.substring(1)));
        else
            return new Card("Z", 0);
    }

    public static int cardNum(Card a)
    {
        int num = 0;

        if (a.suit().equalsIgnoreCase("C"))
            num+=0;
        if (a.suit().equalsIgnoreCase("D"))
            num+=13;
        if (a.suit().equalsIgnoreCase("S"))
            num+=26;
        if (a.suit().equalsIgnoreCase("H"))
            num+=39;

        num+=a.num();
        return num;
    }

    public static int compare(Card a, Card b)
    {
        return (cardNum(a) - cardNum(b));
    }
}
