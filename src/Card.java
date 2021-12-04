
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;


public class Card extends JFrame{
	
	private static String shape;
	private static int number;
	private ImageIcon img;
	
	public Card(int n, String s) {
		shape=s;
		number=n;
		loadImage();    	
    	JButton b = new JButton(img);
    	b.setBounds(100,100,0,0);
    	add(b);
    	setSize(400,400);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);
	}
	
//	public void paint(java.awt.Graphics g) {
//		//이클립스의 src 폴더에 이미지를 넣으면 자동으로 bin폴더에 이미지 파일이 복사됨. 그러므로 getResource 로 가져올 수 있음
//
//		img = Toolkit.getDefaultToolkit().getImage(ImageTest.class.getResource("").getPath()+"testpic.jpg");
//
////img = Toolkit.getDefaultToolkit().getImage("C:/sou/002_javabasic02/java_basic_02/bin/pack00_TemporaryPackage/testpic.jpg"); 
//
//		g.drawImage(img, 50, 80, 200, 200, this);
//	}
	public void loadImage(){
		//[shpae]-[number]
		String src = "..\\" + shape + "-" + number;
		img = new ImageIcon(src);
		//이미지와 숫자에 맞는 이미지 저장
		
	}
		
		
	public int getCardNum() {
		return number;
     //카드 숫자
	}
    public String getCardShape() {
    	return shape;
    	//카드 모양
    }
    public ImageIcon getImage() {
    	return img;
    	//이미지 리턴   
    }
    
    public static void main(String[] args) throws IOException{
    	Card c = new Card(2,"spade");


	}
}