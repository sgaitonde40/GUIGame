import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private int cardsleft;

    public Deck(String ranks[], String suits[], int points[]) {
        for (int i = 0; i <= ranks.length - 1; i++) {
            Card fresh = new Card(ranks[i], points[i], suits[i]);
            cards.add(fresh);
        }
        cardsleft = cards.size();
    }

    public Deck() {
    }

    public void setCards(String ranks[], String suits[], int points[]) {
        for (int i = 0; i < ranks.length; i++) {
            Card fresh = new Card(ranks[i], points[i], suits[i]);
            cards.add(fresh);
        }
        cardsleft = cards.size();
    }

    public boolean isEmpty() {
        if(cardsleft == 0) {
            return true;
        }
        return false;
    }

    public int getCardsleft() {
        return cardsleft;
    }


    public Card deal() {
        if(isEmpty()) {
            return null;
        }
        cardsleft--;
        return cards.get(cardsleft);
    }

    public void shuff() {
        int swapper;
        for(int i = cardsleft - 1; i >= 0; i--) {
            swapper = (int) (Math.random() * cardsleft);
            cards.add(swapper, cards.remove(i));
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
