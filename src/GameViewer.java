import javax.swing.*;
import java.awt.*;

public class GameViewer extends JFrame {
    public Image[] images;
    private Game G;
    private final int WINDOW_WIDTH = 1200;
    private final int WINDOW_HEIGHT = 800;

    public GameViewer(Game G) {
        // initialize the window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Blackjack");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        this.G = G;
    }


    public void paint(Graphics g) {
        // draw the basics
        g.setColor(new Color(0, 81, 44));
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g.setColor(new Color(204, 85, 0));
        g.setFont(new Font("Serif", Font.TRUETYPE_FONT, 25));
        g.drawString("AI points: ", 100, 200);
        g.drawString("User points: ", 100, 600);
        g.drawString(String.valueOf(G.p1.getPoints()), 225, 600);
        // depending on the winner draw out their name and the word Wins!
        // if both win call it a tie
        if(G.ai.isWinner()) {
            g.setFont(new Font("Serif", Font.TRUETYPE_FONT, 50));
            g.setColor(Color.red);
            g.drawString("AI Wins!", 500, 400);
            g.setColor(new Color(204, 85, 0));
            g.setFont(new Font("Serif", Font.TRUETYPE_FONT, 25));
            g.drawString(String.valueOf(G.ai.getPoints()), 205, 200);
        }
        if(!G.ai.isWinner() && !G.p1.isWinner()){
            g.setFont(new Font("Serif", Font.TRUETYPE_FONT, 25));
            g.drawString("???", 205, 200);
        }
        if(G.p1.isWinner()) {
            g.setColor(Color.red);
            g.setFont(new Font("Serif", Font.TRUETYPE_FONT, 50));
            g.drawString("Player Wins!", 500, 440);
            g.setColor(new Color(204, 85, 0));
            g.setFont(new Font("Serif", Font.TRUETYPE_FONT, 25));
            g.drawString(String.valueOf(G.ai.getPoints()), 205, 200);
        }
        // draw the cards
        for(int i = 0; i < G.p1.getHand().size(); i++) {
            G.p1.getHand().get(i).draw(g, WINDOW_WIDTH/G.p1.getHand().size()+(i * 150) - 150, 600, this);
        }
        for(int i = 0; i < G.ai.getHand().size(); i++) {
            G.ai.getHand().get(i).draw(g, WINDOW_WIDTH/G.ai.getHand().size()+(i * 150) - 150, 100, this);
        }
    }
}
