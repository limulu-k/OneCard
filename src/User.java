
public class User extends Player{
	private String name;
	private int len;
	
	public User(String n, Card[] cs, int l , MainGameFrame f, CardButton[] bts, OneCard g) {
		super(cs, l, f, bts, g);
		name = n;
		len = l;
	}
	public String showUserName() {
		return name;
	}
}
