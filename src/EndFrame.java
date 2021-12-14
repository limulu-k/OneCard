import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class EndFrame extends JFrame{
//	private ImageIcon background = new ImageIcon("./img/board.png");
//	private JLabel bgLabel=new JLabel();
//	
//	private String winner;
//	private JLabel winnerLabel;
	
	public EndFrame(String w) {
		setTitle("OneCard");
		setSize(1800+16, 1000+39);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		
		JLabel backImg = new JLabel();
		String src = "./img/winner-"+w+".png";
		backImg.setIcon(new ImageIcon(src));
		
		backImg.setBounds(0, 0, 1800, 1000);
		
		getContentPane().add(backImg);
		getContentPane().repaint();
		
//		bgLabel.setIcon(background);
//		bgLabel.setBounds(0,0,1800,1000);
//		
//		winner = w;
//		String text = "winner : "+winner;
//		winnerLabel = new JLabel(text);
//		winnerLabel.setBounds(600,350,2000,200);
//		winnerLabel.setFont(winnerLabel.getFont().deriveFont(40.0f));
//		getContentPane().add(winnerLabel);
//		getContentPane().add(bgLabel);
//		getContentPane().repaint();
	}
	
//	테스트 코드
	public static void main(String[] args) {
		new EndFrame("ai");
	}
}
