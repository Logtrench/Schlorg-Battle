import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

  // A lot of these variables were for learning GUI, they will be replaced with
  // needed variabes

  // the toggle variable for cheats
  public static int toggle = 1;
  public static String cheat = "disabled!";
  // The frame to be used by All
  public static JFrame mainFrame = new JFrame();

  // All the panels that need to be accessed by the button actions and set
  // visible.
  public static JPanel menuPanel = new JPanel();
  public static JPanel introPanel = new JPanel();
  public static JPanel fightPanel = new JPanel();
  public static JPanel defeatPanel = new JPanel();
  public static JPanel shopPanel = new JPanel();
  public static JPanel choicePanel = new JPanel();
  public static JPanel joinPanel = new JPanel();
  public static JPanel refusePanel = new JPanel();
  public static JPanel endPanel = new JPanel();
  public static JPanel diePanel = new JPanel();

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
      Main.you.addGold(Main.you.getBearDamage());
      fightPanel.setVisible(false);
 

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

      Main.slide = 1;
      Main.play();

    } else if (buttonName.equals("Refuse")) {

      Main.slide = 6;
      Main.play();

    } else if (buttonName.equals("Join")) {
      Main.slide = 7;
      Main.play();
    } else if (buttonName.equals("Finish")) {
      Main.slide = 9;
      Main.play();
    } else if (buttonName.equals("Enable Cheats")) {
      toggle = toggle * (-1);

      if (toggle == -1) {
        menuPanel.setVisible(false);
        Main.you.setDamage(999);
        Main.you.setGold(999);
        Main.you.setHealth(999);
        cheat = "enabled!";
        Main.play();
      }
      if (toggle == 1) {
        menuPanel.setVisible(false);
        Main.you.setDamage(2);
        Main.you.setGold(5);
        Main.you.setHealth(10);
        cheat = "disabled!";
        Main.play();
      }

    } else {
      System.out.println("AHHH");
    }
  }

  public static void Menu() {

    GridLayout OneByOne = new GridLayout(0, 1, 0, 10);

    menuPanel = GUI.panel(mainFrame, 270, 270);
    menuPanel.setLayout(OneByOne);
    menuPanel.setBackground(Color.green);

    GUI.labl(menuPanel, "Battle for Schlorg", 10, 25, 50, 10);
    GUI.labl(menuPanel, "Cheats " + cheat, 10, 25, 50, 10);

    JButton join = new JButton();
    join = GUI.butt(menuPanel, "Continue", 25, 25, 25, 25);
    join.setBackground(Color.YELLOW);
    join.setForeground(Color.BLACK);
    join.addActionListener(new GUI());
    JButton exit = new JButton();
    exit = GUI.butt(menuPanel, "exit", 25, 25, 25, 25);
    exit.addActionListener(new GUI());
    exit.setForeground(Color.red);

    JButton cheat = new JButton();
    cheat = GUI.butt(menuPanel, "Enable Cheats", 25, 25, 25, 25);
    cheat.setForeground(Color.blue);
    cheat.addActionListener(new GUI());

    menuPanel.setVisible(true);
    // Make a button called enable cheats.

    // image(panel, icon, 10, 120, 250, 250);
    // GUI.image(panel, icon, 100, 120, 250, 250);
  }

  public static void Intro() {

    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    introPanel = GUI.panel(mainFrame, 500, 300);
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
    GridLayout TwoCol = new GridLayout(0, 2, 3, 10);
    GridLayout OneCol = new GridLayout(0, 1, 3, 10);

    JPanel statPanel = new JPanel();
    JPanel youPanel = new JPanel();
    JPanel bearPanel = new JPanel();
    JPanel hintPanel1 = new JPanel();
    JPanel hintPanel2 = new JPanel();

    fightPanel = new JPanel();

    fightPanel = GUI.panel(mainFrame, 500, 500);
    fightPanel.setLayout(TwoCol);
    fightPanel.setBackground(Color.green);

    ImageIcon icon = new ImageIcon("Images/cute.png");
    image(fightPanel, icon, 10, 10, 10, 10);

    fightPanel.add(statPanel);
    statPanel.add(youPanel);
    statPanel.add(bearPanel);
    

    statPanel.setLayout(TwoCol);
    statPanel.setBackground(Color.WHITE);


    //uses rgb values to create a colour
    Color lightBlue = new Color(116,146,237);
    Color lightRed = new Color(237,120,116);

    youPanel.setLayout(OneCol);
    bearPanel.setLayout(OneCol);
    youPanel.setBackground(lightBlue);
    bearPanel.setBackground(lightRed);

    // set titles
    GUI.labl(youPanel, "You", 10, 25, 50, 10);
    GUI.labl(bearPanel, "Bear", 10, 25, 50, 10);

    // checks if bear health and your health are unchanged.

    if (Main.you.getBearHealth() != 30 && Main.you.getHealth() != 10) {
      GUI.labl(youPanel, "Took " + Main.you.getBearDamage() + " damage", 10, 25, 50, 10);// You
      GUI.labl(bearPanel, "Took " + Main.you.getDamage() + " damage", 10, 25, 50, 10);// Bear
    } else {

      // Bear
    }

    GUI.labl(youPanel, "Health: " + Main.you.getHealth(), 10, 25, 50, 10);
    GUI.labl(bearPanel, "Health: " + Main.you.getBearHealth(), 10, 25, 50, 10);


    GUI.labl(hintPanel1, "Hint: earn gold", 10, 25, 50, 10);// You
    GUI.labl(hintPanel2, " when damaged", 10, 25, 50, 10);
    youPanel.add(hintPanel1);
    bearPanel.add(hintPanel2);

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
    exit.setForeground(Color.red);

    shopPanel.setVisible(true);

  }

  public static void lose() {

    GridLayout OneByOne = new GridLayout(0, 1, 0, 10);

    defeatPanel = GUI.panel(mainFrame, 400, 500);
    defeatPanel.setLayout(OneByOne);
    defeatPanel.setBackground(Color.green);

    GUI.labl(defeatPanel, "You suck cause you died haha", 10, 25, 50, 10);
    GUI.labl(defeatPanel, "Would you like to play again?", 10, 25, 50, 10);

    JButton play_again = new JButton();
    play_again = GUI.butt(defeatPanel, "play again", 25, 25, 25, 25);
    play_again.setBackground(Color.YELLOW);
    play_again.setForeground(Color.BLACK);
    play_again.addActionListener(new GUI());
    JButton exit = new JButton();
    exit = GUI.butt(defeatPanel, "exit", 25, 25, 25, 25);
    exit.addActionListener(new GUI());
    exit.setForeground(Color.red);
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

    GUI.labl(choicePanel, "You're about to slay the bear before he utters: ", 10, 25, 50, 10);
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
    GUI.labl(joinPanel, "You’ve agreed to side with the bear rather than your duties. ", 10, 25, 50, 10);
    GUI.labl(joinPanel, "You go on with the bear to revive the forest. Restoring all the destruction ", 10, 25, 50, 10);
    GUI.labl(joinPanel, "humans have caused to nature. You cannot return to your kingdom in fear of being punished", 10,
        25, 50, 10);

    GUI.labl(joinPanel, "with treason. You now inhabit within the forest, feasting  on plants.", 10, 25, 50, 10);

    GUI.labl(joinPanel, "You dedicate your life to protecting the forest with your combat skills.", 10, 25, 50, 10);

    GUI.labl(joinPanel, "Along the way you befriend other animals and adopt a new way of life.", 10, 25, 50, 10);
    // /

    JButton next = new JButton();
    next = GUI.butt(joinPanel, "Finish", 25, 25, 25, 25);
    next.setBackground(Color.YELLOW);
    next.setForeground(Color.BLACK);
    next.addActionListener(new GUI());
  }

  public static void BothLose() {

    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    diePanel = GUI.panel(mainFrame, 700, 500);
    diePanel.setLayout(OneByOne);
    diePanel.setBackground(Color.green);

    GUI.labl(diePanel, "You’ve failed the king’s task.", 10, 25, 50, 10);
    GUI.labl(diePanel, "Both you and the bear have died", 10, 25, 50, 10);
    GUI.labl(diePanel, "The king, not seeing your return, has", 10, 25, 50, 10);
    GUI.labl(diePanel, "sent another scout who then accomplishes his task.", 10, 25, 50, 10);

    GUI.labl(diePanel, "Within a century no one remembers you nor the bear.", 10, 25, 50, 10);

    GUI.labl(diePanel, "Life goes on as normal", 10, 25, 50, 10);
    // /

    JButton next = new JButton();
    next = GUI.butt(diePanel, "Finish", 25, 25, 25, 25);
    next.setBackground(Color.YELLOW);
    next.setForeground(Color.BLACK);
    next.addActionListener(new GUI());
  }

  public static void end() {

    // resetting gold and damage and health if the user wants to play again.
    Main.you.setGold(5);
    Main.you.setHealth(10);
    Main.you.setDamage(2);
    Main.you.setBearHealth(30);
    // resetting cheats to disabled
    toggle = 1;
    cheat = "disabled!";

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
    exit.setForeground(Color.red);

    GUI.endPanel.setVisible(true);
  }
}