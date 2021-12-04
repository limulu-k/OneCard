
public class AI extends Player {
	private Card[] cards;
	private int len;
	private MainGameFrame gameFrame;
	private CardButton[] cardButtons;
	private OneCard game;
	public AI(Card[] cs, int l, MainGameFrame f, CardButton[] bts, OneCard g) {
		this.cards = cs;
		len = l;
		gameFrame = f;
		cardButtons = bts;
		game = g;
	}
	public void play() {
		//���� ��Ȳ�� ���� ī�� ����
	}
}
