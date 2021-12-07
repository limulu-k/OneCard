import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.*;

public class ChangingButton extends JButton implements ActionListener{
	private OneCard game;
	private MainGameFrame gameFrame;
	private String shape;
	
	public ChangingButton(OneCard g, MainGameFrame gf, String s) {
		game = g;
		gameFrame = gf;
		shape = s;
		super.setIcon(new ImageIcon("./img/" + shape + "-" + 1 +".png"));
		super.setSize(152, 216);
		addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		game.sevenCall(shape);
		gameFrame.eraseChangingButton();
	}
}
