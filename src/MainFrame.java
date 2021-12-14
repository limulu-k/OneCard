import javax.swing.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	
	public MainFrame(){
//		창생성(창 활성화)
//        버튼 2개생성(게임 설명, 게임 시작)
//            => 게임 시작 클릭시
//                인풋다이올로그로 이름 받아오기
//                현재 창 비활성화
//                new MainGameFrame(플레이어 이름)

//		Container mainC = getContentPane();
//		mainC.setLayout(new BorderLayout());
		
		setTitle("OneCard");
		setSize(1800+16, 1000+39);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JLabel imgLabel=new JLabel();
		ImageIcon img=new ImageIcon("./img/start.png");
		imgLabel.setIcon(img);
		//imgLabel.setHorizontalAlignment(JLabel.CENTER);
		
		
		
		JButton tuto = new JButton("튜토리얼");
		JButton main = new JButton("게임 시작");
		
		
		tuto.addActionListener(event -> {
			setVisible(false);
			new TutorialFrame();
        });
		main.addActionListener(event -> {
			String name = JOptionPane.showInputDialog("이름을 입력하세요");
			setVisible(false);
			new MainGameFrame(name);
		});
		
		imgLabel.setBounds(0,0,1800,1000);
		tuto.setBounds(900,450,100,30);
		main.setBounds(900,500,100,30);
		
		getContentPane().add(tuto);
		getContentPane().add(main);
		getContentPane().add(imgLabel);
		repaint();
	}
	
}
