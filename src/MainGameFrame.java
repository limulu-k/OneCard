import javax.swing.*;

@SuppressWarnings("serial")
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
	private JLabel needsLabel;
//	private JLabel nowShape;
	
	private String winner;

	private ImageIcon background = new ImageIcon("./img/board.png");
	private JLabel bgLabel=new JLabel();

	
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
		
		bgLabel.setIcon(background);
		bgLabel.setBounds(0,0,1800,1000);
		
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
		needsLabel = new JLabel();

		user_status.setText("<"+user.showUserName()+"> 남은 카드 : 11장");
		ai_status.setText("<ai> 남은 카드 : 11장");
		turn_status.setText("현재 턴 : user");
		needsLabel.setText("먹어야 하는 카드 수 : 1 장");

		update();
		updateCards();
		checkEnd();
	}
	
//	public void paint(Graphics g) {//그리는 함수
//		g.drawImage(background, 0, 0, null);//background를 그려줌
//	}
	
	public void userClicked(Card c) {
		if(game.CardPayed(c, user)) {
			needsLabel.setText("먹어야 하는 카드 수 : "+game.showNeed()+" 장");
			if(c.getCardNum() != 13 && c.getCardNum() != 11) {
				game.changeTurn();
			}
			if(c.getCardNum() == 7)
				game.changeNowShape(showChangeCard());
			user.eraseCard(c);
			
			update();
		}
	}
	
	public void aiClicked(Card c) {
		needsLabel.setText("먹어야 하는 카드 수 : "+game.showNeed()+" 장");
		if(c.getCardNum() != 13 && c.getCardNum() != 11)
			game.changeTurn();
		if(c.getCardNum() == 7)
			game.changeNowShape(ai.showAiChangeCard());
		ai.eraseCard(c);
		update();
	}
	
	public void aiCantClicked() {
		needsLabel.setText("먹어야 하는 카드 수 : "+game.showNeed()+" 장");
		game.getCards(game.giveCards());
		game.changeTurn();
		update();
	}
	
	public String showChangeCard() {
		String s = JOptionPane.showInputDialog("바꾸고 싶은 카드를 선택하시오(S:1, C:2, H:3, D:4)");
		System.out.println(s);
		if(s.equals("1")||s.equals("2")||s.equals("3")||s.equals("4")) {
			if(s.equals("1"))
				return "spade";
			if(s.equals("2"))
				return "clover";
			if(s.equals("3"))
				return "heart";
			return "diamond";
		}else {
			return showChangeCard();
		}
	}
	
	
	public void deckClicked() {
		//턴을 확인 해당 플레이어에게 카드 맥이기
    	//턴 넘기기
    	System.out.println("deckClicked");
    	game.getCards(game.giveCards());
    	game.changeTurn();
//        	game.updatePast();
    	update();
	}
    
	
	public boolean checkEnd() {
		//게임이 끝났는지 확인
		if(ai.showCardsLen() <= 0 || user.showCardsLen() <= 0)
			return true;
		return false;
	}
	
	public void update() {
		boolean end = false;
		while(true) {
			if(isEndByLen() || checkEnd()) {
				gameEnd();
				end = true;
				break;
			}
			//전체적인 프레임 업데이트
			
			updateCards();
			break;
		}
		if(end == true) {
			System.out.println("정상종료");
			System.out.println("winner : "+winner);
			gameIsEnd();
		}else {
			if(game.showTurn() == 0)
				ai.play();
		}
	}
	
	public void showChangingButton() {
		//바꾸는 버튼 활성화 및 다른 버튼 클릭 막기
		turnOnOff(false);
		
		int tmp = (int)(windowSize[0]/2-((int)(game.showUserDeckLen()/2)*5/6+11/12)*cardSize[0]);
		
		for(int i = 0; i < 4; i ++) {
			change_buttons[i].setBounds(tmp+i*(cardSize[0]*5/6),windowSize[1]/2-cardSize[1]/2,cardSize[0],cardSize[1]);
			getContentPane().add(change_buttons[i]);
		}
		
		update();
	}
	
	public boolean isEndByLen() {
		if(game.showAiDeckLen() >= 18 || game.showUserDeckLen() >= 18)
			return true;
		return false;
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
		System.out.println("GameEnd");
		winner = (game.showTurn()==1?"user":"ai");
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
		
		game.checkDecksLen();
		
		for(int i = 0; i < game.showAiDeckLen(); i++) {
			if(ai_deck[i] != null)
				ai_card_buttons[i] = new CardButton(ai_deck[i], ai, this);
		}
		for(int i = 0; i < game.showUserDeckLen(); i++) {
			if(user_deck[i] != null)
				user_card_buttons[i] = new CardButton(user_deck[i], user, this);
		}

		user_status.setText("<"+user.showUserName()+"> 남은 카드 : 11장");
		ai_status.setText("<ai> 남은 카드 : "+game.showAiDeckLen());
		turn_status.setText("현재 턴 : "+(game.showTurn()==1?"user":"ai"));
		
		
		//댁 분배를 보여준다
		deck_button.setBounds(900-cardSize[0]-cardSize[0]/3, windowSize[1]/2-cardSize[1]/2, cardSize[0], cardSize[1]);
		getContentPane().add(deck_button);
		past_button.setBounds(900+cardSize[0]/3, windowSize[1]/2-cardSize[1]/2, cardSize[0], cardSize[1]);
		getContentPane().add(past_button);
		
//		ai_card_buttons
		int ai_x;
		if(game.showAiDeckLen() % 2 == 0) {
			ai_x = (int)(windowSize[0]/2-((int)(game.showUserDeckLen()/2)*5/6+11/12)*cardSize[0]);
			for(int i = 0; i < game.showAiDeckLen(); i++) {
				ai_card_buttons[i].setBounds(ai_x+i*(cardSize[0]*5/6),cardSize[1]/7, cardSize[0], cardSize[1]);
				ai_card_buttons[i].changeBack();
				getContentPane().add(ai_card_buttons[i]);
			}
		}else {
			ai_x = (int)(windowSize[0]/2-((int)(game.showUserDeckLen()/2)*5/6+0.5)*cardSize[0]);
			for(int i = 0; i < game.showAiDeckLen(); i++) {
				ai_card_buttons[i].setBounds(ai_x+i*(cardSize[0]*4/5), cardSize[1]/7, cardSize[0], cardSize[1]);
				ai_card_buttons[i].changeBack();
				getContentPane().add(ai_card_buttons[i]);
			}
		}
		
//		user_card_buttons
		int user_x;
		if(game.showUserDeckLen() % 2 == 0) {
			user_x = (int)(windowSize[0]/2-((int)(game.showUserDeckLen()/2)*5/6+11/12)*cardSize[0]);
			for(int i = 0; i < game.showUserDeckLen(); i++) {
				user_card_buttons[i].setBounds(user_x+i*(cardSize[0]*5/6), 740, cardSize[0], cardSize[1]);
				getContentPane().add(user_card_buttons[i]);
			}
		}else {
			user_x = (int)(windowSize[0]/2-((int)(game.showUserDeckLen()/2)*5/6+0.5)*cardSize[0]);
			for(int i = 0; i < game.showUserDeckLen(); i++) {
				user_card_buttons[i].setBounds(user_x+i*(cardSize[0]*5/6), 740, cardSize[0], cardSize[1]);
				getContentPane().add(user_card_buttons[i]);
			}
		}
		
		
		user_status.setBounds(216, 700-30,300,30);
		user_status.setFont(user_status.getFont().deriveFont(20.0f));
		ai_status.setBounds(216, cardSize[1]/7+cardSize[1]+40,300,30);
		ai_status.setFont(user_status.getFont());
		turn_status.setBounds(216, 500,300,30);
		turn_status.setFont(user_status.getFont());
		needsLabel.setBounds(216, 600,300,30);
		needsLabel.setFont(user_status.getFont());
		
		
		
		getContentPane().add(user_status);
		getContentPane().add(turn_status);
		getContentPane().add(ai_status);
		getContentPane().add(needsLabel);
		getContentPane().add(bgLabel);
		getContentPane().add(new JLabel());
		getContentPane().repaint();
	}
	
	public void changeTurnStatus(String s) {
		turn_status.setText(s);
		turn_status.setBounds(216, 500,300,30);
	}
	
	public void turnOnOff(boolean t) {

		for(int i = 0; i < game.showAiDeckLen(); i++) {
			if(ai_card_buttons[i] != null)
				ai_card_buttons[i].setEnabled(t);
		}
		for(int i = 0; i < game.showUserDeckLen(); i++) {
			if(user_card_buttons[i] != null)
				user_card_buttons[i].setEnabled(t);
		}
		deck_button.setEnabled(t);
		past_button.setEnabled(t);
	}
	
	public void gameIsEnd() {
		setVisible(false);
		new EndFrame(winner);
	}
	
//	테스트 코드
	public static void main(String[] args) {
		new MainGameFrame("test");
	}
}
