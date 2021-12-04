import javax.swing.JButton;
import java.awt.event.*;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class CardButton extends JButton implements ActionListener{
	private Card card;
	private Player player;
	private MainGameFrame frame;
	private BufferedImage img;
	
	public CardButton(Card c, Player p, MainGameFrame f) {
		card = c;
		player = p;
		frame = f;
	}
	public void actionPerformed(ActionEvent e) {
		if(player.check(card) != 1) {
			// ������ ����
			card.loadImage();
			try {Thread.sleep(3000);} //3�� ��� 
			catch (InterruptedException i) {i.printStackTrace();}
			// �������
			card.loadImage();
		}
	}
	public BufferedImage getImg() {
		return img;
	}
}
