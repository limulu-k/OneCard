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
		System.out.println("while start");
		while(true) {
			n = random.nextInt(showCardsLen());
			if (checksum[n] == 0) {
				System.out.println("check called");
				if(check(showCard(n)) == 1) {
					System.out.println("check right");
					eraseCard(showCard(n));
					gameFrame.update();
					break;
				}
				checksum[n] = 1;
			}
			cnt = 0;
			for(int i = 0; i < showCardsLen(); i++) {
				if(checksum[i] == 1)
					cnt += 1;
			}
			if(cnt == showCardsLen())
				break;
		}
		
	}
}
