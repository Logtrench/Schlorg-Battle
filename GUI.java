import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.event.*;

public class GUI implements ActionListener {

  // A lot of these variables were for learning GUI, they will be replaced with
  // needed variabes
  private static ImageIcon icon;
  private static JLabel label;

  // The frame to be used by All
  public static JFrame mainFrame = new JFrame();

  // All the panels that need to be accessed by the button actions.
  public static JPanel menuPanel = new JPanel();
  public static JPanel introPanel = new JPanel();
  public static JPanel fightPanel = new JPanel();

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
    } else if (buttonName.equals("next")) {
      Main.slide++;
      Main.play();
    } else if (buttonName.equals("attack")) {
      attackWindow();
      Main.you.attack();

      //should attack bring up a new window showing health and damage?
      System.out.println("you monster");

      //does not change slide, you can attack or shop again.
      Main.slide = 3;
      Main.play();
    } else if (buttonName.equals("shop")) {

      System.out.println("less gooo");
      Main.slide = 4;
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
    join = GUI.butt(menuPanel, "next", 25, 25, 25, 25);
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
    next = GUI.butt(introPanel, "next", 25, 25, 25, 25);
    next.setBackground(Color.YELLOW);
    next.setForeground(Color.BLACK);
    next.addActionListener(new GUI());
  }

  public static void Fight() {
    //Gridlayout(rows, columns, spacing between rows, spacing between columns)
    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    fightPanel = GUI.panel(mainFrame, 500, 500);
    fightPanel.setLayout(OneByOne);
    fightPanel.setBackground(Color.green);

    ImageIcon icon = new ImageIcon("Images/cute.png");
    image(fightPanel, icon, 10, 10, 10, 10);

    // /

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
  }

  public static void attackWindow() {

    GridLayout OneByOne = new GridLayout(0, 2, 0, 10);
    JFrame attackFrame = new JFrame();


    menuPanel = GUI.panel(attackFrame, 250, 250);
    menuPanel.setLayout(OneByOne);
    menuPanel.setBackground(Color.green);

    //set titles
    GUI.labl(menuPanel, "You", 10, 25, 50, 10);
    GUI.labl(menuPanel, "Bear", 10, 25, 50, 10);

    GUI.labl(menuPanel, "Took 1 damage", 10, 25, 50, 10);
    GUI.labl(menuPanel, "Took " + Main.you.getDamage() + " damage", 10, 25, 50, 10);

    GUI.labl(menuPanel, "Health: " + Main.you.getHealth(), 10, 25, 50, 10);
    GUI.labl(menuPanel, "Health: " + Main.you.getBearHealth(), 10, 25, 50, 10);

    

    // image(panel, icon, 10, 120, 250, 250);
    // GUI.image(panel, icon, 100, 120, 250, 250);
  }
}