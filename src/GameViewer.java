import javax.swing.*;
import java.awt.*;

public class GameViewer extends JFrame {
    private Image[] images;
    private Game G;
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;

    public GameViewer(Game G){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Blackjack");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        this.G = G;
    }

    public void paint(Graphics g) {
        g.setColor(new Color(0, 81, 44));
        g.fillRect(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        g.setColor(new Color(204, 85, 0));
        g.setFont(new Font("Serif", Font.TRUETYPE_FONT, 25));
        g.drawString("AI points: ", 100, 200);
        g.drawString("User points: ", 100, 600);
    }
}
