import javax.swing.*;

public class MainGameFrame extends JFrame{
	private Card[] user_deck;
	private Card[] ai_deck;
	private Card[] deck;
	private CardButton[] user_card_buttons;
	private CardButton[] ai_card_buttons;
	private DeckButton deck_button;
	private ChangingButton[] change_buttons;
	private AI ai;
	private User user;
	private int turn;
	
	public MainGameFrame(String name) {
		//창 생성(창 활성화)
        //OneCard 실행
		//ai카드덱, user카드덱, 바닥에 있는 카드덱, 버려진 카드 덱 리스트 추가
        //턴관련 int 형 변수 turn = 0:ai, 1:user
        //start실행
		
		setTitle("OneCard");
		setSize(1800, 1000);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		OneCard game = new OneCard();
		ai_deck = game.showAIDeck();
		user_deck = game.showUserDeck();
		deck = game.showDeck();
		
		ai = new AI(ai_deck, game.showAiDeckLen(), this, ai_card_buttons, game);
		user = new User(name, user_deck, game.showUserDeckLen(), this, user_card_buttons, game);
		
		turn = 0;
		
		for(int i = 0; i < game.showAiDeckLen(); i++) 
			ai_card_buttons[i] = new CardButton(ai_deck[i], ai,this);
		for(int i = 0; i < game.showUserDeckLen(); i++)
			user_card_buttons[i] = new CardButton(user_deck[i], user, this);
		
		deck_button = new DeckButton(game, this);
		
		change_buttons = new ChangingButton[4];
		change_buttons[0] = new ChangingButton(game, this, "Spade");
		change_buttons[1] = new ChangingButton(game, this, "Clover");
		change_buttons[2] = new ChangingButton(game, this, "Heart");
		change_buttons[3] = new ChangingButton(game, this, "Diamond");
		
		start();
	}
	public void start() {
		//댁 분배를 보여준다
	}
	public void showTurn() {
		//누구의 턴인지 보여준다<- 시간을 활용하여 버튼의 움직임 생성
	}
    public void deckClicked() {
		//턴을 확인 해당 플레이어에게 카드 맥이기
    	//턴 넘기기
	}
	public void checkEnd() {
		//게임이 끝났는지 확인
	}
	public void update() {
		//전체적인 프레임 업데이트
		//게임이 끝났는지 확인
        //다음턴이 AI턴인지 확인
        //AI턴이면 ai.play()
		//턴변수 재지정
        //끝났는지 확인 => isEnd()
            //gameEnd()
        //else{
            //누구 턴인지 출력
		
		
		
	}
	public void cardGiving(int n, Card c) {
		//카드 타임 모듈을 사용하여 이동(덱에서 바닥으로)
	}
	public void showChangingButton() {
		//바꾸는 버튼 활성화 및 다른 버튼 클릭 막기    
	}
	public void eraseChangingButton() {
		//바꾸는 버튼 비활성화
	}
	public void gameEnd() {
		//이긴사람확인, 버튼 클릭 막고, 이긴사람 출력(게임종료 인터페이스)
	}
	public void sevenCalled() {
		//changingButton 활성화
	}
}
