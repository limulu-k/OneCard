import javax.swing.*;


public class Card{
	
	private String shape;
	private int number;
	private ImageIcon img;
	
	public Card(int n, String s) {
		shape=s;
		number=n;
		loadImage();
	}
	
	public void loadImage(){
		img = new ImageIcon("./img/" + shape + "-" + number+".png");
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
}