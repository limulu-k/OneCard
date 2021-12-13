import java.util.*;

public class AI extends Player {
	
	public AI(Card[] cs, int l, MainGameFrame f, CardButton[] bts, OneCard g) {
		super(cs, l, f, bts, g);
	}
	
	public void play() {
		System.out.println("play called");
		
		int[] checksum = new int[showCardsLen()];
		
		for(int i = 0; i < showCardsLen(); i++)
			checksum[i] = 0;
		
		Random random = new Random();
		int n,cnt;
		
		System.out.println("<<Ai Start>>");
		while(true) {
			n = random.nextInt(showCardsLen());
			if(checksum[n] == 0) {
				if(game.CardPayed(showCard(n), this)) {
					gameFrame.aiClicked(showCard(n));
					break;
				}
				checksum[n] = 1;
			}
			cnt = 0;
			for(int i = 0; i < showCardsLen(); i++) {
				if(checksum[i] == 1)
					cnt += 1;
			}
			if(cnt == showCardsLen()) {
				gameFrame.aiCantClicked();
				break;
			}
		}
	}
	
	public String showAiChangeCard() {
		System.out.println("Ai showChargeCardRandom Called");
		
		int[] cnt = new int[4];
		for(int i = 0; i < 4; i++)
			cnt[i] = 0;
		
		for(int i = 0; i < showCardsLen(); i++) {
			if(showCard(i).getCardShape().equals("spade"))
				cnt[0] += 1;
			else if(showCard(i).getCardShape().equals("clover"))
				cnt[1] += 1;
			else if(showCard(i).getCardShape().equals("heart"))
				cnt[2] += 1;
			else
				cnt[3] += 1;
		}
		
		int a,b,c;
		a = cnt[0] > cnt[1] ? 0 : 1;
		b = cnt[2] > cnt[3] ? 2 : 3;
		c = cnt[a] > cnt[b] ? a: b;
		if(c == 0)
			return "spade";
		else if(c == 1)
			return "clover";
		else if(c == 2)
			return "heart";
		else
			return "diamond";
	}
}
