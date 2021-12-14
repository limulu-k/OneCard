
public abstract class Player {
	private Card[] cards;
	private int len;
	MainGameFrame gameFrame;
	private CardButton[] cardButtons;
	OneCard game;
	
	public Player(Card[] cs, int l, MainGameFrame gf, CardButton[] bts, OneCard g) {
		cards = cs;
		len = l;
		gameFrame = gf;
		cardButtons = bts;
		game = g;
	}
	
	public void getCard(Card c) {
		cards[len] = c;
		len += 1;
	}
	public Card giveCard(int n) {
		Card c = cards[n];
		for(int i = n+1; i < len; i++) {
			cards[i-1] = cards[i];
		}
		cards[len] = null;
		len -= 1;
		return c;
	}
	public Card[] showCards() {
		return cards;
	}
	public Card showCard(int n) {
		if(this instanceof AI)
			cards = game.showAIDeck();
		else
			cards = game.showUserDeck();
		return cards[n];
	}
	public int showCardsLen() {
		if(this instanceof AI)
			len = game.showAiDeckLen();
		else
			len = game.showUserDeckLen();
		return len;
	}
	

	public void eraseCard(Card c) {
		game.erase(c, this);
	}
}