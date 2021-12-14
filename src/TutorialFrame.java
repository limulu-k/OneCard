import java.awt.Color;
import java.awt.Font;
import java.text.Collator;

import javax.swing.*;

import org.w3c.dom.css.RGBColor;



public class TutorialFrame extends JFrame{
   private int page;
   private JLabel basicRule;
   private JLabel rule1;
   private JLabel rule2;
   private JLabel rule3;
   private JLabel rule4;
   private JLabel card;
   private JLabel see;
   private JLabel attack;
   private JLabel attack2;
   private JLabel attackA;
   private JLabel attackSpadeA;
   private JLabel colorJocker;
   private JLabel blackJocker;
   private JLabel attackCard1;
   private JLabel attackCard2;
   private JLabel attackCard3;
   private JLabel attackCard4;
   private JLabel attackCard5;
   private JLabel attackSpacialRule;
   private JLabel attackRule1_1;
   private JLabel attackRule1_2;
   private JLabel attackRule2;
   private JLabel attackRule3;
   private JLabel cardSeven;
   private JLabel cardK;
   private JLabel cardQ;
   private JLabel cardJ;
   private JLabel special1;
   private JLabel special2;
   private JLabel special3;
   
   public TutorialFrame() {
      setTitle("Tutorial");
      setSize(800, 800);
      setVisible(true);
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      setResizable(false);
      page = 1;
      JButton previous = new JButton("이전");
      JButton next = new JButton("다음");
      JButton main = new JButton("게임으로 ㄱㄱ");
      next.setBounds(420,650,250,50);
      next.setHorizontalAlignment(JLabel.CENTER);
      next.setFont(next.getFont().deriveFont(20.0f));
      add(next);
      main.setBounds(420,650,250,50);
      main.setHorizontalAlignment(JLabel.CENTER);
      main.setFont(main.getFont().deriveFont(20.0f));
      add(main);
      main.setVisible(false);
      previous.setBounds(130,650,250,50);
      previous.setHorizontalAlignment(JLabel.CENTER);
      previous.setFont(previous.getFont().deriveFont(20.0f));
      add(previous);
            
      setOnePage();
      setTwoPage();
      setThreePage();
      setFourPage();
      setFivePage();
         
      add(new JLabel());
      previous.addActionListener(event -> {
         if(page == 2) {
            pageTwo(false);
            pageOne(true);
            page-=1;
         }
         else if(page == 3) {
            pageThree(false);
            pageTwo(true);
            page-=1;
         }
         else if(page == 4) {
            pageFour(false);
            pageThree(true);
            page-=1;
         }
         else if(page == 5) {
            pageFive(false);
            pageFour(true);
            page-=1;
            next.setVisible(true);
            main.setVisible(false);
         }
        });
      next.addActionListener(event -> {
         if(page == 1) {
            pageOne(false);
            pageTwo(true);
            page+=1;
         }
         else if(page == 2) {
            pageTwo(false);
            pageThree(true);
            page+=1;
         }
         else if(page == 3) {
            pageThree(false);
            pageFour(true);
            page+=1;
         }
         else if(page == 4) {
            pageFour(false);
            pageFive(true);
            page+=1;
            next.setVisible(false);
            main.setVisible(true);
         }
        });
      main.addActionListener(event -> {
         setVisible(false);
         String name = JOptionPane.showInputDialog("이름을 입력하세요");
         new MainGameFrame(name);
        });
      
   }
   
   public void setOnePage() {
      basicRule = new JLabel("원카드 기본 규칙");
      rule1 = new JLabel("1. 서로 턴을 돌아가면서 한장씩 카드를 냅니다.");
      rule2 = new JLabel("2. 오픈 된 카드와 모양이 같거나 숫자가 같아야만 카드를 낼 수 있습니다.");
      rule3 = new JLabel("3. 내려놓을 카드가 없다면 뒤집어진 카드에서 한 장을 가져옵니다.");
      rule4 = new JLabel("4. 모든 카드를 내려 놓은 사람이 승리합니다.");
      
      basicRule.setBounds(0, 70, 800, 50);
      basicRule.setHorizontalAlignment(JLabel.CENTER);
      basicRule.setFont(basicRule.getFont().deriveFont(50.0f));
      add(basicRule);
      rule1.setBounds(0, 250, 800, 50);
      rule1.setHorizontalAlignment(JLabel.CENTER);
      rule1.setFont(rule1.getFont().deriveFont(20.0f));
      add(rule1);
      rule2.setBounds(0, 350, 800, 50);
      rule2.setHorizontalAlignment(JLabel.CENTER);
      rule2.setFont(rule1.getFont().deriveFont(20.0f));
      add(rule2);
      rule3.setBounds(0, 450, 800, 50);
      rule3.setHorizontalAlignment(JLabel.CENTER);
      rule3.setFont(rule1.getFont().deriveFont(20.0f));
      add(rule3);
      rule4.setBounds(0, 550, 800, 50);
      rule4.setHorizontalAlignment(JLabel.CENTER);
      rule4.setFont(rule1.getFont().deriveFont(20.0f));
      add(rule4);
      //basicRule.setVisible(false);
      //rule1.setVisible(false);
      //rule2.setVisible(false);
      //rule3.setVisible(false);
      //rule4.setVisible(false);
   }
   
   public void setTwoPage() {
      card = new JLabel("특별 능력이 있는 카드들");
      see = new JLabel("보려면 다음으로");
      
      card.setBounds(0, 250, 800, 50);
      card.setHorizontalAlignment(JLabel.CENTER);
      card.setFont(card.getFont().deriveFont(50.0f));
      add(card);
      see.setBounds(0, 400, 800, 50);
      see.setHorizontalAlignment(JLabel.CENTER);
      see.setFont(see.getFont().deriveFont(20.0f));
      add(see);
      card.setVisible(false);
      see.setVisible(false);
   }
   
   public void setThreePage() {
      attack2 = new JLabel("2");
      attackA = new JLabel("A");
      attackSpadeA = new JLabel("스페이드 A");
      blackJocker = new JLabel("흑백조커");
      colorJocker = new JLabel("컬러조커");
      attack = new JLabel("공격카드");
      attackCard1 = new JLabel("공격을 받으면 2장을 추가합니다.");//3
      attackCard2 = new JLabel("공격을 받으면 3장을 추가합니다.");//3
      attackCard3 = new JLabel("공격을 받으면 5장을 추가합니다.");//8
      attackCard4 = new JLabel("공격을 받으면 7장을 추가합니다.");//6
      attackCard5 = new JLabel("공격을 받으면 10장을 추가합니다.");//6
      attack.setBounds(0, 70, 800, 50);
      attack.setHorizontalAlignment(JLabel.CENTER);
      attack.setFont(attack.getFont().deriveFont(50.0f));
      add(attack);
      attackCard1.setBounds(0, 200, 800, 50);
      attackCard1.setHorizontalAlignment(JLabel.CENTER);
      attackCard1.setFont(attackCard1.getFont().deriveFont(20.0f));
      add(attackCard1);
      attack2.setBounds(200, 200, 800, 50);
      attack2.setFont(attack2.getFont().deriveFont(60.0f));
      attack2.setForeground(Color.RED);
      attack2.setVisible(false);
      add(attack2);
      attackCard2.setBounds(0, 280, 800, 50);
      attackCard2.setHorizontalAlignment(JLabel.CENTER);
      attackCard2.setFont(attackCard2.getFont().deriveFont(20.0f));
      add(attackCard2);
      attackA.setBounds(200, 280, 800, 50);
      attackA.setFont(attackA.getFont().deriveFont(60.0f));
      attackA.setForeground(Color.ORANGE);
      attackA.setVisible(false);
      add(attackA);
      attackCard3.setBounds(0, 360, 800, 50);
      attackCard3.setHorizontalAlignment(JLabel.CENTER);
      attackCard3.setFont(attackCard3.getFont().deriveFont(20.0f));
      add(attackCard3);
      attackSpadeA.setBounds(15, 360, 800, 50);
      attackSpadeA.setFont(attackSpadeA.getFont().deriveFont(45.0f));
      attackSpadeA.setForeground(Color.GREEN);
      //attackSpadeA.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      attackSpadeA.setVisible(false);
      
      add(attackSpadeA);
      attackCard4.setBounds(0, 440, 800, 50);
      attackCard4.setHorizontalAlignment(JLabel.CENTER);
      attackCard4.setFont(attackCard4.getFont().deriveFont(20.0f));
      add(attackCard4);
      blackJocker.setBounds(30, 440, 800, 50);
      blackJocker.setFont(blackJocker.getFont().deriveFont(50.0f));
      blackJocker.setForeground(Color.BLUE);
      blackJocker.setVisible(false);
      add(blackJocker);
      attackCard5.setBounds(0, 520, 800, 50);
      attackCard5.setHorizontalAlignment(JLabel.CENTER);
      attackCard5.setFont(attackCard5.getFont().deriveFont(20.0f));
      add(attackCard5);
      colorJocker.setBounds(30, 520, 800, 50);
      colorJocker.setFont(colorJocker.getFont().deriveFont(50.0f));
      colorJocker.setForeground(Color.PINK);
      colorJocker.setVisible(false);
      add(colorJocker);
      attack.setVisible(false);
      attackCard1.setVisible(false);
      attackCard2.setVisible(false);
      attackCard3.setVisible(false);
      attackCard4.setVisible(false);
      attackCard5.setVisible(false);
      
   }
   
   public void setFourPage() {
      attackSpacialRule = new JLabel("공격시 유의사항");
      attackRule1_1 = new JLabel("1. 공격카드를 냈을 경우에는 공격카드만 낼 수 있고");
      attackRule1_2 = new JLabel("만약에 낼 수 없다면 카드를 덱에서 뽑아야 합니다.");
      attackRule2 = new JLabel("2. 만약 공격카드를 연속으로 냈을 경우 공격카드의 패널티는 누적됩니다.");
      attackRule3 = new JLabel("3. 하지만 조커를 냈을 때에는 조커를 제외한 카드를 낼 수 없습니다.");
      attackSpacialRule.setBounds(0, 50, 800, 50);
      attackSpacialRule.setHorizontalAlignment(JLabel.CENTER);
      attackSpacialRule.setFont(attackSpacialRule.getFont().deriveFont(40.0f));
      add(attackSpacialRule);
      attackRule1_1.setBounds(0, 200, 800, 50);
      attackRule1_1.setHorizontalAlignment(JLabel.CENTER);
      attackRule1_1.setFont(attackRule1_1.getFont().deriveFont(20.0f));
      add(attackRule1_1);
      attackRule1_2.setBounds(0, 240, 800, 50);
      attackRule1_2.setHorizontalAlignment(JLabel.CENTER);
      attackRule1_2.setFont(attackRule1_2.getFont().deriveFont(20.0f));
      add(attackRule1_2);
      attackRule2.setBounds(0, 350, 800, 50);
      attackRule2.setHorizontalAlignment(JLabel.CENTER);
      attackRule2.setFont(attackRule2.getFont().deriveFont(20.0f));
      add(attackRule2);
      attackRule3.setBounds(0, 500, 800, 50);
      attackRule3.setHorizontalAlignment(JLabel.CENTER);
      attackRule3.setFont(attackRule3.getFont().deriveFont(20.0f));
      add(attackRule3);
      attackSpacialRule.setVisible(false);
      attackRule1_1.setVisible(false);
      attackRule1_2.setVisible(false);
      attackRule2.setVisible(false);
      attackRule3.setVisible(false);
   }
   
   public void setFivePage() {
      cardSeven = new JLabel("7은 원하는 모양으로 바꾸기");
      cardK = new JLabel("K는 한 번 더 내기");
      cardQ = new JLabel("Q는 방향 전환하기");
      cardJ = new JLabel("J는 한 사람 건너뛰기");
      special1 = new JLabel("하지만 이 게임은 두명이서 진행하므로 ");
      special2 = new JLabel("K와 J는 한 번 더 내는 것이 되고");
      special3 = new JLabel("Q는 능력이 사라집니다.");
      cardSeven.setBounds(0, 100, 800, 50);
      cardSeven.setHorizontalAlignment(JLabel.CENTER);
      cardSeven.setFont(cardSeven.getFont().deriveFont(20.0f));
      add(cardSeven);
      cardK.setBounds(0, 150, 800, 50);
      cardK.setHorizontalAlignment(JLabel.CENTER);
      cardK.setFont(cardK.getFont().deriveFont(20.0f));
      add(cardK);
      cardQ.setBounds(0, 200, 800, 50);
      cardQ.setHorizontalAlignment(JLabel.CENTER);
      cardQ.setFont(cardQ.getFont().deriveFont(20.0f));
      add(cardQ);
      cardJ.setBounds(0, 250, 800, 50);
      cardJ.setHorizontalAlignment(JLabel.CENTER);
      cardJ.setFont(cardJ.getFont().deriveFont(20.0f));
      add(cardJ);
      special1.setBounds(0, 400, 800, 50);
      special1.setHorizontalAlignment(JLabel.CENTER);
      special1.setFont(special1.getFont().deriveFont(20.0f));
      add(special1);
      special2.setBounds(0, 450, 800, 50);
      special2.setHorizontalAlignment(JLabel.CENTER);
      special2.setFont(special2.getFont().deriveFont(20.0f));
      add(special2);
      special3.setBounds(0, 500, 800, 50);
      special3.setHorizontalAlignment(JLabel.CENTER);
      special3.setFont(special3.getFont().deriveFont(20.0f));
      add(special3);
      cardSeven.setVisible(false);
      cardK.setVisible(false);
      cardQ.setVisible(false);
      cardJ.setVisible(false);
      special1.setVisible(false);
      special2.setVisible(false);
      special3.setVisible(false);
   }
   
   public void pageOne(boolean tf) {
      basicRule.setVisible(tf);
      rule1.setVisible(tf);
      rule2.setVisible(tf);
      rule3.setVisible(tf);
      rule4.setVisible(tf);
   }
   public void pageTwo(boolean tf) {
      card.setVisible(tf);
      see.setVisible(tf);
   }
   public void pageThree(boolean tf) {
      attack.setVisible(tf);
      attackCard1.setVisible(tf);
      attackCard2.setVisible(tf);
      attackCard3.setVisible(tf);
      attackCard4.setVisible(tf);
      attackCard5.setVisible(tf);
      attack2.setVisible(tf);
      attackA.setVisible(tf);
      attackSpadeA.setVisible(tf);
      blackJocker.setVisible(tf);
      colorJocker.setVisible(tf);
   }
   public void pageFour(boolean tf) {
      attackSpacialRule.setVisible(tf);
      attackRule1_1.setVisible(tf);
      attackRule1_2.setVisible(tf);
      attackRule2.setVisible(tf);
      attackRule3.setVisible(tf);
   }
   public void pageFive(boolean tf) {
      cardSeven.setVisible(tf);
      cardK.setVisible(tf);
      cardQ.setVisible(tf);
      cardJ.setVisible(tf);
      special1.setVisible(tf);
      special2.setVisible(tf);
      special3.setVisible(tf);
   }
}