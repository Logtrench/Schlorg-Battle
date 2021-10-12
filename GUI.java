import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.event.*;

public class GUI implements ActionListener {
  
  //A lot of these variables were for learning GUI, they will be replaced with needed variabes
  private static JLabel success;
  private static JTextField userText;
  private static JTextField passwordText;
  private static ImageIcon icon;
  private static JLabel label;


  //The frame to be used by All
  public static JFrame mainFrame = new JFrame();

  //All the panels that ned to be accessed by the button actions.
  public static JPanel menuPanel = new JPanel();
  public static JPanel introPanel = new JPanel();

  public static void main(String[] args) {
    /*
     * JPanel panel = new JPanel(); JFrame frame = new JFrame(); frame.setSize(500,
     * 500); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     * frame.setVisible(true); frame.add(panel);
     */
    
    
    //creation of the panel and its parameters
    JPanel panel = new JPanel();
    panel = panel(mainFrame, 500, 500);


    //creation of an image (to be downloaded on main branch)
    icon = new ImageIcon("images/bear.png");
    image(panel, icon, 10, 120, 250, 250);

    // label = new JLabel(icon);
    // label.setBounds(10, 120, 80, 25);
    // panel.add(label);

    panel.setLayout(null);

    labl(panel, "User", 10, 20, 80, 25);
    userText = text(panel, 100, 20, 165, 25);

    labl(panel, "Password", 10, 50, 80, 25);
    passwordText = text(panel, 100, 50, 165, 25);

    JButton button1 = new JButton();
    button1 = butt(panel, "log in", 10, 80, 80, 25);
    button1.setVisible(true);
    button1.addActionListener(new GUI());
    success = new JLabel("");
    success.setBounds(10, 110, 300, 25);
    panel.add(success);

  }

  //easy panel creator
  public static JPanel panel(JFrame frame, int x, int y) {
    JPanel panel = new JPanel();
    frame.setSize(x, y);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.add(panel);
    return panel;
  }

  //easy label creator
  public static void labl(JPanel panel, String message, int x, int y, int zx, int zy) {
    JLabel label = new JLabel(message,SwingConstants.CENTER);
    label.setBounds(x, y, zx, zy);
    panel.add(label);
  }

  //easy image creator
  public static void image(JPanel panel, ImageIcon icon, int x, int y, int zx, int zy) {
    JLabel label = new JLabel(icon);
    label.setBounds(x, y, zx, zy);
    panel.add(label);
  }

  //Easy input text creator
  public static JTextField text(JPanel panel, int x, int y, int zx, int zy) {
    JTextField userText = new JTextField(20);
    userText.setBounds(x, y, zx, zy);
    panel.add(userText);
    return userText;
  }

  //easy button creator
  public static JButton butt(JPanel panel, String message, int x, int y, int zx, int zy) {
    JButton button = new JButton(message);
    button.setBounds(x, y, zx, zy);
    panel.add(button);
    return button;
  }


  //how the program deals with inputs from buttons
  @Override
  public void actionPerformed(ActionEvent e) {
    String buttonName = e.getActionCommand();
    if (buttonName.equals("join")) {
      System.out.println("JOINING");
      Main.slide = 2;
      Main.play();
    } else if (buttonName.equals("exit")) {
      Main.exit();
      System.exit(0);
    } else if (buttonName.equals("next")) {
      //should I make an array of panel methods
      
      Main.slide++;
      Main.play();
    } else {
      System.out.println("AHHH");
    }
  }

  public static void Menu() {

    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    
    ImageIcon icon = new ImageIcon("images/bear.png");

    menuPanel = GUI.panel(mainFrame, 250, 250);
    menuPanel.setLayout(OneByOne);
    menuPanel.setBackground(Color.green);

    GUI.labl(menuPanel, "Battle for Schlorg", 10, 25, 50, 10);

    JButton join = new JButton();
    join = GUI.butt(menuPanel, "join", 25, 25, 25, 25);
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

    GUI.labl(introPanel, "You\'ve been tasked by the king "
, 10, 25, 50, 10);
GUI.labl(introPanel, "to scout out the forest in order to burn it down for farmland. "
, 10, 25, 50, 10);
GUI.labl(introPanel, "On the way, you meet a bear, a magical bear which is the guardian"
, 10, 25, 50, 10);
GUI.labl(introPanel, "of the forest. You must defeat the bear to fulfill your mission."
, 10, 25, 50, 10);

// / 

    JButton join = new JButton();
    join = GUI.butt(introPanel, "next", 25, 25, 25, 25);
    join.setBackground(Color.YELLOW);
    join.setForeground(Color.BLACK);
    join.addActionListener(new GUI());
  }
}

/*
 * 
 * public class GUI implements ActionListener{ private int count = 0; private
 * JFrame frame; private JPanel panel; private JLabel label; private JLabel
 * label2; private ImageIcon icon;
 * 
 * 
 * //trying gui with image public GUI(String image, String message, String
 * title) { //creating new objects of type frame and panel and button frame =
 * new JFrame(); icon = new ImageIcon(image); label = new JLabel(icon); label2 =
 * new JLabel(message);
 * 
 * 
 * panel = new JPanel();
 * 
 * //setting border of panel ()
 * panel.setBorder(BorderFactory.createEmptyBorder(100, 200, 50, 70));
 * 
 * //making layout, aka panel.setLayout(new GridLayout(0, 1));
 * 
 * 
 * //add panel to frame frame.add(panel, BorderLayout.CENTER);
 * 
 * //add label panel.add(label); panel.add(label2);
 * 
 * //set closing behaviour frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 * 
 * //title frame.setTitle(title);
 * 
 * //set window to match certain size frame.pack();
 * 
 * //make it visible. frame.setVisible(true);
 * 
 * 
 * }
 * 
 * 
 * 
 * @Override public void actionPerformed(ActionEvent e) { count++;
 * label.setText("Number of clicks: " + count); }
 * 
 * 
 * public static void main (String[] args) { new
 * GUI("majestic_bear.jpg","hello there matey", "test");
 * 
 * 
 * }
 * 
 * 
 * }
 */