import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Scanner;

public class Game {
    public Player p1 = new Player();
    public Player ai = new Player();
    private Deck cardy = new Deck();
    private GameViewer window;
    private boolean isWinner;
    public String answer;

    public Game (String firstname) {
        String ranks[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K", "A", "2", "3", "4", "5", "6", "7",
                "8", "9", "J", "Q", "K", "A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K", "A", "2", "3", "4",
                "5", "6", "7", "8", "9", "J", "Q", "K"};

        String suits[] = {"Hearts", "Hearts", "Hearts", "Hearts", "Hearts", "Hearts", "Hearts", "Hearts", "Hearts", "Hearts",
                "Hearts", "Hearts", "Clubs", "Clubs", "Clubs", "Clubs", "Clubs", "Clubs", "Clubs", "Clubs", "Clubs", "Clubs",
                "Clubs", "Clubs", "Spades", "Spades", "Spades", "Spades", "Spades", "Spades", "Spades", "Spades", "Spades",
                "Spades", "Spades", "Spades", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds",
                "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds"};
        int values[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 1, 2, 3, 4, 5, 6, 7,
                8, 9, 10, 10, 10};

        this.isWinner = false;
        cardy.setCards(ranks, suits, values);
        p1.setName(firstname);
        this.window = new GameViewer(this);
    }

    public void printInstructions() {
        System.out.println("This is blackjack");
        System.out.println("In this game your goal is to reach 21 points without going over");
        System.out.println("At the start of the game you will be given 2 cards");
        System.out.println("Every round you can choose to pick a card or pass");
        System.out.println("If you go over 21 you instantly lose");
        System.out.println("Good Luck!");
        System.out.println();
    }

    public void playGame() {
        cardy.shuff();
        p1.addCard(cardy.deal(), true);
        p1.addCard(cardy.deal(), true);
        ai.addCard(cardy.deal(), false);
        ai.addCard(cardy.deal(), false);
        window.repaint();
        System.out.println(p1.getPoints());
        System.out.println("If you would like to hit press H. Else press any other key");
        Scanner s = new Scanner(System.in);
        answer = s.nextLine();
        window.repaint();
        while ((answer.equals("H") || answer.equals("h")) && p1.getPoints() <= 21) {
            p1.addCard(cardy.deal(), true);
            System.out.println(p1.getPoints());
            System.out.println("If you would like to hit press H. Else press any other key");
            answer = s.nextLine();
            window.repaint();
        }
        while (!isWinner) {
            window.repaint();
            while (ai.getPoints() < 16) {
                ai.addCard(cardy.deal(), false);
            }
            getWinner();
        }
        // once the game is over reveal all the cards
        for(int i = 0; i < ai.getHand().size(); i++) {
            ai.getHand().get(i).setVisible(true);
        }
    }
    public Player getWinner() {
        if (ai.getPoints() > 21) {
            System.out.println("AI Busted, You Win!");
            isWinner = true;
            p1.setWinner(isWinner);
            return p1;
        } else if (p1.getPoints() == 21) {
            if (ai.getPoints() != 21) {
                System.out.println("You got 21, You Win!");
                isWinner = true;
                p1.setWinner(isWinner);
                return p1;
            }
            else {
                isWinner = true;
                p1.setWinner(isWinner);
                ai.setWinner(isWinner);
                System.out.println("Its a tie!");
            }
        } else if (p1.getPoints() > 21) {
            System.out.println("You Busted, AI Wins!");
            isWinner = true;
            ai.setWinner(isWinner);
            return ai;
        } else if (ai.getPoints() == 21) {
            System.out.println("AI got 21, AI Wins!");
            isWinner = true;
            ai.setWinner(isWinner);
            return ai;
        } else if (ai.getPoints() > p1.getPoints() && (!answer.equals("h") || !answer.equals("H"))) {
            System.out.println("AI scored higher, AI Wins!");
            isWinner = true;
            ai.setWinner(isWinner);
            return ai;
        }
        else if(ai.getPoints() == p1.getPoints()&& (!answer.equals("h") || !answer.equals("H"))) {
            isWinner = true;
            p1.setWinner(isWinner);
            ai.setWinner(isWinner);
            System.out.println("Its a tie!");
        }
        else if(!answer.equals("h") || !answer.equals("H")) {
            System.out.println("You scored higher, You Win!");
            isWinner = true;
            p1.setWinner(isWinner);
            return p1;
        }
        return null;
    }
}

