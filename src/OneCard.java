
public class OneCard {
	private Card[] user_deck;
	private Card[] ai_deck;
	private Card[] deck;
	private Card[] used_deck;
	private int user_deck_len;
	private int ai_deck_len;
	private int deck_len;
	private int used_deck_len;
	private int turn;
	private int need;
	
	public OneCard() {
		Card[] deck = new Card[54];
		//deck 섞고
        //used_card_deck 생성
        //user_deck 에 11장 분배
        //ai_deck 에 11장 분배
	}
	public Card[] showUserDeck() {
		return user_deck;
	}
	public Card[] showAIDeck() {
		return ai_deck;
	}
	
	public boolean isPossible(Card past_c, Card present_c) {
		// 가능하면 true, used_card_deck에 추가 + 턴을 넘길 수 있는지 판단 + 다음 플레이어가 먹을 카드 수 판단
		int n = past_c.getCardNum();
		if(past_c.getCardNum() < 11 && past_c.getCardNum() > 2) {
			
		}else if(n == 11 || n == 13){
		}else{
		
			if(n == 1) {
				
			}else if(n == 2) {
				
			}else if(n == 14) {
				
			}
		}
        // 불가능하면 false
		
		return false;
	}
	
	public int showTurn() {
        // 누구의 턴인지 리턴(플레이어 = 0, 에이아이는 1)
		return turn;
	}
	
	public void changeTurn(int n) {
		turn = n;
	}
	
	public Card[] giveCards() {
		// 줘야할 카드 수만큼 주기
		Card[] tmp = new Card[need];
		
		for(int i = 0; i < need; i++) {
			tmp[i] = deck[i];
		}
		
		deck_len -= need;
		
		for(int i = 0; i < deck_len; i++) {
			deck[i] = deck[i+need];
		}
		
		need = 0;
		return tmp;
	}
	
	public void getCards(Card[] cs, int n) {
		if(n == 1) {
			
		}else {
			
		}
	}
	
	public void changeShape(String s) {
		//카드 모양 바꾸기
	}
	public void addUsedCard(Card c) {
		
	}
	
	public Card[] showUsedDeck() {
		Card[] tmp = new Card[used_deck_len];
		for(int i = 0; i < used_deck_len; i++)
			tmp[i] = used_deck[i];
		return tmp;
	}
	
	public Card[] showDeck() {
		Card[] tmp = new Card[deck_len];
		for(int i = 0; i < deck_len; i++) {
			tmp[i] = deck[i];
		}
		return tmp;
	}
	
	public int showUserDeckLen() {
		return user_deck_len;
	}
	
	public int showAiDeckLen() {
		return ai_deck_len;
	}
	
	public int showDeckLen() {
		return deck_len;
	}
	
	public int showUsedDeckLen() {
		return used_deck_len;
	}
}





