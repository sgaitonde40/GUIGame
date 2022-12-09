import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand = new ArrayList<Card>();
    private String name;
    private int points;

    public Player(String name) {
        this.name = name;
        points = 0;
    }

    public Player()
    {
        points = 0;
    }

    public Player(ArrayList<Card> hand, String name) {
        this.hand = hand;
        this.name = name;
        points = 0;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addpoints(int points) {
        this.points += points;
    }

    public void addCard(Card c) {
        hand.add(c);
        addpoints(c.getPoint());
    }


    public String toString() {
        return name + " has " + points + " points\n " + name + "'s hand:" + hand;
    }
    
}
