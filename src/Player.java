
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