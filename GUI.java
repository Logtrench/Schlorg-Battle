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
  public static void image(JPanel panel, ImageIcon icon) {
    JLabel label = new JLabel(icon);
    panel.add(label);
  }

  // Buton creator method , returns button
  public static JButton butt(JPanel panel, String message) {
    JButton button = new JButton(message);
    panel.add(button);
    button.addActionListener(new GUI());
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
        fightPanel.setVisible(false);

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
        fightPanel.setVisible(false);
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
        choicePanel.setVisible(false);
        Main.slide = 6;
        Main.play();
        break;

      // join button set slide to 7 (join ending)
      // set previous slides to invisible
      // call play
      case "Join":
        choicePanel.setVisible(false);
        Main.slide = 7;
        Main.play();
        break;

      // finish button set slide to 9 (play again)
      // set previous slides to invisible
      // call play
      case "Finish":
        joinPanel.setVisible(false);
        refusePanel.setVisible(false);
        diePanel.setVisible(false);

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

  // menu panel
  public static void Menu() {

    // Making a layout with only one column and many rows
    GridLayout OneCol = new GridLayout(0, 1, 0, 10);

    // setting manuPanel parameters
    menuPanel = panel(mainFrame, 270, 270);
    menuPanel.setLayout(OneCol);
    menuPanel.setBackground(Color.green);

    // Adding two labels, the titles and cheat toggle
    labl(menuPanel, "Battle for Schlorg");
    labl(menuPanel, "Cheats " + cheat);

    // adding continue button and parameters
    JButton cont = new JButton();
    cont = butt(menuPanel, "Continue");
    cont.setBackground(Color.YELLOW);
    cont.setForeground(Color.BLACK);

    // adding exit button and paramters
    JButton exit = new JButton();
    exit = butt(menuPanel, "Exit");
    exit.setForeground(Color.red);

    // adding cheat button and parameters
    JButton cheat = new JButton();
    cheat = butt(menuPanel, "Toggle Cheats");
    cheat.setForeground(Color.blue);

    // making sure the ui can update in the end
    menuPanel.setVisible(true);
  }

  public static void Intro() {

    // Making a layout with only one column and many rows
    GridLayout OneCol = new GridLayout(0, 1, 3, 10);

    // setting introPanel parameters
    introPanel = panel(mainFrame, 500, 300);
    introPanel.setLayout(OneCol);
    introPanel.setBackground(Color.green);

    // adding text to panel, this is the story
    labl(introPanel, "You\'ve been tasked by the king ");
    labl(introPanel, "to scout out the forest in order to burn it down for farmland. ");
    labl(introPanel, "On the way, you meet a bear, a magical bear which is the guardian");
    labl(introPanel, "of the forest. You must defeat the bear to fulfill your mission.");

    // creating and setting Continue button paramters
    JButton next = new JButton();
    next = butt(introPanel, "Continue");
    next.setBackground(Color.YELLOW);
    next.setForeground(Color.BLACK);
  }

  public static void Fight() {

    // making two layouts, one for the overall panel/stats panel
    // one for the individual panels within stats (for different colours)
    GridLayout TwoCol = new GridLayout(0, 2, 3, 10);
    GridLayout OneCol = new GridLayout(0, 1, 3, 10);

    // initializing every panel
    JPanel statPanel = new JPanel();
    JPanel youPanel = new JPanel();
    JPanel bearPanel = new JPanel();
    JPanel hintPanel1 = new JPanel();
    JPanel hintPanel2 = new JPanel();

    // creating and setting fightPanel parameters
    fightPanel = new JPanel();
    fightPanel = panel(mainFrame, 500, 500);
    fightPanel.setLayout(TwoCol);
    fightPanel.setBackground(Color.green);

    // adding cute bear image
    ImageIcon icon = new ImageIcon("Images/cute.png");
    image(fightPanel, icon);

    // adding the other panels
    fightPanel.add(statPanel);
    statPanel.add(youPanel);
    statPanel.add(bearPanel);

    // setting stat parameters
    statPanel.setLayout(TwoCol);
    statPanel.setBackground(Color.WHITE);

    // use rgb values to create a colour
    Color lightBlue = new Color(116, 146, 237);
    Color lightRed = new Color(237, 120, 116);

    // adding colours and layouts to subPanels of statPanel
    youPanel.setLayout(OneCol);
    bearPanel.setLayout(OneCol);
    youPanel.setBackground(lightBlue);
    bearPanel.setBackground(lightRed);

    // make titles for stat
    labl(youPanel, "You");
    labl(bearPanel, "Bear");

    // checks if bear damage is unchanged, only display "took" when damage started
    if (Main.you.getBearDamage() != -1) {
      labl(youPanel, "Took " + Main.you.getBearDamage() + " damage");// You
      labl(bearPanel, "Took " + Main.you.getDamage() + " damage");// Bear
    } // no else as nothing would be within it

    //display health of bear and user using player.get methods
    labl(youPanel, "Health: " + Main.you.getHealth());
    labl(bearPanel, "Health: " + Main.you.getBearHealth());

    //display a critical piece of info, gold income and add it to panels
    labl(hintPanel1, "Hint: earn gold");// You
    labl(hintPanel2, " when damaged");
    
    //is added seperately for a desired size with gridLayout
    youPanel.add(hintPanel1);
    bearPanel.add(hintPanel2);

    //creating and set of attack button
    JButton attack = new JButton();
    attack = butt(fightPanel, "Attack");
    attack.setBackground(Color.YELLOW);
    attack.setForeground(Color.BLACK);

    JButton shop = new JButton();
    shop = butt(fightPanel, "Shop");
    shop.setBackground(Color.YELLOW);
    shop.setForeground(Color.BLACK);
    fightPanel.setVisible(true);
  }

  public static void shop() {
    JPanel buyPanel = new JPanel();

    GridLayout OneByOne = new GridLayout(3, 1, 0, 10);
    GridLayout TwoByTwo = new GridLayout(3, 2, 0, 10);
    // need to make a panel lol
    shopPanel = panel(mainFrame, 400, 500);
    shopPanel.setLayout(OneByOne);
    shopPanel.setBackground(Color.green);

    buyPanel = panel(mainFrame, 400, 500);
    buyPanel.setLayout(TwoByTwo);
    buyPanel.setBackground(Color.green);

    labl(shopPanel, "Current Gold: " + Main.you.getGold());
    shopPanel.add(buyPanel);

    labl(buyPanel, "Current Damage: " + Main.you.getDamage());
    labl(buyPanel, "Current Health: " + Main.you.getHealth());

    labl(buyPanel, "Cost: 1 gold");
    labl(buyPanel, "Cost: 5 gold");

    JButton damage = new JButton();
    damage = butt(buyPanel, "Damage + 1");
    damage.setBackground(Color.YELLOW);
    damage.setForeground(Color.BLACK);
    JButton health = new JButton();
    health = butt(buyPanel, "Health + 3");

    JButton fight = new JButton();
    fight = butt(shopPanel, "Fight");
    fight.addActionListener(new GUI());
    fight.setBackground(Color.YELLOW);
    fight.setForeground(Color.BLACK);

    shopPanel.setVisible(true);

  }

  public static void lose() {
    // resetting gold and damage and health if the user wants to play again.
    Main.you.reset();

    GridLayout OneByOne = new GridLayout(0, 1, 0, 10);

    defeatPanel = panel(mainFrame, 400, 500);
    defeatPanel.setLayout(OneByOne);
    defeatPanel.setBackground(Color.green);

    labl(defeatPanel, "You suck cause you died haha");
    labl(defeatPanel, "Would you like to play again?");

    JButton play_again = new JButton();
    play_again = butt(defeatPanel, "Play Again");
    play_again.setBackground(Color.YELLOW);
    play_again.setForeground(Color.BLACK);
    JButton exit = new JButton();
    exit = butt(defeatPanel, "Exit");
    exit.setForeground(Color.red);
  }

  public static void Choice() {

    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);
    JPanel buttonPanel = new JPanel();

    choicePanel = panel(mainFrame, 500, 500);
    choicePanel.setLayout(OneByOne);
    choicePanel.setBackground(Color.green);

    JButton join = new JButton();
    join = butt(buttonPanel, "Join");
    join.setBackground(Color.YELLOW);
    join.setForeground(Color.BLACK);

    JButton refuse = new JButton();
    refuse = butt(buttonPanel, "Refuse");
    refuse.setBackground(Color.YELLOW);
    refuse.setForeground(Color.BLACK);

    labl(choicePanel, "You're about to slay the bear before he utters: ");
    labl(choicePanel, "“You are a formidable foe");
    labl(choicePanel, "before I die I would like to ask you something… ");
    labl(choicePanel, "Would you like to join me to save nature");
    labl(choicePanel, "from the wrath of human destruction?”");

    choicePanel.add(buttonPanel);

  }

  public static void KingEnd() {

    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    refusePanel = panel(mainFrame, 700, 500);
    refusePanel.setLayout(OneByOne);
    refusePanel.setBackground(Color.green);

    labl(refusePanel, "You’ve accomplished the king’s task");
    labl(refusePanel, "You’ve agreed to stay true to your duties ");
    labl(refusePanel, "You go on to slay the bear and burn the forest as your king desired.");
    labl(refusePanel, "Your actions led to the death of many animals and plants in the forest.");
    labl(refusePanel, "Your kingdom was able to prosper from your duty. ");
    labl(refusePanel, "They managed to build the farms they planned to increase crop production. ");
    labl(refusePanel, "They’ve increase their agriculture trade by 70% ");
    labl(refusePanel, "and starvation within the kingdom fell by 30%. ");
    labl(refusePanel, "Impressed by your success, the king has promoted you to a commander.");

    // /

    JButton next = new JButton();
    next = butt(refusePanel, "Finish");
    next.setBackground(Color.YELLOW);
    next.setForeground(Color.BLACK);
  }

  public static void BearEnd() {

    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    joinPanel = panel(mainFrame, 700, 500);
    joinPanel.setLayout(OneByOne);
    joinPanel.setBackground(Color.green);

    labl(joinPanel, "You’ve failed the king’s task.");
    labl(joinPanel, "You’ve agreed to side with the bear rather than your duties. ");
    labl(joinPanel, "You go on with the bear to revive the forest. Restoring all the destruction ");
    labl(joinPanel, "humans have caused to nature. You cannot return to your kingdom in fear of being punished");

    labl(joinPanel, "with treason. You now inhabit within the forest, feasting  on plants.");

    labl(joinPanel, "You dedicate your life to protecting the forest with your combat skills.");

    labl(joinPanel, "Along the way you befriend other animals and adopt a new way of life.");
    // /

    JButton next = new JButton();
    next = butt(joinPanel, "Finish");
    next.setBackground(Color.YELLOW);
    next.setForeground(Color.BLACK);
  }

  public static void BothLose() {

    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    diePanel = panel(mainFrame, 700, 500);
    diePanel.setLayout(OneByOne);
    diePanel.setBackground(Color.green);

    labl(diePanel, "You’ve failed the king’s task.");
    labl(diePanel, "Both you and the bear have died");
    labl(diePanel, "The king, not seeing your return, has");
    labl(diePanel, "sent another scout who then accomplishes his task.");

    labl(diePanel, "Within a century no one remembers you nor the bear.");

    labl(diePanel, "Life goes on as normal");
    // /

    JButton next = new JButton();
    next = butt(diePanel, "Finish");
    next.setBackground(Color.YELLOW);
    next.setForeground(Color.BLACK);
  }

  public static void end() {

    // resetting gold and damage and health if the user wants to play again.
    Main.you.reset();
    // resetting cheats to disabled

    GridLayout OneByOne = new GridLayout(0, 1, 0, 10);

    endPanel = panel(mainFrame, 400, 500);
    endPanel.setLayout(OneByOne);
    endPanel.setBackground(Color.green);

    labl(endPanel, "Thank you for playing");
    labl(endPanel, "Would you like to play again?");

    JButton play_again = new JButton();
    play_again = butt(endPanel, "Play Again");
    play_again.setBackground(Color.YELLOW);
    play_again.setForeground(Color.BLACK);
    JButton exit = new JButton();
    exit = butt(endPanel, "Exit");
    exit.setForeground(Color.red);

    endPanel.setVisible(true);
  }
}