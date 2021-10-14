import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.event.*;

public class GUI implements ActionListener {

  // A lot of these variables were for learning GUI, they will be replaced with
  // needed variabes

  // The frame to be used by All
  public static JFrame mainFrame = new JFrame();

  // All the panels that need to be accessed by the button actions.
  public static JPanel menuPanel = new JPanel();
  public static JPanel introPanel = new JPanel();
  public static JPanel fightPanel = new JPanel();
  public static JPanel defeatPanel = new JPanel();
  public static JPanel shopPanel = new JPanel();
  public static JPanel choicePanel = new JPanel();
  public static JPanel joinPanel = new JPanel();
  public static JPanel refusePanel = new JPanel();
  public static JPanel endPanel = new JPanel();

  public static void main(String[] args) {
    // not used
  }

  // easy panel creator
  public static JPanel panel(JFrame frame, int x, int y) {
    JPanel panel = new JPanel();
    frame.setSize(x, y);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.add(panel);
    return panel;
  }

  // easy label creator
  public static void labl(JPanel panel, String message, int x, int y, int zx, int zy) {
    JLabel label = new JLabel(message, SwingConstants.CENTER);
    label.setBounds(x, y, zx, zy);
    panel.add(label);
  }

  // easy image creator
  public static void image(JPanel panel, ImageIcon icon, int x, int y, int zx, int zy) {
    JLabel label = new JLabel(icon);
    label.setBounds(x, y, zx, zy);
    panel.add(label);
  }

  // Easy input text creator
  public static JTextField text(JPanel panel, int x, int y, int zx, int zy) {
    JTextField userText = new JTextField(20);
    userText.setBounds(x, y, zx, zy);
    panel.add(userText);
    return userText;
  }

  // easy button creator
  public static JButton butt(JPanel panel, String message, int x, int y, int zx, int zy) {
    JButton button = new JButton(message);
    button.setBounds(x, y, zx, zy);
    panel.add(button);
    return button;
  }

  // how the program deals with inputs from buttons
  @Override
  public void actionPerformed(ActionEvent e) {
    String buttonName = e.getActionCommand();
    if (buttonName.equals("join")) {
      System.out.println("JOINING");
      Main.slide = 2;
      Main.play();
    } else if (buttonName.equals("exit")) {
      Main.exit();
    } else if (buttonName.equals("Continue")) {
      Main.slide++;
      Main.play();
    } else if (buttonName.equals("attack")) {
      // System.out.println(Main.you.getBearHealth());
      Main.you.attack();
      fightPanel.setVisible(false);
      Main.you.addGold(Main.you.getBearDamage());

      // now it calls on play if you died.
      Main.play();
    } else if (buttonName.equals("shop")) {

      System.out.println("less gooo");
      Main.slide = 4;
      Main.play();
    } else if (buttonName.equals("Damage + 1")) {
      shopPanel.setVisible(false);
      Main.you.buyDamage();
      Main.play();
    } else if (buttonName.equals("Health + 3")) {
      shopPanel.setVisible(false);
      Main.you.buyHealth();
      Main.play();

    } else if (buttonName.equals("fight")) {
      shopPanel.setVisible(false);
      Main.slide = 3;
      Main.play();

    } else if (buttonName.equals("play again")) {

      Main.slide = 2;
      Main.play();

    } else if (buttonName.equals("Refuse")) {

      Main.slide = 6;
      Main.play();

    } else if (buttonName.equals("Join")) {
      Main.slide = 7;
      Main.play();
      }else if (buttonName.equals("Finish")){
        Main.slide = 9;
        Main.play();
      } else {
      System.out.println("AHHH");
    }
  }

  public static void Menu() {

    GridLayout OneByOne = new GridLayout(0, 1, 0, 10);

    menuPanel = GUI.panel(mainFrame, 250, 250);
    menuPanel.setLayout(OneByOne);
    menuPanel.setBackground(Color.green);

    GUI.labl(menuPanel, "Battle for Schlorg", 10, 25, 50, 10);

    JButton join = new JButton();
    join = GUI.butt(menuPanel, "Continue", 25, 25, 25, 25);
    join.setBackground(Color.YELLOW);
    join.setForeground(Color.BLACK);
    join.addActionListener(new GUI());
    JButton exit = new JButton();
    exit = GUI.butt(menuPanel, "exit", 25, 25, 25, 25);
    exit.addActionListener(new GUI());

    // image(panel, icon, 10, 120, 250, 250);
    // GUI.image(panel, icon, 100, 120, 250, 250);
  }

  public static void Intro() {

    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    introPanel = GUI.panel(mainFrame, 500, 500);
    introPanel.setLayout(OneByOne);
    introPanel.setBackground(Color.green);

    GUI.labl(introPanel, "You\'ve been tasked by the king ", 10, 25, 50, 10);
    GUI.labl(introPanel, "to scout out the forest in order to burn it down for farmland. ", 10, 25, 50, 10);
    GUI.labl(introPanel, "On the way, you meet a bear, a magical bear which is the guardian", 10, 25, 50, 10);
    GUI.labl(introPanel, "of the forest. You must defeat the bear to fulfill your mission.", 10, 25, 50, 10);

    // /

    JButton next = new JButton();
    next = GUI.butt(introPanel, "Continue", 25, 25, 25, 25);
    next.setBackground(Color.YELLOW);
    next.setForeground(Color.BLACK);
    next.addActionListener(new GUI());
  }

  public static void Fight() {
    // Gridlayout(rows, columns, spacing between rows, spacing between columns)
    GridLayout OneByOne = new GridLayout(0, 2, 3, 10);

    JPanel statPanel = new JPanel();
    fightPanel = new JPanel();

    fightPanel = GUI.panel(mainFrame, 500, 500);
    fightPanel.setLayout(OneByOne);
    fightPanel.setBackground(Color.green);

    ImageIcon icon = new ImageIcon("Images/cute.png");
    image(fightPanel, icon, 10, 10, 10, 10);

    fightPanel.add(statPanel);

    GridLayout TwoByOne = new GridLayout(0, 2, 0, 10);

    statPanel.setLayout(TwoByOne);
    statPanel.setBackground(Color.green);

    // set titles
    GUI.labl(statPanel, "You", 10, 25, 50, 10);
    GUI.labl(statPanel, "Bear", 10, 25, 50, 10);

    GUI.labl(statPanel, "Took " + Main.you.getBearDamage() + " damage", 10, 25, 50, 10);// You
    GUI.labl(statPanel, "Took " + Main.you.getDamage() + " damage", 10, 25, 50, 10);// Bear

    GUI.labl(statPanel, "Health: " + Main.you.getHealth(), 10, 25, 50, 10);
    GUI.labl(statPanel, "Health: " + Main.you.getBearHealth(), 10, 25, 50, 10);

    JButton attack = new JButton();
    attack = GUI.butt(fightPanel, "attack", 25, 25, 25, 25);
    attack.setBackground(Color.YELLOW);
    attack.setForeground(Color.BLACK);
    attack.addActionListener(new GUI());

    JButton shop = new JButton();
    shop = GUI.butt(fightPanel, "shop", 25, 25, 25, 25);
    shop.setBackground(Color.YELLOW);
    shop.setForeground(Color.BLACK);
    shop.addActionListener(new GUI());
    fightPanel.setVisible(true);
  }

  public static void shop() {
    JPanel buyPanel = new JPanel();

    GridLayout OneByOne = new GridLayout(4, 1, 0, 10);
    GridLayout TwoByTwo = new GridLayout(3, 2, 0, 10);
    // need to make a panel lol
    shopPanel = GUI.panel(mainFrame, 400, 500);
    shopPanel.setLayout(OneByOne);
    shopPanel.setBackground(Color.green);

    buyPanel = GUI.panel(mainFrame, 400, 500);
    buyPanel.setLayout(TwoByTwo);
    buyPanel.setBackground(Color.green);

    GUI.labl(shopPanel, "Current Gold: " + Main.you.getGold(), 10, 50, 50, 10);
    shopPanel.add(buyPanel);

    GUI.labl(buyPanel, "Current Damage: " + Main.you.getDamage(), 10, 50, 50, 10);
    GUI.labl(buyPanel, "Current Health: " + Main.you.getHealth(), 10, 10, 50, 10);

    GUI.labl(buyPanel, "Cost: 1 gold", 10, 50, 50, 10);
    GUI.labl(buyPanel, "Cost: 5 gold", 10, 10, 50, 10);

    JButton damage = new JButton();
    damage = GUI.butt(buyPanel, "Damage + 1", 25, 25, 25, 25);
    damage.setBackground(Color.YELLOW);
    damage.setForeground(Color.BLACK);
    damage.addActionListener(new GUI());
    JButton health = new JButton();
    health = GUI.butt(buyPanel, "Health + 3", 25, 25, 25, 25);
    health.addActionListener(new GUI());

    JButton fight = new JButton();
    fight = GUI.butt(shopPanel, "fight", 25, 25, 25, 25);
    fight.addActionListener(new GUI());
    fight.setBackground(Color.YELLOW);
    fight.setForeground(Color.BLACK);

    JButton exit = new JButton();
    exit = GUI.butt(shopPanel, "exit", 25, 25, 25, 25);
    exit.addActionListener(new GUI());

    shopPanel.setVisible(true);

  }

  public static void lose() {

    GridLayout OneByOne = new GridLayout(0, 1, 0, 10);

    defeatPanel = GUI.panel(mainFrame, 400, 500);
    defeatPanel.setLayout(OneByOne);
    defeatPanel.setBackground(Color.green);

    GUI.labl(defeatPanel, "You suck", 10, 25, 50, 10);
    GUI.labl(defeatPanel, "Would you like to play again?", 10, 25, 50, 10);

    JButton play_again = new JButton();
    play_again = GUI.butt(defeatPanel, "play again", 25, 25, 25, 25);
    play_again.setBackground(Color.YELLOW);
    play_again.setForeground(Color.BLACK);
    play_again.addActionListener(new GUI());
    JButton exit = new JButton();
    exit = GUI.butt(defeatPanel, "exit", 25, 25, 25, 25);
    exit.addActionListener(new GUI());
  }

  public static void Choice() {

    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);
    JPanel buttonPanel = new JPanel();

    choicePanel = GUI.panel(mainFrame, 500, 500);
    choicePanel.setLayout(OneByOne);
    choicePanel.setBackground(Color.green);

    JButton join = new JButton();
    join = GUI.butt(buttonPanel, "Join", 25, 25, 25, 25);
    join.setBackground(Color.YELLOW);
    join.setForeground(Color.BLACK);
    join.addActionListener(new GUI());

    JButton refuse = new JButton();
    refuse = GUI.butt(buttonPanel, "Refuse", 25, 25, 25, 25);
    refuse.setBackground(Color.YELLOW);
    refuse.setForeground(Color.BLACK);
    refuse.addActionListener(new GUI());

    GUI.labl(choicePanel, "Your about to slay the bear before he utters: ", 10, 25, 50, 10);
    GUI.labl(choicePanel, "“You are a formidable foe", 10, 25, 50, 10);
    GUI.labl(choicePanel, "before I die I would like to ask you something… ", 10, 25, 50, 10);
    GUI.labl(choicePanel, "Would you like to join me to save nature", 10, 25, 50, 10);
    GUI.labl(choicePanel, "from the wrath of human destruction?”", 10, 25, 50, 10);

    choicePanel.add(buttonPanel);

  }

  public static void KingEnd() {

    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    refusePanel = GUI.panel(mainFrame, 700, 500);
    refusePanel.setLayout(OneByOne);
    refusePanel.setBackground(Color.green);

    GUI.labl(refusePanel, "You’ve accomplished the king’s task", 10, 25, 50, 10);
    GUI.labl(refusePanel, "You’ve agreed to stay true to your duties ", 10, 25, 50, 10);
    GUI.labl(refusePanel, "You go on to slay the bear and burn the forest as your king desired.", 10, 25, 50, 10);
    GUI.labl(refusePanel, "Your actions led to the death of many animals and plants in the forest.", 10, 25, 50, 10);
    GUI.labl(refusePanel, "Your kingdom was able to prosper from your duty. ", 10, 25, 50, 10);
    GUI.labl(refusePanel, "They managed to build the farms they planned to increase crop production. ", 10, 25, 50, 10);
    GUI.labl(refusePanel, "They’ve increase their agriculture trade by 70% ", 10, 25, 50, 10);
    GUI.labl(refusePanel, "and starvation within the kingdom fell by 30%. ", 10, 25, 50, 10);
    GUI.labl(refusePanel, "Impressed by your success, the king has promoted you to a commander.", 10, 25, 50, 10);

    // /

    JButton next = new JButton();
    next = GUI.butt(refusePanel, "Finish", 25, 25, 25, 25);
    next.setBackground(Color.YELLOW);
    next.setForeground(Color.BLACK);
    next.addActionListener(new GUI());
  }

  public static void BearEnd() {

    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    joinPanel = GUI.panel(mainFrame, 700, 500);
    joinPanel.setLayout(OneByOne);
    joinPanel.setBackground(Color.green);

    GUI.labl(joinPanel, "You’ve failed the king’s task.", 10, 25, 50, 10);
    GUI.labl(joinPanel, "You’ve agreed to side with the bear than your duties. ", 10, 25, 50, 10);
    GUI.labl(joinPanel, "You go on with the bear to revive the forest. Restoring all the destruction ", 10, 25, 50, 10);
    GUI.labl(joinPanel, "humans have caused to nature. You cannot return to your kingdom in fear of being punished", 10,
        25, 50, 10);

    GUI.labl(joinPanel, "with treason. You now inhabit within the forest, feasting  on plants.", 10, 25, 50, 10);

    GUI.labl(joinPanel, "You dedicate your life to protecting the forest with your combat skills.", 10, 25, 50, 10);

    GUI.labl(joinPanel, "Along the way you  befriend other animals and adopt a new way of life.", 10, 25, 50, 10);
    // /

    JButton next = new JButton();
    next = GUI.butt(joinPanel, "Finish", 25, 25, 25, 25);
    next.setBackground(Color.YELLOW);
    next.setForeground(Color.BLACK);
    next.addActionListener(new GUI());
  }

    public static void end() {

    GridLayout OneByOne = new GridLayout(0, 1, 0, 10);

    endPanel = GUI.panel(mainFrame, 400, 500);
    endPanel.setLayout(OneByOne);
    endPanel.setBackground(Color.green);

    GUI.labl(endPanel, "Thank you for playing", 10, 25, 50, 10);
    GUI.labl(endPanel, "Would you like to play again?", 10, 25, 50, 10);

    JButton play_again = new JButton();
    play_again = GUI.butt(endPanel, "play again", 25, 25, 25, 25);
    play_again.setBackground(Color.YELLOW);
    play_again.setForeground(Color.BLACK);
    play_again.addActionListener(new GUI());
    JButton exit = new JButton();
    exit = GUI.butt(endPanel, "exit", 25, 25, 25, 25);
    exit.addActionListener(new GUI());

    GUI.endPanel.setVisible(true);
  }
}