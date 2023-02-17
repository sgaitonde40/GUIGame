import javax.swing.*;
import java.awt.*;

public class Card {
    private String rank;
    private int point;
    private String suit;
    private Image card, back;
    private boolean isVisible;
    public Card(String rank, int point, String suit) {
        this.rank = rank;
        this.point = point;
        this.suit = suit;
        int counter = 0;
        int count = 0;
        this.back = new ImageIcon("Resources/back.png").getImage();
        // calculate the correct card image
        if(rank.equals("A")) {
            count = 1;
        }
        else if(rank.equals("J")) {
            count = 11;
        }
        else if(rank.equals("Q")) {
            count = 12;
        }
        else if(rank.equals("K")) {
            count = 13;
        }
        else {
            count = point;
        }
        if(suit.equals("Spades")) {
            counter = 1;
        }
        else if(suit.equals("Hearts")) {
            counter = 2;
        }
        else if(suit.equals("Diamonds")) {
            counter = 3;
        }
        else if(suit.equals("Clubs")) {
            counter = 4;
        }
        int helper = count * 4 + counter - 4;
        this.card = new ImageIcon("Resources/" + helper + ".png").getImage();
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

    public void draw(Graphics g, int x, int y, GameViewer P) {
        // if the card is apart of the ai and the game isnt over draw the back, else draw the card
        if(!isVisible) {
            g.drawImage(back, x, y, 150, 150, P);
        }
        else {
            g.drawImage(card, x, y, 150, 150, P);
        }
    }

    public String toString() {
        return rank + " of " + suit;
    }
}
