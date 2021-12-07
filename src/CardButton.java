import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class CardButton extends JButton implements ActionListener{
	private Card card;
	private Player player;
	private MainGameFrame frame;
	private ImageIcon main_img;
	private ImageIcon back_img;
	private ImageIcon front_img;
	
	public CardButton(Card c, Player p, MainGameFrame f) {
		card = c;
		player = p;
		frame = f;
		main_img = card.getImage();
		front_img = main_img;
		back_img = new ImageIcon("./img/back.png");
		super.setIcon(main_img);
		super.setSize(152, 216);
		addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(player != null) {
			if(player.check(card) != 1) {
				// 깜빡~ㄴ
			}
		}
	}
	public void changeBack() {
		main_img = back_img;
		super.setIcon(main_img);
	}
	public void changeFront() {
		main_img = front_img;
		super.setIcon(main_img);
	}
}
