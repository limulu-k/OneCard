import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class CardButton extends JButton implements ActionListener{
	private Card card;
	private Player player;
	private MainGameFrame frame;
	private ImageIcon img;
	
	public CardButton(Card c, Player p, MainGameFrame f) {
		card = c;
		player = p;
		frame = f;
		img = card.getImage();
		super.setIcon(img);
		super.setSize(152, 216);
		addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(player.check(card) != 1) {
			// 깜빡~ㄴ
		}
	}
}
