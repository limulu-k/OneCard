
public abstract class Player {
	public void getCard(Card c) {
		this.cards[len] = c;
		this.len += 1;
	}
	public Card giveCard(int n ) {
		Card c = this.cards[n];
		//n��° �ε����� ī�� ����
		//l -= 1;
		return c;
	}
	public void giveCard(int n) {
		Card c = this.cards[n]
		//n��° �ε����� ī�� ����
		//l -= 1;
		return c;
	}
	public void showCards() {
		//return cards;
	}
	public void showCard(int n) {
		//return cards[n];
	}
	public void showCardsLen() {
		//return l;
	}
	public void check(Card c) {
		//�� �� �ִ��� Ȯ�� �Ǹ� �ְ� 1�� ���� �ȵǸ� 0�� ����
        //game.isPossible()
        //gameFrame.update()
	}
}
