
public class OneCard {
	private Card[] user_deck;
	private Card[] ai_deck;
	
	public OneCard() {
		Card[] deck = new Card[54];
		//deck ����
        //used_card_deck ����
        //user_deck �� 11�� �й�
        //ai_deck �� 11�� �й�
	}
	public Card[] showUserDeck() {
		return user_deck;
	}
	public Card[] showAIDeck() {
		return ai_deck;
	}
	public boolean isPossible(Card past_c, Card present_c) {
		//�����ϸ� true, used_card_deck�� �߰� + ���� �ѱ� �� �ִ��� �Ǵ� + ���� �÷��̾ ���� ī�� �� �Ǵ�
        // �Ұ����ϸ� false
	}
	public int showTurn() {
        // ������ ������ ����(�÷��̾� = 0, ���̾��̴� 1)
	}
	public void giveCards() {
		// ����� ī�� ����ŭ �ֱ�
	}
	public void changeShape(String s) {
		//ī�� ��� �ٲٱ�
	}
}
