import javax.swing.*;

public class MainGameFrame extends JFrame{
	private Card[] user_deck;
	private Card[] ai_deck;
	private Card[] deck;
	private Card past;
	
	private CardButton past_button;
	private CardButton[] user_card_buttons;
	private CardButton[] ai_card_buttons;
	private DeckButton deck_button;
	private ChangingButton[] change_buttons;
	private AI ai;
	private User user;
	private int[] windowSize = {1800,1000};
	private int[] cardSize = {152,216};
	
	private OneCard game;
	
	private JLabel user_status;
	private JLabel ai_status;
	private JLabel turn_status;
	
	
	@SuppressWarnings("deprecation")
	public MainGameFrame(String name) {
		//창 생성(창 활성화)
        //OneCard 실행
		//ai카드덱, user카드덱, 바닥에 있는 카드덱, 버려진 카드 덱 리스트 추가
        //턴관련 int 형 변수 turn = 0:ai, 1:user
        //start실행
		
		setTitle("OneCard");
		setSize(1800+16, 1000+39);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		
		game = new OneCard(this);
		
		ai_deck = game.showAIDeck();
		user_deck = game.showUserDeck();
		deck = game.showDeck();
		past = game.showPast();
		past_button = new CardButton(past, null, this);
		
		ai = new AI(ai_deck, game.showAiDeckLen(), this, ai_card_buttons, game);
		user = new User(name, user_deck, game.showUserDeckLen(), this, user_card_buttons, game);
		
		ai_card_buttons = new CardButton[50];
		user_card_buttons = new CardButton[50];
		
		for(int i = 0; i < game.showAiDeckLen(); i++) 
			ai_card_buttons[i] = new CardButton(ai_deck[i], ai, this);
		for(int i = 0; i < game.showUserDeckLen(); i++)
			user_card_buttons[i] = new CardButton(user_deck[i], user, this);
		
		deck_button = new DeckButton(game, this);
		
		change_buttons = new ChangingButton[4];
		change_buttons[0] = new ChangingButton(game, this, "Spade");
		change_buttons[1] = new ChangingButton(game, this, "Clover");
		change_buttons[2] = new ChangingButton(game, this, "Heart");
		change_buttons[3] = new ChangingButton(game, this, "Diamond");
		
		user_status = new JLabel();
		ai_status = new JLabel();
		turn_status = new JLabel();

		user_status.setText("<user> 남은 카드 : 11장");
		ai_status.setText("<ai> 남은 카드 : 11장");
		turn_status.setText("현재 턴 : user");
		
		start();
		checkEnd();
		repaint();
	}
	
	public void start() {
		//댁 분배를 보여준다
		deck_button.setBounds(900-cardSize[0]-cardSize[0]/3, windowSize[1]/2-cardSize[1]/2, cardSize[0], cardSize[1]);
		add(deck_button);
		past_button.setBounds(900+cardSize[0]/3, windowSize[1]/2-cardSize[1]/2, cardSize[0], cardSize[1]);
		add(past_button);
		
//		ai_card_buttons
		int ai_x;
		if(game.showAiDeckLen() % 2 == 0) {
			ai_x = (int)(windowSize[0]/2-((int)(game.showUserDeckLen()/2)*5/6+11/12)*cardSize[0]);
			for(int i = 0; i < game.showUserDeckLen(); i++) {
				ai_card_buttons[i].setBounds(ai_x+i*(cardSize[0]*5/6),cardSize[1]/7, cardSize[0], cardSize[1]);
				ai_card_buttons[i].changeBack();
				add(ai_card_buttons[i]);
			}
		}else {
			ai_x = (int)(windowSize[0]/2-((int)(game.showUserDeckLen()/2)*5/6+0.5)*cardSize[0]);
			for(int i = 0; i < game.showAiDeckLen(); i++) {
				ai_card_buttons[i].setBounds(ai_x+i*(cardSize[0]*4/5), cardSize[1]/7, cardSize[0], cardSize[1]);
				ai_card_buttons[i].changeBack();
				add(ai_card_buttons[i]);
			}
		}
		
//		user_card_buttons
		int user_x;
		if(game.showUserDeckLen() % 2 == 0) {
			user_x = (int)(windowSize[0]/2-((int)(game.showUserDeckLen()/2)*5/6+11/12)*cardSize[0]);
			for(int i = 0; i < game.showUserDeckLen(); i++) {
				user_card_buttons[i].setBounds(user_x+i*(cardSize[0]*5/6), 740, cardSize[0], cardSize[1]);
				add(user_card_buttons[i]);
			}
		}else {
			user_x = (int)(windowSize[0]/2-((int)(game.showUserDeckLen()/2)*5/6+0.5)*cardSize[0]);
			for(int i = 0; i < game.showUserDeckLen(); i++) {
				user_card_buttons[i].setBounds(user_x+i*(cardSize[0]*5/6), 740, cardSize[0], cardSize[1]);
				add(user_card_buttons[i]);
			}
		}
		
		
		user_status.setBounds(216, 700-30,300,30);
		user_status.setFont(user_status.getFont().deriveFont(20.0f));
		ai_status.setBounds(216, cardSize[1]/7+cardSize[1]+40,300,30);
		ai_status.setFont(user_status.getFont());
		turn_status.setBounds(216, 500,300,30);
		turn_status.setFont(user_status.getFont());
		
		add(user_status);
		add(ai_status);
		add(turn_status);
	}
	
	
    public void deckClicked() {
		//턴을 확인 해당 플레이어에게 카드 맥이기
    	//턴 넘기기
    	game.getCards(game.giveCards());
    	game.changeTurn();
    	update();
	}
    
	public boolean checkEnd() {
		//게임이 끝났는지 확인
		if(ai.showCardsLen() == 0 || user.showCardsLen() == 0)
			return true;
		return false;
	}
	
	public void update() {
		//전체적인 프레임 업데이트
		updateCards();
		//게임이 끝났는지 확인
		if(checkEnd()) {
			gameEnd();
		}
        //다음턴이 AI턴인지 확인
		if(game.showTurn() == 0) {
			ai.play();
		}
        //AI턴이면 ai.play()
		//턴변수 재지정
        //끝났는지 확인 => isEnd()
            //gameEnd()
        //else{
            //누구 턴인지 출력
		if(checkEnd()) {
			gameEnd();
		}
		updateCards();
		repaint();
	}
	
	public void showChangingButton() {
		//바꾸는 버튼 활성화 및 다른 버튼 클릭 막기
		turnOnOff(false);
		
		int tmp = (int)(windowSize[0]/2-((int)(game.showUserDeckLen()/2)*5/6+11/12)*cardSize[0]);
		
		for(int i = 0; i < 4; i ++) {
			change_buttons[i].setBounds(tmp+i*(cardSize[0]*5/6),windowSize[1]/2-cardSize[1]/2,cardSize[0],cardSize[1]);
			add(change_buttons[i]);
		}
	}
	
	public void eraseChangingButton() {
		//바꾸는 버튼 비활성화
		for(int i = 0; i < 4; i++) {
			getContentPane().remove(change_buttons[i]);
		}
		turnOnOff(true);
		
	}
	
	public void gameEnd() {
		//이긴사람확인, 버튼 클릭 막고, 이긴사람 출력(게임종료 인터페이스)
		turnOnOff(false);
		JLabel winner = new JLabel("winner : "+(game.showTurn()==0?"user":"ai"));
		winner.setBounds(600,400,200,200);
		winner.setFont(winner.getFont().deriveFont(40.0f));
		getContentPane().add(winner);
	}
	
	public void sevenCalled() {
		//changingButton 활성화
		showChangingButton();
	}
	
	public void updateCards() {
//		컴포넌트 초기화\
		getContentPane().removeAll();
		
		ai_deck = game.showAIDeck();
		user_deck = game.showUserDeck();
		deck = game.showDeck();
		past = game.showPast();
		past_button = new CardButton(past, null, this);
		
		for(int i = 0; i < game.showAiDeckLen(); i++) 
			ai_card_buttons[i] = new CardButton(ai_deck[i], ai, this);
		for(int i = 0; i < game.showUserDeckLen(); i++)
			user_card_buttons[i] = new CardButton(user_deck[i], user, this);
		
		user_status.setText("<user> 남은 카드 : "+game.showUserDeckLen());
		ai_status.setText("<ai> 남은 카드 : "+game.showAiDeckLen());
		turn_status.setText("현재 턴 : "+(game.showTurn()==1?"user":"ai"));
		
		
		//댁 분배를 보여준다
		deck_button.setBounds(900-cardSize[0]-cardSize[0]/3, windowSize[1]/2-cardSize[1]/2, cardSize[0], cardSize[1]);
		add(deck_button);
		past_button.setBounds(900+cardSize[0]/3, windowSize[1]/2-cardSize[1]/2, cardSize[0], cardSize[1]);
		add(past_button);
		
//		ai_card_buttons
		int ai_x;
		if(game.showAiDeckLen() % 2 == 0) {
			ai_x = (int)(windowSize[0]/2-((int)(game.showUserDeckLen()/2)*5/6+11/12)*cardSize[0]);
			for(int i = 0; i < game.showUserDeckLen(); i++) {
				ai_card_buttons[i].setBounds(ai_x+i*(cardSize[0]*5/6),cardSize[1]/7, cardSize[0], cardSize[1]);
				ai_card_buttons[i].changeBack();
				add(ai_card_buttons[i]);
			}
		}else {
			ai_x = (int)(windowSize[0]/2-((int)(game.showUserDeckLen()/2)*5/6+0.5)*cardSize[0]);
			for(int i = 0; i < game.showAiDeckLen(); i++) {
				ai_card_buttons[i].setBounds(ai_x+i*(cardSize[0]*4/5), cardSize[1]/7, cardSize[0], cardSize[1]);
				ai_card_buttons[i].changeBack();
				add(ai_card_buttons[i]);
			}
		}
		
//		user_card_buttons
		int user_x;
		if(game.showUserDeckLen() % 2 == 0) {
			user_x = (int)(windowSize[0]/2-((int)(game.showUserDeckLen()/2)*5/6+11/12)*cardSize[0]);
			for(int i = 0; i < game.showUserDeckLen(); i++) {
				user_card_buttons[i].setBounds(user_x+i*(cardSize[0]*5/6), 740, cardSize[0], cardSize[1]);
				add(user_card_buttons[i]);
			}
		}else {
			user_x = (int)(windowSize[0]/2-((int)(game.showUserDeckLen()/2)*5/6+0.5)*cardSize[0]);
			for(int i = 0; i < game.showUserDeckLen(); i++) {
				user_card_buttons[i].setBounds(user_x+i*(cardSize[0]*5/6), 740, cardSize[0], cardSize[1]);
				add(user_card_buttons[i]);
			}
		}
		
		
		user_status.setBounds(216, 700-30,300,30);
		user_status.setFont(user_status.getFont().deriveFont(20.0f));
		ai_status.setBounds(216, cardSize[1]/7+cardSize[1]+40,300,30);
		ai_status.setFont(user_status.getFont());
		turn_status.setBounds(216, 500,300,30);
		turn_status.setFont(user_status.getFont());
		
		add(user_status);
		add(turn_status);
		add(ai_status);
		add(new JLabel());
	}
	
	public void changeTurnStatus(String s) {
		turn_status.setText(s);
		turn_status.setBounds(216, 500,300,30);
		update();
	}
	
	public void turnOnOff(boolean t) {

		for(int i = 0; i < game.showAiDeckLen(); i++) {
			ai_card_buttons[i].setEnabled(t);
		}
		for(int i = 0; i < game.showUserDeckLen(); i++) {
			user_card_buttons[i].setEnabled(t);
		}
		deck_button.setEnabled(t);
		past_button.setEnabled(t);
	}
	
	public static void main(String[] args) {
		new MainGameFrame("test");
	}
}
