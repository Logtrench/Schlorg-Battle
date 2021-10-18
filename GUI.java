import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

  // the cheat variables
  public static int toggle = 1;
  public static String cheat = "disabled!";

  // The frame to be used by ALL panels
  public static JFrame mainFrame = new JFrame();

  // All panels that need to be setVisible(false) by button actions.
  static JPanel menuPanel = new JPanel();
  static JPanel introPanel = new JPanel();
  static JPanel fightPanel = new JPanel();
  static JPanel defeatPanel = new JPanel();
  static JPanel shopPanel = new JPanel();
  static JPanel choicePanel = new JPanel();
  static JPanel joinPanel = new JPanel();
  static JPanel refusePanel = new JPanel();
  static JPanel endPanel = new JPanel();
  static JPanel diePanel = new JPanel();

  // Panel Creator method, returns the panel
  public static JPanel panel(JFrame frame, int x, int y) {
    JPanel panel = new JPanel();
    frame.setSize(x, y);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.add(panel);
    return panel;
  }

  // Label creator method, adds to a panel
  public static void labl(JPanel panel, String message) {
    JLabel label = new JLabel(message, SwingConstants.CENTER);
    panel.add(label);
  }

  // Image creator method, adds to a panel
  public static void image(JPanel panel, ImageIcon icon, int x, int y, int zx, int zy) {
    JLabel label = new JLabel(icon);
    label.setBounds(x, y, zx, zy);
    panel.add(label);
  }

  // Buton creator method , returns button
  public static JButton butt(JPanel panel, String message, int x, int y, int zx, int zy) {
    JButton button = new JButton(message);
    button.setBounds(x, y, zx, zy);
    panel.add(button);
    return button;
  }

  // how the program deals with inputs from buttons
  @Override
  public void actionPerformed(ActionEvent e) {

    // Takes button input and sets it to String
    // This will find the name of the button
    String buttonName = e.getActionCommand();

    // checking the button name and implementing actions
    // in switch case
    switch (buttonName) {
      // exit button will simply exit system
      case "Exit":
        System.exit(0);
        break;

      // Continue button will increase slide value by one
      // set previous slides to invisible
      // call play
      case "Continue":
        menuPanel.setVisible(false);
        introPanel.setVisible(false);
        Main.slide++;
        Main.play();
        break;

      // attack button will call player.attack method
      // add gold based on damage taken
      // set fight to invisible in order to update UI
      // call play
      case "Attack":
        Main.you.attack();
        Main.you.addGold(Main.you.getBearDamage());
        fightPanel.setVisible(false);

        Main.play();
        break;

      // shop button will set slide to 4 (shop slide)
      // set previous slides to invisible
      // call play
      case "Shop":
        GUI.fightPanel.setVisible(false);

        Main.slide = 4;
        Main.play();
        break;

      // Damage + 1 button calls player.buyDamage method
      // set shop slide to invisible for UI update
      // call play
      case "Damage + 1":
        Main.you.buyDamage();
        shopPanel.setVisible(false);
        Main.play();
        break;

      // Health + 3 button calls player.buyHealth method
      // set shop slide to invisible for UI update
      // call play
      case "Health + 3":
        shopPanel.setVisible(false);
        Main.you.buyHealth();
        Main.play();
        break;

      // fight button set slide to 3 (fight panel)
      // set previous slides to invisible
      // call play
      case "Fight":
        shopPanel.setVisible(false);
        Main.slide = 3;
        Main.play();
        break;

      // play again button set slide to 1 (menu panel)
      // set previous slides to invisible
      // call play
      case "Play Again":
        defeatPanel.setVisible(false);
        endPanel.setVisible(false);

        Main.slide = 1;
        Main.play();
        break;

      // refuse button set slide to 6 (refuse ending)
      // set previous slides to invisible
      // call play
      case "Refuse":
        GUI.choicePanel.setVisible(false);
        Main.slide = 6;
        Main.play();
        break;

      // join button set slide to 7 (join ending)
      // set previous slides to invisible
      // call play
      case "Join":
        GUI.choicePanel.setVisible(false);
        Main.slide = 7;
        Main.play();
        break;

      // finish button set slide to 9 (play again)
      // set previous slides to invisible
      // call play
      case "Finish":
        GUI.joinPanel.setVisible(false);
        GUI.refusePanel.setVisible(false);
        GUI.diePanel.setVisible(false);

        Main.slide = 9;
        Main.play();
        break;

      // Toggle cheats button change the toggle int
      // call the toggle method
      case "Toggle Cheats":
        toggle = toggle * (-1);

        Main.you.cheat(toggle);
        break;

      // should never be called, helps debugging buttons.
      default:
        System.out.println("default was called in button switch, should not have happened");
        break;

    }
  }

  //menu panel
  public static void Menu() {

    //Making a layout with only one column and many rows
    GridLayout OneCol = new GridLayout(0, 1, 0, 10);

    //setting manuPanel parameters
    menuPanel = GUI.panel(mainFrame, 270, 270);
    menuPanel.setLayout(OneCol);
    menuPanel.setBackground(Color.green);

    //Adding two labels, the titles and cheat toggle
    GUI.labl(menuPanel, "Battle for Schlorg");
    GUI.labl(menuPanel, "Cheats " + cheat);

    //adding continue button and parameters
    JButton cont = new JButton();
    cont = GUI.butt(menuPanel, "Continue", 25, 25, 25, 25);
    cont.setBackground(Color.YELLOW);
    cont.setForeground(Color.BLACK);
    cont.addActionListener(new GUI());

    //adding exit button and paramters
    JButton exit = new JButton();
    exit = GUI.butt(menuPanel, "Exit", 25, 25, 25, 25);
    exit.addActionListener(new GUI());
    exit.setForeground(Color.red);

    //adding cheat button and parameters
    JButton cheat = new JButton();
    cheat = GUI.butt(menuPanel, "Toggle Cheats", 25, 25, 25, 25);
    cheat.setForeground(Color.blue);
    cheat.addActionListener(new GUI());

    //making sure the ui can update in the end
    menuPanel.setVisible(true);
  }

  public static void Intro() {

    //Making a layout with only one column and many rows
    GridLayout OneCol = new GridLayout(0, 1, 3, 10);

    //setting introPanel parameters
    introPanel = GUI.panel(mainFrame, 500, 300);
    introPanel.setLayout(OneCol);
    introPanel.setBackground(Color.green);

    //adding text to panel, this is the story
    GUI.labl(introPanel, "You\'ve been tasked by the king ");
    GUI.labl(introPanel, "to scout out the forest in order to burn it down for farmland. ");
    GUI.labl(introPanel, "On the way, you meet a bear, a magical bear which is the guardian");
    GUI.labl(introPanel, "of the forest. You must defeat the bear to fulfill your mission.");

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

    // uses rgb values to create a colour
    Color lightBlue = new Color(116, 146, 237);
    Color lightRed = new Color(237, 120, 116);

    youPanel.setLayout(OneCol);
    bearPanel.setLayout(OneCol);
    youPanel.setBackground(lightBlue);
    bearPanel.setBackground(lightRed);

    // set titles
    GUI.labl(youPanel, "You");
    GUI.labl(bearPanel, "Bear");

    // checks if bear damage is unchanged

    if (Main.you.getBearDamage() != -1) {
      GUI.labl(youPanel, "Took " + Main.you.getBearDamage() + " damage");// You
      GUI.labl(bearPanel, "Took " + Main.you.getDamage() + " damage");// Bear
    } else {

      // Bear
    }

    GUI.labl(youPanel, "Health: " + Main.you.getHealth());
    GUI.labl(bearPanel, "Health: " + Main.you.getBearHealth());

    GUI.labl(hintPanel1, "Hint: earn gold");// You
    GUI.labl(hintPanel2, " when damaged");
    youPanel.add(hintPanel1);
    bearPanel.add(hintPanel2);

    JButton attack = new JButton();
    attack = GUI.butt(fightPanel, "Attack", 25, 25, 25, 25);
    attack.setBackground(Color.YELLOW);
    attack.setForeground(Color.BLACK);
    attack.addActionListener(new GUI());

    JButton shop = new JButton();
    shop = GUI.butt(fightPanel, "Shop", 25, 25, 25, 25);
    shop.setBackground(Color.YELLOW);
    shop.setForeground(Color.BLACK);
    shop.addActionListener(new GUI());
    fightPanel.setVisible(true);
  }

  public static void shop() {
    JPanel buyPanel = new JPanel();

    GridLayout OneByOne = new GridLayout(3, 1, 0, 10);
    GridLayout TwoByTwo = new GridLayout(3, 2, 0, 10);
    // need to make a panel lol
    shopPanel = GUI.panel(mainFrame, 400, 500);
    shopPanel.setLayout(OneByOne);
    shopPanel.setBackground(Color.green);

    buyPanel = GUI.panel(mainFrame, 400, 500);
    buyPanel.setLayout(TwoByTwo);
    buyPanel.setBackground(Color.green);

    GUI.labl(shopPanel, "Current Gold: " + Main.you.getGold());
    shopPanel.add(buyPanel);

    GUI.labl(buyPanel, "Current Damage: " + Main.you.getDamage());
    GUI.labl(buyPanel, "Current Health: " + Main.you.getHealth());

    GUI.labl(buyPanel, "Cost: 1 gold");
    GUI.labl(buyPanel, "Cost: 5 gold");

    JButton damage = new JButton();
    damage = GUI.butt(buyPanel, "Damage + 1", 25, 25, 25, 25);
    damage.setBackground(Color.YELLOW);
    damage.setForeground(Color.BLACK);
    damage.addActionListener(new GUI());
    JButton health = new JButton();
    health = GUI.butt(buyPanel, "Health + 3", 25, 25, 25, 25);
    health.addActionListener(new GUI());

    JButton fight = new JButton();
    fight = GUI.butt(shopPanel, "Fight", 25, 25, 25, 25);
    fight.addActionListener(new GUI());
    fight.setBackground(Color.YELLOW);
    fight.setForeground(Color.BLACK);

    shopPanel.setVisible(true);

  }

  public static void lose() {
    // resetting gold and damage and health if the user wants to play again.
    Main.you.reset();

    GridLayout OneByOne = new GridLayout(0, 1, 0, 10);

    defeatPanel = GUI.panel(mainFrame, 400, 500);
    defeatPanel.setLayout(OneByOne);
    defeatPanel.setBackground(Color.green);

    GUI.labl(defeatPanel, "You suck cause you died haha");
    GUI.labl(defeatPanel, "Would you like to play again?");

    JButton play_again = new JButton();
    play_again = GUI.butt(defeatPanel, "Play Again", 25, 25, 25, 25);
    play_again.setBackground(Color.YELLOW);
    play_again.setForeground(Color.BLACK);
    play_again.addActionListener(new GUI());
    JButton exit = new JButton();
    exit = GUI.butt(defeatPanel, "Exit", 25, 25, 25, 25);
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

    GUI.labl(choicePanel, "You're about to slay the bear before he utters: ");
    GUI.labl(choicePanel, "“You are a formidable foe");
    GUI.labl(choicePanel, "before I die I would like to ask you something… ");
    GUI.labl(choicePanel, "Would you like to join me to save nature");
    GUI.labl(choicePanel, "from the wrath of human destruction?”");

    choicePanel.add(buttonPanel);

  }

  public static void KingEnd() {

    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    refusePanel = GUI.panel(mainFrame, 700, 500);
    refusePanel.setLayout(OneByOne);
    refusePanel.setBackground(Color.green);

    GUI.labl(refusePanel, "You’ve accomplished the king’s task");
    GUI.labl(refusePanel, "You’ve agreed to stay true to your duties ");
    GUI.labl(refusePanel, "You go on to slay the bear and burn the forest as your king desired.");
    GUI.labl(refusePanel, "Your actions led to the death of many animals and plants in the forest.");
    GUI.labl(refusePanel, "Your kingdom was able to prosper from your duty. ");
    GUI.labl(refusePanel, "They managed to build the farms they planned to increase crop production. ");
    GUI.labl(refusePanel, "They’ve increase their agriculture trade by 70% ");
    GUI.labl(refusePanel, "and starvation within the kingdom fell by 30%. ");
    GUI.labl(refusePanel, "Impressed by your success, the king has promoted you to a commander.");

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

    GUI.labl(joinPanel, "You’ve failed the king’s task.");
    GUI.labl(joinPanel, "You’ve agreed to side with the bear rather than your duties. ");
    GUI.labl(joinPanel, "You go on with the bear to revive the forest. Restoring all the destruction ");
    GUI.labl(joinPanel, "humans have caused to nature. You cannot return to your kingdom in fear of being punished");

    GUI.labl(joinPanel, "with treason. You now inhabit within the forest, feasting  on plants.");

    GUI.labl(joinPanel, "You dedicate your life to protecting the forest with your combat skills.");

    GUI.labl(joinPanel, "Along the way you befriend other animals and adopt a new way of life.");
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

    GUI.labl(diePanel, "You’ve failed the king’s task.");
    GUI.labl(diePanel, "Both you and the bear have died");
    GUI.labl(diePanel, "The king, not seeing your return, has");
    GUI.labl(diePanel, "sent another scout who then accomplishes his task.");

    GUI.labl(diePanel, "Within a century no one remembers you nor the bear.");

    GUI.labl(diePanel, "Life goes on as normal");
    // /

    JButton next = new JButton();
    next = GUI.butt(diePanel, "Finish", 25, 25, 25, 25);
    next.setBackground(Color.YELLOW);
    next.setForeground(Color.BLACK);
    next.addActionListener(new GUI());
  }

  public static void end() {

    // resetting gold and damage and health if the user wants to play again.
    Main.you.reset();
    // resetting cheats to disabled

    GridLayout OneByOne = new GridLayout(0, 1, 0, 10);

    endPanel = GUI.panel(mainFrame, 400, 500);
    endPanel.setLayout(OneByOne);
    endPanel.setBackground(Color.green);

    GUI.labl(endPanel, "Thank you for playing");
    GUI.labl(endPanel, "Would you like to play again?");

    JButton play_again = new JButton();
    play_again = GUI.butt(endPanel, "Play Again", 25, 25, 25, 25);
    play_again.setBackground(Color.YELLOW);
    play_again.setForeground(Color.BLACK);
    play_again.addActionListener(new GUI());
    JButton exit = new JButton();
    exit = GUI.butt(endPanel, "Exit", 25, 25, 25, 25);
    exit.addActionListener(new GUI());
    exit.setForeground(Color.red);

    GUI.endPanel.setVisible(true);
  }
}