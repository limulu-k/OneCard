import java.util.*;

public class OneCard {
	private MainGameFrame gameFrame;
	private Card[] user_deck;
	private Card[] ai_deck;
	private Card[] deck;
	private Card past;
	
	private String now_shape;
	
	private int user_deck_len;
	private int ai_deck_len;
	private int deck_len;
	private int turn;
	private int need=1;
	private boolean sevenCalled = false;
	
	public OneCard(MainGameFrame mgf) {
		gameFrame = mgf;
		deck = new Card[54];
		past = null;
		String sh = null;
		for(int i = 1; i <= 52; i++) {
			int n = i%13;
			if(n == 0) n = 13;
			if((int)((i-1)/13) == 0) sh = "spade";
			else if((int)((i-1)/13) == 1) sh = "clover";
			else if((int)((i-1)/13) == 2) sh = "heart";
			else if((int)((i-1)/13) == 3) sh = "diamond";
			deck[i-1] = new Card(n, sh);
		}
		deck[52] = new Card(14, "color");
		deck[53] = new Card(14, "black");
		List<Card> list = Arrays.asList(deck);
		Collections.shuffle(list);
		list.toArray(deck);
		deck_len = 54;

		user_deck = new Card[54];
		ai_deck = new Card[54];
		
		user_deck_len = 11;
		ai_deck_len = 11;
		
		for(int i = 0; i < 11; i++) {
			user_deck[i] = deck[i];
		}
		for(int i = 11; i < 54; i++) {
			deck[i-11] = deck[i];
			deck[i] = null;
		}
		for(int i = 0; i < 11; i++) {
			ai_deck[i] = deck[i];
		}
		for(int i = 11; i < 43; i++) {
			deck[i-11] = deck[i];
			deck[i] = null;
		}
		deck_len -= 22;
		past = deck[deck_len-1];
		deck_len -= 1;
		
		turn = 1;
	}
	
	public Card[] showUserDeck() {
		return user_deck;
	}
	
	public Card[] showAIDeck() {
		return ai_deck;
	}
	
	public Card showPast() {
		return past;
	}
	
	public boolean isPossible(Card present_c, Player p) {
		// 가능하면 true, used_card_deck에 추가 + 턴을 넘길 수 있는지 판단 + 다음 플레이어가 먹을 카드 수 판단
		int past_n = past.getCardNum();
		int now_n = present_c.getCardNum();
		String past_s = past.getCardShape();
		String now_s = present_c.getCardShape();
		System.out.println("turn : "+turn+"\nispossible\npast : "+past_s+":"+past_n+"\nnow : "+now_s+":"+now_n);
		if((p instanceof User && turn == 1) || (p instanceof AI && turn == 0)) {
			System.out.println("finding...");
			if(sevenCalled) {
				if(past_n == now_n || now_s.equals(now_shape) || now_n == 14) {
					need += howManyNeed(now_n, now_s);
					sevenCalled = false;
					past = present_c;
					if(now_n == 7) {
						gameFrame.sevenCalled();
						sevenCalled = true;
					}
					return true;
				}else {
					return false;
				}
			}else {
				if(past_n <= 13 && past_n > 2) {
					if(past_n == now_n || past_s.equals(now_s) || now_n == 14) {
						if(now_n != 11 && now_n != 13)
							changeTurn();
						System.out.println("ispossible-normal "+now_s + ":"+now_n);
						need += howManyNeed(now_n, now_s);
						past = present_c;
						if(now_n == 7 && turn == 0) {
							gameFrame.sevenCalled();
							sevenCalled = true;
						}
						return true;
					}else {
						return false;
					}
				}else{
					if(past_n == 1) {
						if(now_n == 1 || now_n == 14) {
							need += howManyNeed(now_n, now_s);
							past = present_c;
							changeTurn();
							return true;
						}else {
							return false;
						}
					}else if(past_n == 2) {
						if(now_n == 2 || now_n == 1 || now_n == 14) {
							need += howManyNeed(now_n, now_s);
							past = present_c;
							changeTurn();
							return true;
						}else {
							return false;
						}
					}else if(past_n == 14) {
						if(now_n == 14) {
							need += howManyNeed(now_n, now_s);
							changeTurn();
							return true;
						}else {
							return false;
						}
					}else {
						return false;
					}
				}
			}
		}else {
			return false;
		}
		
	}
	
	@SuppressWarnings("unused")
	private int howManyNeed(int n, String s) {
		if(n == 1) {
			if(s.equals("spade")) {
				return 5;
			}else {
				return 3;
			}
		}else if(n == 14) {
			if(s.equals("color")) {
				return 10;
			}else {
				return 7;
			}
		}else if(n == 2) {
			return 2;
		}else {
			System.out.println("ERROR howManyNeed : "+n+", "+s);
			return 0;
		}
	}
	
	public int showTurn() {
        // 누구의 턴인지 리턴(플레이어 = 1, 에이아이는 0)
		return turn;
	}
	
	public void changeTurn() {
		if (turn == 0) {
			turn = 1;
			gameFrame.changeTurnStatus("현재 턴 : user");
		}else {
			turn = 0;
			gameFrame.changeTurnStatus("현재 턴 : ai");
		}
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
		
		need = 1;
		return tmp;
	}
	
	public void getCards(Card[] cs) {
		if(turn == 1) {
			for(int i = user_deck_len; i < user_deck_len+cs.length; i++) {
				user_deck[i] = cs[i-user_deck_len];
			}
			user_deck_len += cs.length;
			System.out.println("user_deck_len: "+user_deck_len);
		}else {
			for(int i = ai_deck_len; i < ai_deck_len+cs.length; i++) {
				ai_deck[i] = cs[i-ai_deck_len];
			}
			ai_deck_len += cs.length;
			System.out.println("ai_deck_len"+ai_deck_len);
		}
	}
	
	public void sevenCall(String s) {
		//카드 모양 바꾸기
		now_shape = s;
		sevenCalled = true;
	}
	
	public Card[] showDeck() {
		if(deck_len > 0) {
			Card[] tmp = new Card[deck_len];
			for(int i = 0; i < deck_len; i++) {
				tmp[i] = deck[i];
			}
			return tmp;
		}else {
			return null;
		}
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
	
	public void erase(Card c, Player p) {
		if(p instanceof User) {
			for(int i = 0; i < user_deck_len; i ++) {
				if(user_deck[i] == c) {
					user_deck[i] = null;
					for(int j = i; j < user_deck_len-1; j++) {
						user_deck[j] = user_deck[j+1];
					}
					user_deck[user_deck_len-1] = null;
					user_deck_len -= 1;
					break;
				}
			}
		}else {for(int i = 0; i < ai_deck_len; i ++) {
				if(ai_deck[i] == c) {
					ai_deck[i] = null;
					for(int j = i; j < ai_deck_len; j++) {
						ai_deck[j] = ai_deck[j+1];
					}
					ai_deck[ai_deck_len-1] = null;
					ai_deck_len -= 1;
					break;
				}
			}
		}
	}
	public int showNeed() {
		return need;
	}
//	public static void main(String[] args) {
//		OneCard game = new OneCard();
//		Card[] c = game.showAIDeck();
//		System.out.println(game.ai_deck_len);
//		for(int i = 0; i < game.ai_deck_len; i++)
//			System.out.println(c[i].getCardShape()+" : "+c[i].getCardNum());
//	}
}





