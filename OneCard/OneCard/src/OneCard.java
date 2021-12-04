
public class OneCard {
	private Card[] user_deck;
	private Card[] ai_deck;
	
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
		//가능하면 true, used_card_deck에 추가 + 턴을 넘길 수 있는지 판단 + 다음 플레이어가 먹을 카드 수 판단
        // 불가능하면 false
	}
	public int showTurn() {
        // 누구의 턴인지 리턴(플레이어 = 0, 에이아이는 1)
	}
	public void giveCards() {
		// 줘야할 카드 수만큼 주기
	}
	public void changeShape(String s) {
		//카드 모양 바꾸기
	}
}
