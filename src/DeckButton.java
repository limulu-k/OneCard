import javax.swing.JButton;
import java.awt.event.*;

public class DeckButton extends JButton implements ActionListener{
	
	private OneCard game;
	private MainGameFrame gameFrame;
	public DeckButton(OneCard g, MainGameFrame gf) {
		game = g;
		gameFrame = gf;
	}
	public void actionPerformed(ActionEvent e) {
		gameFrame.deckClicked();
	}
}
