import javax.swing.JButton;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class DeckButton extends JButton implements ActionListener{
	
	private OneCard game;
	private MainGameFrame gameFrame;
	private BufferedImage img;
	public DeckButton(OneCard g, MainGameFrame gf) {	
		game = g;
		gameFrame = gf;
		
	}
	public void actionPerformed(ActionEvent e) {
		gameFrame.deckClicked();
	}
	public BufferedImage getImg() {
		return img;
	}
}
