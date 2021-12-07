import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class DeckButton extends JButton implements ActionListener{
	
	private OneCard game;
	private MainGameFrame gameFrame;
	private ImageIcon img;
	
	public DeckButton(OneCard g, MainGameFrame gf) {	
		game = g;
		gameFrame = gf;
		loadImage();
		addActionListener(this);
		super.setIcon(img);
		super.setSize(152, 216);
	}
	public void actionPerformed(ActionEvent e) {
		gameFrame.deckClicked();
	}
	public void loadImage(){
		img = new ImageIcon("./img/back.png");
	}
}
