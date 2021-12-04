import java.util.*;


public class AI extends Player {
	
	public AI(Card[] cs, int l, MainGameFrame f, CardButton[] bts, OneCard g) {
		super(cs, l, f, bts, g);
	}
	public void play() {
		//���� ��Ȳ�� ���� ī�� ����
		int len = showCardsLen();
		int[] possible = new int[len];
		int n= 0;
		for(int i = 0 ; i < len ; i++) {
			if(check(showCard(i))==1) {
				possible[n] = i;
				n += 1;
			}
		}
		if(n==0) {
			Random random = new Random();
			int rand = possible[random.nextInt(n)];
			giveCard(rand);
		}
		else {
			Card[] cs = game.giveCards();
			int cslen = cs.length;
			for(int i = 0 ; i < cslen ; i++) {
				getCard(cs[i]);
			}
			
		}
		
	}
}
