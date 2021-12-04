
public abstract class Player {
	private Card[] cards;
	private int len;
	private MainGameFrame gameFrame;
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
		return cards[n];
	}
	public int showCardsLen() {
		return len;
	}
	public int check(Card c) {
		//낼 수 있는지 확인 되면 주고 1을 리턴 안되면 0을 리턴
        if(game.isPossible(c))
        	return 1;
        else
        	return 0;
	}
}
