import java.awt.*;

public class Card {
    private String rank;
    private int point;
    private String suit;
    private Image card;
    private boolean isVisible;
    public Card(String rank, int point, String suit) {
        this.rank = rank;
        this.point = point;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public int getPoint() {
        return point;
    }

    public String getSuit() {
        return suit;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void draw(Graphics g, GameViewer G) {

    }

    public String toString() {
        return rank + " of " + suit;
    }
}
