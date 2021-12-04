
public class User extends Player{
	private String name;
	private Card[] cards;
	private int len;
	
	public User(String n, Card[] cs, int l , MainGameFrame f, CardButton[] bts, OneCard g) {
		name = n;
		cards = cs;
		len = l;
	}
	public String getUserName() {
		return name;
	}
}
