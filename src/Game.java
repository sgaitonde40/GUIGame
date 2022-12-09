import java.util.Scanner;

public class Game {
    public Player p1 = new Player();
    private Deck cardy = new Deck();

    public Game(String firstname) {
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
        cardy.setCards(ranks, suits, values);
        p1.setName(firstname);
    }

    public void printInstructions() {
        System.out.println("This is blackjack");
        System.out.println("In this game your goal is to reach 21 points without going over");
        System.out.println("At the start of the game you will be given 2 cards");
        System.out.println("Every round you can choose to pick a card or pass");
        System.out.println("If you go over 21 you instantly lose");
        System.out.println("Good Luck!");
    }

    public void playGame() {
        cardy.shuff();
        p1.addCard(cardy.deal());
        p1.addCard(cardy.deal());
        Player ai = new Player("AI");
        ai.addCard(cardy.deal());
        ai.addCard(cardy.deal());
        System.out.println(p1.getPoints());
        System.out.println("If you would like to hit press H. Else press any other key");
        Scanner s = new Scanner(System.in);
        String answer = s.nextLine();
        while (answer.equals("H")) {
            p1.addCard(cardy.deal());
            System.out.println(p1.getPoints());
            System.out.println("If you would like to hit press H. Else press any other key");
            answer = s.nextLine();
        }
        while (true) {
            if (ai.getPoints() < 16) {
                ai.addCard(cardy.deal());
            } else {
                if (ai.getPoints() > 21) {
                    System.out.println("AI Busted, You Win!");
                    return;
                } else if (p1.getPoints() > 21) {
                    System.out.println("You Busted, AI Wins!");
                    return;
                } else if (ai.getPoints() == 21) {
                    System.out.println("AI got 21, AI Wins!");
                    return;
                } else if (p1.getPoints() == 21) {
                    System.out.println("You got 21, You Win!");
                    return;
                } else if (ai.getPoints() > p1.getPoints()) {
                    System.out.println("AI scored higher, AI Wins!");
                    return;
                } else {
                    System.out.println("You scored higher, You Win!");
                    return;
                }
            }
        }
    }
}

