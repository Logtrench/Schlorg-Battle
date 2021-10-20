import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

  // the cheat variables
  public static int toggle = 1;
  public static String cheat = "disabled!";

  // the submitting toggle variable and username testfield object
  public static boolean sub = false;
  public static JTextField user = new JTextField(50);

  // the difficulty variable
  public static String difficulty = "Medium";

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
  static JPanel difPanel = new JPanel();
  static JPanel scorePanel = new JPanel();

  // this is the colour palet

  static Color golden = new Color(254, 158, 16);
  static Color deepBlue = new Color(132, 143, 195);
  static Color forest = new Color(28, 44, 44);
  static Color rose = new Color(206, 161, 178);
  static Color pale = new Color(246, 226, 127);
  static Color ruby = new Color(202, 46, 85);
  static Color darkerBlue = new Color(75, 89, 154);
  static Color lighterBlue = new Color(193, 199, 225);

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

  public static void labl(JPanel panel, String message, int size) {
    JLabel label = new JLabel(message, SwingConstants.CENTER);
    Font Robo = new Font("Roboto", Font.BOLD, size);
    label.setFont(Robo);
    panel.add(label);
  }

  // Label creator method, adds to a panel
  public static JTextField text(JPanel panel, String message) {
    JTextField text = new JTextField(message, 12);
    panel.add(text);

    return text;
  }

  // Image creator method, adds to a panel
  public static void image(JPanel panel, ImageIcon icon) {
    JLabel label = new JLabel(icon);
    panel.add(label);
  }

  // Buton creator method , returns button
  public static JButton butt(JPanel panel, String message, Color back, Color fore) {
    JButton button = new JButton(message);
    panel.add(button);
    button.addActionListener(new GUI());
    button.setBackground(back);
    button.setForeground(fore);
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
        Main.rounds++;

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

        // resetting gold and damage and health if the user wants to play again.
        Main.you.reset();

        Main.slide = 1;
        Main.play();
        break;

      // refuse button set slide to 6 (refuse ending)
      // set previous slides to invisible
      // set the ending for scoreboard
      // call play
      case "Refuse":
        choicePanel.setVisible(false);
        Main.slide = 6;
        Main.ending = "The King's Ending";
        Main.play();
        break;

      // join button set slide to 7 (join ending)
      // set previous slides to invisible
      // call play
      case "Join":
        choicePanel.setVisible(false);
        Main.slide = 7;
        Main.ending = "The Forest Ending";
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

      // The difficulty button changes slide
      // sets menu invisible
      // call play
      case "Choose Difficulty":
        menuPanel.setVisible(false);

        Main.slide = 11;
        Main.play();
        break;

      // Changes difficulty to easy
      case "Easy":
        difPanel.setVisible(false);

        // changes string of difficulty chosen into what was clicked
        difficulty = buttonName;
        Main.you.setDifficultyHealth(15);
        Main.play();
        break;

      // changes difficulty to medium
      case "Medium":
        difPanel.setVisible(false);

        // changes string of difficulty chosen into what was clicked
        difficulty = buttonName;
        Main.you.setDifficultyHealth(30);
        Main.play();
        break;

      // changes difficulty to hard
      case "Hard":
        difPanel.setVisible(false);

        // changes string of difficulty chosen into what was clicked
        difficulty = buttonName;
        Main.you.setDifficultyHealth(50);
        Main.play();
        break;

      // confirms the difficulty chosen for play and send back to menu
      case "Confirm":
        difPanel.setVisible(false);

        Main.slide = 1;
        Main.play();
        break;

      // Obtain user text and set the username to that
      // set subToggle to true to display username message
      // call the submit score class
      // call play
      case "Submit":
        scorePanel.setVisible(false);

        //check if user entered a username
        if (user.getText().isEmpty()) 
        {
          
        } else
        {//check if they already submitted
          if (sub) {
          
        } else
        {//if not submited already, let them submit
          Main.username = user.getText();
          ScoreBoard.main();
          sub = true;
        }
        }
        
        //update UI
        Main.slide = 12;
        Main.play();
        break;

      // go back to play again after submitting (or not) a score
      case "Back":
        scorePanel.setVisible(false);

        Main.slide = 9;
        Main.play();
        break;

      // go from the play again menu to the score menu
      case "Submit Score":
        endPanel.setVisible(false);
        Main.slide = 12;
        Main.play();
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
    menuPanel = panel(mainFrame, 300, 300);
    menuPanel.setLayout(OneCol);
    menuPanel.setBackground(deepBlue);

    // Adding two labels, the titles and cheat toggle
    labl(menuPanel, "Battle for Schlorg");
    labl(menuPanel, "Cheats " + cheat);

    // adding continue button and parameters
    JButton cont = new JButton();
    cont = butt(menuPanel, "Continue", golden, Color.BLACK);

    // adding exit button and paramters
    JButton exit = new JButton();
    exit = butt(menuPanel, "Exit", (new JButton().getBackground()), ruby);

    // adding cheat button and parameters
    JButton cheat = new JButton();
    cheat = butt(menuPanel, "Toggle Cheats", forest, golden);

    // adding difficulty button and parameters
    JButton diff = new JButton();
    diff = butt(menuPanel, "Choose Difficulty", forest, golden);

    // making sure the ui can update in the end
    menuPanel.setVisible(true);
  }

  public static void Intro() {

    // Making a layout with only one column and many rows
    GridLayout OneCol = new GridLayout(0, 1, 3, 10);

    // setting introPanel parameters
    introPanel = panel(mainFrame, 500, 300);
    introPanel.setLayout(OneCol);
    introPanel.setBackground(deepBlue);

    // adding text to panel, this is the story
    labl(introPanel, "You\'ve been tasked by the king ");
    labl(introPanel, "to scout out the forest in order to burn it down for farmland. ");
    labl(introPanel, "On the way, you meet a bear, a magical bear which is the guardian");
    labl(introPanel, "of the forest. You must defeat the bear to fulfill your mission.");

    // creating and setting Continue button paramters
    JButton next = new JButton();
    next = butt(introPanel, "Continue", golden, Color.BLACK);
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
    fightPanel.setBackground(deepBlue);

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

    // adding colours and layouts to subPanels of statPanel
    youPanel.setLayout(OneCol);
    bearPanel.setLayout(OneCol);
    youPanel.setBackground(pale);
    bearPanel.setBackground(rose);

    // make titles for stat
    labl(youPanel, "You");
    labl(bearPanel, "Bear");

    // checks if bear damage is unchanged, only display "took" when damage started
    if (Main.you.getBearDamage() != -1) {
      labl(youPanel, "Took " + Main.you.getBearDamage() + " damage");// You
      labl(bearPanel, "Took " + Main.you.getDamage() + " damage");// Bear
    } // no else as nothing would be within it

    // display health of bear and user using player.get methods
    labl(youPanel, "Health: " + Main.you.getHealth());
    labl(bearPanel, "Health: " + Main.you.getBearHealth());

    // creating and set of attack button
    JButton attack = new JButton();
    attack = butt(fightPanel, "Attack", golden, Color.BLACK);
    attack.setFont(new Font("Roboto", Font.BOLD, 25));

    // creating and set of shop button
    JButton shop = new JButton();
    shop = butt(fightPanel, "Shop", golden, Color.BLACK);
    shop.setFont(new Font("Roboto", Font.BOLD, 25));

    // setting to visible
    fightPanel.setVisible(true);
  }

  public static void shop() {
    // initializing buyPanel (subPanel)
    JPanel buyPanel = new JPanel();

    // creating both grid layouts needed
    GridLayout OneCol = new GridLayout(0, 1, 0, 0);
    GridLayout TwoCol = new GridLayout(0, 2, 0, 0);

    // setting shop panel parameters
    shopPanel = panel(mainFrame, 400, 500);
    shopPanel.setLayout(OneCol);
    shopPanel.setBackground(deepBlue);

    // setting buy panel parameters
    buyPanel = panel(mainFrame, 400, 500);
    buyPanel.setLayout(TwoCol);
    buyPanel.setBackground(deepBlue);

    // displaying the amount of gold user has
    labl(shopPanel, "Current Gold: " + Main.you.getGold(), 22);
    labl(shopPanel, "Hint: you earn gold by taking damage.", 15);
    shopPanel.add(buyPanel);

    // displaying current damage and health of player
    labl(buyPanel, "Current Damage: " + Main.you.getDamage(), 15);
    labl(buyPanel, "Current Health: " + Main.you.getHealth(), 15);

    // displaying cost of upgrades
    labl(buyPanel, "Cost: 1 gold", 15);
    labl(buyPanel, "Cost: 5 gold", 15);

    // creation and setting of the damage and health buy buttons
    JButton damage = new JButton();
    damage = butt(buyPanel, "Damage + 1", golden, Color.BLACK);
    JButton health = new JButton();
    health = butt(buyPanel, "Health + 3", golden, Color.BLACK);

    // setting standard colours for buttons
    health.setBackground(golden);
    damage.setBackground(golden);

    // if they cannot buy, it will be a lighter version
    if (Main.you.getGold() < 5) {
      health.setBackground(pale);
      if (Main.you.getGold() < 1) {
        damage.setBackground(pale);
      }
    }
    damage.setForeground(Color.BLACK);

    // creation of the button to send you back to fighting
    JButton fight = new JButton();
    fight = butt(shopPanel, "Fight", golden, Color.BLACK);
    fight.setFont(new Font("Roboto", Font.BOLD, 25));

    // set to true for UI update
    shopPanel.setVisible(true);

  }

  public static void lose() {
    // resetting gold and damage and health if the user wants to play again.
    Main.you.reset();

    // creation of grid layout
    GridLayout OneByOne = new GridLayout(0, 1, 0, 10);

    // setting of the panel parameters
    defeatPanel = panel(mainFrame, 400, 500);
    defeatPanel.setLayout(OneByOne);
    defeatPanel.setBackground(deepBlue);

    // displaying death message
    labl(defeatPanel, "You died.");
    labl(defeatPanel, "Would you like to play again?");

    // display play again button to play again
    JButton play_again = new JButton();
    play_again = butt(defeatPanel, "Play Again", golden, Color.BLACK);

    // Display exit button
    JButton exit = new JButton();
    exit = butt(defeatPanel, "Exit", (new JButton().getBackground()), ruby);
  }

  public static void Choice() {

    // creation of grid layout
    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    // creation of a subPanel for looks
    JPanel buttonPanel = new JPanel();
    buttonPanel.setBackground(darkerBlue);

    // parameter setting of choice panel
    choicePanel = panel(mainFrame, 500, 500);
    choicePanel.setLayout(OneByOne);
    choicePanel.setBackground(deepBlue);

    // creation and setting of join button
    JButton join = new JButton();
    join = butt(buttonPanel, "Join", golden, Color.BLACK);

    // creation and setting of refuse button
    JButton refuse = new JButton();
    refuse = butt(buttonPanel, "Refuse", golden, Color.BLACK);

    // story development
    labl(choicePanel, "You're about to slay the bear before he utters: ");
    labl(choicePanel, "“You are a formidable foe");
    labl(choicePanel, "before I die I would like to ask you something… ");
    labl(choicePanel, "Would you like to join me to save nature");
    labl(choicePanel, "from the wrath of human destruction?”");

    // adding the buttons at the end
    choicePanel.add(buttonPanel);

  }

  public static void KingEnd() {

    // creation of grid layout
    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    // setting of panel parameters
    refusePanel = panel(mainFrame, 700, 400);
    refusePanel.setLayout(OneByOne);
    refusePanel.setBackground(deepBlue);

    // story development!
    labl(refusePanel, "You’ve accomplished the king’s task");
    labl(refusePanel, "You’ve agreed to stay true to your duties ");
    labl(refusePanel, "You go on to slay the bear and burn the forest as your king desired.");
    labl(refusePanel, "Your actions led to the death of many animals and plants in the forest.");
    labl(refusePanel, "Your kingdom was able to prosper from your duty. ");
    labl(refusePanel, "They managed to build the farms they planned to increase crop production. ");
    labl(refusePanel, "They’ve increase their agriculture trade by 70% ");
    labl(refusePanel, "and starvation within the kingdom fell by 30%. ");
    labl(refusePanel, "Impressed by your success, the king has promoted you to a commander.");

    // creation and settin of Finish button
    JButton next = new JButton();
    next = butt(refusePanel, "Finish", golden, Color.BLACK);
  }

  public static void BearEnd() {

    // creation of grid layout
    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    // setting of panel parameters
    joinPanel = panel(mainFrame, 670, 400);
    joinPanel.setLayout(OneByOne);
    joinPanel.setBackground(deepBlue);

    // story development!
    labl(joinPanel, "You’ve failed the king’s task.");
    labl(joinPanel, "You’ve agreed to side with the bear rather than your duties. ");
    labl(joinPanel, "You go on with the bear to revive the forest. Restoring all the destruction ");
    labl(joinPanel, "humans have caused to nature. You cannot return to your kingdom in fear of being punished");

    labl(joinPanel, "with treason. You now inhabit within the forest, feasting  on plants.");

    labl(joinPanel, "You dedicate your life to protecting the forest with your combat skills.");

    labl(joinPanel, "Along the way you befriend other animals and adopt a new way of life.");

    // creation and settin of Finish button
    JButton next = new JButton();
    next = butt(joinPanel, "Finish", golden, Color.BLACK);
  }

  public static void BothLose() {

    // creation of grid layout
    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    // setting of main panel
    diePanel = panel(mainFrame, 400, 400);
    diePanel.setLayout(OneByOne);
    diePanel.setBackground(deepBlue);

    // story development!
    labl(diePanel, "You’ve failed the king’s task.");
    labl(diePanel, "Both you and the bear have died");
    labl(diePanel, "The king, not seeing your return, has");
    labl(diePanel, "sent another scout who then accomplishes his task.");
    labl(diePanel, "Within a century no one remembers you nor the bear.");
    labl(diePanel, "Life goes on as normal");

    // creation and set of finish button
    JButton next = new JButton();
    next = butt(diePanel, "Finish", golden, Color.BLACK);
  }

  public static void end() {

    // creation of grid layout
    GridLayout OneByOne = new GridLayout(0, 1, 0, 10);

    // setting of main panel
    endPanel = panel(mainFrame, 400, 300);
    endPanel.setLayout(OneByOne);
    endPanel.setBackground(deepBlue);

    // displaying end message
    labl(endPanel, "Thank you for playing");
    labl(endPanel, "Would you like to play again?");

    // creation and set of play again button
    JButton play_again = new JButton();
    play_again = butt(endPanel, "Play Again", golden, Color.BLACK);

    // creation and set of submit score button
    JButton Submit = new JButton();
    Submit = butt(endPanel, "Submit Score", forest, golden);

    // creation and set of exit button
    JButton exit = new JButton();
    exit = butt(endPanel, "Exit", (new JButton().getBackground()), ruby);

    // set to true for UI updating
    endPanel.setVisible(true);
  }

  public static void Difficulty() {

    // creation of grid layouts
    GridLayout OneCol = new GridLayout(0, 1, 0, 10);
    GridLayout TwoCol = new GridLayout(0, 2, 0, 10);

    // 3 subpanels are needed for desired layout
    JPanel easPanel = new JPanel();
    JPanel medPanel = new JPanel();
    JPanel harPanel = new JPanel();

    // Setting the layout for the subPanels
    easPanel.setLayout(TwoCol);
    medPanel.setLayout(TwoCol);
    harPanel.setLayout(TwoCol);

    // adding colours to subpanels
    easPanel.setBackground(lighterBlue);
    medPanel.setBackground(lighterBlue);
    harPanel.setBackground(lighterBlue);

    // Setting difpanel properties
    difPanel = panel(mainFrame, 300, 300);
    difPanel.setLayout(OneCol);
    difPanel.setBackground(deepBlue);

    // adding text explanation
    labl(difPanel, "Please choose a difficulty:");
    labl(difPanel, "Difficulty is: " + difficulty);

    // adding subpanels
    difPanel.add(easPanel);
    difPanel.add(medPanel);
    difPanel.add(harPanel);

    // creating the button for easy mode
    JButton easy = new JButton();
    easy = butt(easPanel, "Easy", forest, golden);

    // describing easy mode
    labl(easPanel, "Bear Health of 15.");

    // creating button ofr medium mode
    JButton medium = new JButton();
    medium = butt(medPanel, "Medium", forest, golden);

    // describing medium mode
    labl(medPanel, "Bear Health of 30.");

    // creating button for hard mode
    JButton hard = new JButton();
    hard = butt(harPanel, "Hard", forest, golden);

    // describing hard mode
    labl(harPanel, "Bear Health of 50.");

    // adding confirm button to go back to menu
    JButton confirm = new JButton();
    confirm = butt(difPanel, "Confirm", golden, Color.black);

    // setting visible to update UI
    difPanel.setVisible(true);
  }

  public static void Scoreboard() {

    // creation of grid layout
    GridLayout OneCol = new GridLayout(0, 1, 0, 10);

    // Setting difpanel properties
    scorePanel = panel(mainFrame, 300, 300);
    scorePanel.setLayout(OneCol);
    scorePanel.setBackground(deepBlue);

    // creating subPanels
    JPanel userPanel = new JPanel();
    JPanel roundPanel = new JPanel();
    JPanel endingPanel = new JPanel();
    JPanel cheatPanel = new JPanel();
    JPanel diffiPanel = new JPanel();

    // setting the colours
    userPanel.setBackground(lighterBlue);
    roundPanel.setBackground(lighterBlue);
    endingPanel.setBackground(lighterBlue);
    cheatPanel.setBackground(lighterBlue);
    diffiPanel.setBackground(lighterBlue);

    // adding title
    labl(scorePanel, "ScoreBoard Submitter:");

    // Adding subpanels
    scorePanel.add(userPanel);
    scorePanel.add(roundPanel);
    scorePanel.add(endingPanel);
    scorePanel.add(cheatPanel);
    scorePanel.add(diffiPanel);

    // adding username input
    labl(userPanel, "Username: ");
    user = text(userPanel, Main.username);

    // displaying teh statistics:
    labl(roundPanel, "Rounds: " + Main.rounds);
    labl(endingPanel, "Ending: " + Main.ending);
    labl(diffiPanel, "Difficulty: " + difficulty);
    labl(cheatPanel, "Cheats: " + cheat);

    // creating the button for easy mode
    JButton submit = new JButton();
    submit = butt(scorePanel, "Submit", golden, Color.BLACK);

    // If they already submitted then it should not run it twice, this will let them
    // know

    //if they already submitted and there is a username
    if (sub && user.getText().isEmpty()) {
      labl(scorePanel, "You submitted " + Main.username + "'s score!'");
    }//if they already submitted and the entered a username
    else if (sub) {
      labl(scorePanel, "You already submitted " + Main.username + "'s score!'");
    } //if the didn't submit and didn't ener a username
    else {
      labl(scorePanel, "Enter a username to submit!");
    }

    // creating the button to go back to playAgain
    JButton back = new JButton();
    back = butt(scorePanel, "Back", golden, Color.BLACK);

    // set visible for UI update
    scorePanel.setVisible(true);
  }
}