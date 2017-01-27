/**
 * @author Aurik Sarker 
 * @version 20 January 2014
 * 
 * I, Aurik Sarker, pledge that this program is my own independent 
 * work and conforms to Oxford Academy's Academic Honesty guidelines.
 * However, I did get help from myself.
 */

import java.util.*;

public class HeartsGame
{
    int maxscore = 100;
    int maxrounds = (maxscore * 4) % 26;
    Card[] deck = new Card[52];
    ArrayList<Card> p1cards = new ArrayList<Card>(13);
    ArrayList<Card> p2cards = new ArrayList<Card>(13);
    ArrayList<Card> p3cards = new ArrayList<Card>(13);
    ArrayList<Card> p4cards = new ArrayList<Card>(13);
    ArrayList<Card> inPlay = new ArrayList<Card>(4);
    ArrayList<Card> p1points = new ArrayList<Card>();
    ArrayList<Card> p2points = new ArrayList<Card>();
    ArrayList<Card> p3points = new ArrayList<Card>();
    ArrayList<Card> p4points = new ArrayList<Card>();
    Scanner keyIn = new Scanner(System.in);
    int p1score;
    int p2score;
    int p3score;
    int p4score;
    int round = 0;
    int play = -1;
    int player = 0;
    int turn = 0;
    int who = 0;

    HeartsGame()
    {
        createDeck();
    }

    HeartsGame(int howMany, String pointsORrounds)
    {
        if (pointsORrounds.equalsIgnoreCase("Points"))
            maxscore = howMany;
        if (pointsORrounds.equalsIgnoreCase("Rounds"))
            maxrounds = howMany;

        createDeck();
    }

    public void newGame()
    {
        p1score = 0;
        p2score = 0;
        p3score = 0;
        p4score = 0;

        while (p1score < maxscore && p2score < maxscore && p3score < maxscore && 
        p4score <  maxscore && round < maxrounds)
        {
            newRound();
            System.out.println("\nYou are currently place " + determinePlace());
            System.out.println("Player ONE: " + p1score);
            System.out.println("Player two: " + p2score);
            System.out.println("Player three: " + p3score);
            System.out.println("Player four: " + p4score);
            System.out.println("\n");
        }

        if (determinePlace() == 1)
        {
            System.out.println("           .------..------..------.     .------..------..------.");
            System.out.println("           |Y.--. ||O.--. ||U.--. |.-.  |W.--. ||O.--. ||N.--. |");
            System.out.println("           | (\\/) || :/\\: || (\\/) (( )) | :/\\: || :/\\: || :(): |");
            System.out.println("           | :\\/: || :\\/: || :\\/: |'-.-.| :\\/: || :\\/: || ()() |");
            System.out.println("           | '--'Y|| '--'O|| '--'U| (( )) '--'W|| '--'O|| '--'N|");
            System.out.println("           `------'`------'`------'  '-'`------'`------'`------'");
        }

        else
        {
            System.out.println("                    __  __               __           __ ");
            System.out.println("                    \\ \\/ /___  __  __   / /___  _____/ /_");
            System.out.println("                     \\  / __ \\/ / / /  / / __ \\/ ___/ __/");
            System.out.println("                     / / /_/ / /_/ /  / / /_/ (__  ) /__ ");
            System.out.println("                    /_/\\____/\\__,_/  /_/\\____/____/\\__(_)");
        }
    }

    private void newRound()
    {
        play = -1;
        round++;
        System.out.println("Press enter to continue..."); String nothing = keyIn.nextLine();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Round " + round + 
            " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

        shuffle();
        ArrayList<Card> temp = sort(p1cards);
        for(int i  = 0; i < 13; i ++)
            p1cards.set(i, temp.get(i)); 

        displayCards();

        if (round%4 != 0)
            shiftCards();
        if (round%4 == 0)
        {
            System.out.println("\n\nPass zero cards in any direction");
        }

        ArrayList<Card> temp1 = sort(p1cards);
        for(int i  = 0; i < 13; i ++)
            p1cards.set(i, temp1.get(i)); 
        ArrayList<Card> temp2 = sort(p2cards);
        for(int i  = 0; i < 13; i ++)
            p2cards.set(i, temp2.get(i)); 
        ArrayList<Card> temp3 = sort(p3cards);
        for(int i  = 0; i < 13; i ++)
            p3cards.set(i, temp3.get(i)); 
        ArrayList<Card> temp4 = sort(p4cards);
        for(int i  = 0; i < 13; i ++)
            p4cards.set(i, temp4.get(i)); 

        for (int i = 0; i < 13; i++)
        {
            play = i;
            newPlay(play);
        }

        p1score += checkPoints(p1points);
        p2score += checkPoints(p2points);
        p3score += checkPoints(p3points);
        p4score += checkPoints(p4points);
        shootTheMoon();

        p1points.clear();
        p2points.clear();
        p3points.clear();
        p4points.clear();
    }

    private void newPlay(int p)
    {         
        if (p == 0)
        {
            System.out.println("\nThe two of spades starts first");

            player = player(findCard(deck[0]));
            runPlay();
        }

        else 
        {
            runPlay();
        }
    }

    private void runPlay()
    {
        displayCards();
        Card nextCard;

        turn = 0;

        for (int i = 0; i < 4; i++)
        {
            turn++;
            if (player%4 == 1)
            {
                whoWasFirst();
                System.out.print("Cards in play: ");
                for (int j = 0; j < inPlay.size(); j++)
                    System.out.print(inPlay.get(j) + " ");

                nextCard = yourPlay();
                inPlay.add(nextCard);
                p1cards.remove(indexOf(nextCard, p1cards));
                player++;
            }

            else
            {
                nextCard = playCard(whoseTurn(player));
                inPlay.add(nextCard);
                whoseTurn(player).remove(indexOf(nextCard, whoseTurn(player)));
                player++;
            }
        }

        System.out.print("\nCards played: ");
        for (int j = 0; j < inPlay.size(); j++)
            System.out.print(inPlay.get(j) + " ");

        assignPoints();
        System.out.println("\nCards go to Player " + who + "\n"); 
        player = player(whoseTurn(who));
        inPlay.clear();
    }

    private void createDeck()
    {
        for (int i = 0; i < 13; i++)
        {
            deck[i] = new Card("C", i+2);
            deck[i+13] = new Card("D", i+2);
            deck[i+26] = new Card("S", i+2);
            deck[i+39] = new Card("H", i+2);
        }
    }

    private void displayCards()
    {
        System.out.println("-- Your cards --");
        for (int i = 0; i < p1cards.size(); i++)
            System.out.print(p1cards.get(i) + " ");
    }

    private void shuffle()
    {
        ArrayList<Integer> nums = new ArrayList<Integer>(52);
        for (int i = 0; i < 52; i++)
            nums.add(i);

        Random rand = new Random();
        int temp;
        while (nums.size() >= 3)
        {
            temp = rand.nextInt(nums.size());
            p1cards.add(deck[nums.get(temp)]);
            nums.remove(temp);

            temp = rand.nextInt(nums.size());
            p2cards.add(deck[nums.get(temp)]);
            nums.remove(temp);

            temp = rand.nextInt(nums.size());
            p3cards.add(deck[nums.get(temp)]);
            nums.remove(temp);

            temp = rand.nextInt(nums.size());
            p4cards.add(deck[nums.get(temp)]);
            nums.remove(temp);
        }
    }

    private ArrayList<Card> sort(ArrayList<Card> a)
    {        
        ArrayList<Card> sort = new ArrayList<Card>();
        for(int i = 0; i < 13; i++)
        {
            sort.add(a.get(i));
        }

        for (int i = 0; i < 12; i++)
        {
            for (int j = 12; j > i; j--)
            {
                if (Card.compare(sort.get(j), sort.get(j-1)) < 0)
                {
                    Card b = sort.get(j-1);
                    sort.set(j-1,sort.get(j));
                    sort.set(j,b);
                }
            }
        }
        return sort;
    }

    private void shiftCards()
    {
        Card card1;
        Card card2;
        Card card3;
        String temp;

        int r = round%4;
        if (r == 1)
            System.out.println("\n\nPass three cards to left");
        if (r == 2)
            System.out.println("\n\nPass three cards to right");
        if (r == 3)
            System.out.println("\n\nPass three cards to across");

        System.out.println("Card 1: ");
        temp = keyIn.nextLine();
        card1 = Card.toCard(temp);
        while (!checkCard(card1))
        {
            System.out.println("\nThis card is not in your deck");
            card1 = Card.toCard(keyIn.nextLine());
        }

        System.out.println("Card 2: ");
        temp = keyIn.nextLine();
        card2 = Card.toCard(temp);
        while (!checkCard(card2))
        {
            System.out.println("\nThis card is not in your deck");
            card2 = Card.toCard(keyIn.nextLine());
        }

        System.out.println("Card 3: ");
        temp = keyIn.nextLine();
        card3 = Card.toCard(temp);
        while (!checkCard(card3))
        {
            System.out.println("\nThis card is not in your deck");
            card3 = Card.toCard(keyIn.nextLine());
        }

        if (r==1)
            switchCards(p1cards, p2cards, card1, card2, card3);
        if (r==2)
            switchCards(p1cards, p4cards, card1, card2, card3);
        if (r==3)
            switchCards(p1cards, p3cards, card1, card2, card3);
    }

    private void switchCards(ArrayList<Card> giver, ArrayList<Card> taker, Card a, Card b, Card c)
    {
        taker.add(giver.get(indexOf(a, p1cards))); 
        taker.add(giver.get(indexOf(b, p1cards))); 
        taker.add(giver.get(indexOf(c, p1cards)));
        giver.remove(indexOf(c, p1cards)); 
        giver.remove(indexOf(b, p1cards)); 
        giver.remove(indexOf(a, p1cards));

        giver.add(taker.get(0)); 
        giver.add(taker.get(1)); 
        giver.add(taker.get(2));
        taker.remove(2); 
        taker.remove(1); 
        taker.remove(0);
    }

    private boolean checkCard(Card a)
    {
        boolean is = false;

        is = checkForCard(a, p1cards);

        if (play == -1)
            return is;

        else if (play == 0)
        {
            if (turn == 1)
            {
                if (Card.compare(deck[0], a) != 0)
                    is = false;
            }
            else 
            {
                if (!(a.suit().equals("C")))
                {
                    if (Card.compare(deck[36], a) == 0)
                        is = false;
                    if (a.suit().equals("H"))
                        is = false;
                    if (followsSuit(inPlay.get(0)))
                        is = false;
                }
            }
            return is;
        }
        else
        {
            if (turn == 1)
                return is;
            else
            {
                if (!(a.suit().equals(inPlay.get(0).suit())))
                {
                    if (followsSuit(inPlay.get(0)))
                        is = false;
                }
            }
            return is;
        }
    }

    private boolean checkForCard(Card a, ArrayList<Card> b)
    {
        boolean check = false;
        if (b.size() == 0)
            return check;
        for (int i = 0; i < b.size(); i++)
        {
            if (Card.compare(a, b.get(i)) == 0)
                check = true;
        }

        return check;
    }

    private ArrayList<Card> findCard(Card a)
    {
        int find = 0;
        for (int i = 0; i < 13; i++)
        {
            if (Card.compare(a, p1cards.get(i)) == 0)
                return p1cards;
            else if (Card.compare(a, p2cards.get(i)) == 0)
                return p2cards;
            else if (Card.compare(a, p3cards.get(i)) == 0)
                return p3cards;
            else if (Card.compare(a, p4cards.get(i)) == 0)
                return p4cards;
        }
        return p1cards;
    }

    private int player(ArrayList<Card> a)
    {
        if (equals(a,p1cards))
            return 1;
        if (equals(a,p2cards))
            return 2;
        if (equals(a,p3cards))
            return 3;
        if (equals(a,p4cards))
            return 4;
        return 0;
    }

    private ArrayList<Card> whoseTurn(int i)
    {
        switch(i%4)
        {
            case 1:
            return p1cards;
            case 2: 
            return p2cards;
            case 3:
            return p3cards;
            case 0:
            return p4cards;
        }
        return p1cards;
    }

    private void whoWasFirst()
    {
        switch(turn)
        {
            case 1:
            System.out.println("\n\nYou will play the first card"); break;
            case 2:
            System.out.println("\n\nPlayer 4 played the first card"); break;
            case 3:
            System.out.println("\n\nPlayer 3 played the first card"); break;
            case 4:
            System.out.println("\n\nPlayer 2 played the first card"); break;
        }
    }

    private Card playCard(ArrayList<Card> a)
    {
        if (turn == 1)
        {
            return a.get(0);
        }

        else
        {
            for (int i = a.size()-1; i >= 0; i--)
            {
                if (a.get(i).suit().equals(inPlay.get(0).suit()))
                {
                    if (a.get(i).num() < inPlay.get(0).num())
                        return a.get(i);
                }
            }
            for (int i = a.size()-1; i >= 0; i--)
            {
                if (a.get(i).suit().equals(inPlay.get(0).suit()))
                    return a.get(i);
            }
            return a.get(a.size()-1);
        }
    }

    private Card yourPlay()
    {
        String temp = keyIn.nextLine();
        Card card1 = Card.toCard(temp);
        while (!checkCard(card1))
        {
            System.out.println("\nThis card is not in your deck or is the wrong suit");
            card1 = Card.toCard(keyIn.nextLine());
        }
        return card1;
    }

    private void assignPoints()
    {
        Card point = highestCard(inPlay.get(0), inPlay);
        int ind = indexOf(point, inPlay) + 1;

        switch(player%4 - 1 + ind)
        {
            default:
            break;
            case 0: 
            assignCards(p4points); who = 4; break;
            case 1: 
            assignCards(p1points); who = 1; break;
            case 2:
            assignCards(p2points); who = 2; break;
            case 3:
            assignCards(p3points); who = 3; break;
            case 4:
            assignCards(p4points); who = 4; break;
            case 5:
            assignCards(p1points); who = 1; break;
            case 6:
            assignCards(p2points); who = 2; break;
            case 7:
            assignCards(p3points); who = 3; break;
            case 8:
            assignCards(p4points); who = 4; break;
        }
    }

    private void assignCards(ArrayList<Card> a)
    {
        for (int i = 0; i < 4; i++)
            a.add(inPlay.get(i));
    }

    private int checkPoints(ArrayList<Card> a)
    {
        int pts = 0;
        if (checkForCard(deck[36], a))
            pts += 13;
        for (int i = 0; i < a.size(); i++)
        {
            if (a.get(i).suit().equals("H"))
                pts++;
        }
        return pts;
    }

    private void shootTheMoon()
    {
        if (checkPoints(p1points) != 26 && checkPoints(p2points) != 26 && 
        checkPoints(p3points) != 26 && checkPoints(p4points) != 26){}

        if (checkPoints(p1points) == 26)
        {
            p1score -= 26; p2score += 26; p3score += 26; p4score += 26;
            System.out.println("You shot the moon!");
        }
        if (checkPoints(p2points) == 26)
        {
            p2score -= 26; p1score += 26; p3score += 26; p4score += 26;
            System.out.println("Player 2 has shot the moon");
        }
        if (checkPoints(p3points) == 26)
        {
            p3score -= 26; p1score += 26; p2score += 26; p4score += 26;
            System.out.println("Player 3 has shot the moon");
        }
        if (checkPoints(p4points) == 26)
        {
            p4score -= 26; p1score += 26; p2score += 26; p3score += 26;
            System.out.println("Player 4 has shot the moon");
        }
    }

    private int determinePlace()
    {
        int place = 4;
        if (p1score <= p2score)
            place--;
        if (p1score <= p3score)
            place--;
        if (p1score <= p4score)
            place--;
        return place;
    }

    private int indexOf(Card a, ArrayList<Card> b)
    {
        for (int i = 0; i < 13; i++)
        {
            if (Card.compare(a, b.get(i)) == 0)
                return i;
        }
        return -1;
    }

    private boolean equals(ArrayList<Card> a, ArrayList<Card> b)
    {
        if (a.size() != b.size())
            return false;
        else
        {
            for (int i = 0; i < a.size(); i++)
            {
                if (Card.compare(a.get(i), b.get(i)) != 0)
                    return false;
            }
            return true;
        }
    }

    private boolean followsSuit(Card a)
    {
        for (int i = p1cards.size()-1; i >= 0; i--)
        {
            if (p1cards.get(i).suit().equals(a.suit()))
                return true;
        }
        return false;
    }

    private Card highestCard(Card a, ArrayList<Card> b)
    {
        Card high = a;
        for (int i = 0; i < b.size(); i++)
        {
            if (b.get(i).suit().equals(a.suit()))
            {
                if (b.get(i).num() > high.num())
                    high = b.get(i);
            }
        }
        return high;
    }

    public static void rules()
    {
        System.out.println("RULES\n");
        System.out.println("In this JAVA version of Hearts:");
        System.out.println("\t'C' = Clubs");
        System.out.println("\t'D' = Diamonds");
        System.out.println("\t'S' = Spades");
        System.out.println("\t'H' = Hearts");
        System.out.println("\t'11' = Jack");
        System.out.println("\t'12' = Queen");
        System.out.println("\t'13' = King");
        System.out.println("\t'14' = Ace");
        System.out.println("\nExample: S13 is the King of Spades");

        System.out.println
        ("\n\nGoal:\nThe player with the lowest score at the end of the game wins.\n");
        System.out.println
        ("Setup:\nEach player gets 13 cards.\n");
        System.out.println
        ("Passing:\nAfter looking at his deck, each player chooses three cards");
        System.out.println
        ("\tand passes them face down to another player.");
        System.out.println
        ("The passing rotation changes every round.\n");
        System.out.println
        ("Gameplay:\nPlayer with the 2 of clubs plays that card to start the first play.");
        System.out.println
        ("Each player must follow suit if possible.");
        System.out.println
        ("If player has no cards of the suit, he may play a card of any other suit.");
        System.out.println
        ("\t**A heart or Queen of Spades cannot be played on the first play.");
        System.out.println
        ("The highest card of the leading suit wins a play.");
        System.out.println
        ("The winner of the play keeps all cards won and starts the next play.\n");
        System.out.println
        ("Scoring:\nAt the round's end, count 1 point for each heart taken");
        System.out.println
        ("\tand 13 points for the Queen of Spades.");
        System.out.println
        ("Shooting the Moon: If a player wins all 13 hearts and the Queen of Spades,");
        System.out.println
        ("\t26 points are added to every other player's score.");
        System.out.println
        ("\nRounds played until a player reaches a predetermined number, usually 100.");
    }
}