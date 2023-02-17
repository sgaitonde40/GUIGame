import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand = new ArrayList<Card>();
    private String name;
    private int points;
    private boolean isWinner;

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
        isWinner = false;
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
    public void setWinner(boolean winner) {
        this.isWinner = winner;
        // helps ai cards become visible
        for(int i = 0; i < getHand().size(); i++) {
            getHand().get(i).setVisible(true);
        }
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void addpoints(int points) {
        this.points += points;
    }

    public void addCard(Card c, boolean visible) {
        hand.add(c);
        addpoints(c.getPoint());
        c.setVisible(visible);
    }


    public String toString() {
        return name + " has " + points + " points\n " + name + "'s hand:" + hand;
    }
    
}
