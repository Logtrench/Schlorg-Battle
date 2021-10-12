import javax.swing.*;
import java.awt.*;

class Main {
  public static void main(String[] args) {
    if (again()) {
      play();
    } else {
      exit();
    }
  }

  public static boolean again() {

    return true;

  }

  public static void play() {

    GridLayout OneByOne = new GridLayout(0, 1, 3, 10);

    JPanel panel = new JPanel();
    ImageIcon icon = new ImageIcon("images/bear.png");

    panel = GUI.panel(250, 250);
    panel.setLayout(OneByOne);
    panel.setBackground(Color.green);

    GUI.labl(panel, "Battle for Schlorg", 10, 25, 50, 10);

    JButton join = new JButton();
    join = GUI.butt(panel, "join", 25, 25, 25, 25);
    join.setBackground(Color.YELLOW);
    join.setForeground(Color.BLACK);
    join.addActionListener(new GUI());
    JButton exit = new JButton();
    exit = GUI.butt(panel, "exit", 25, 25, 25, 25);
    exit.addActionListener(new GUI());

    // image(panel, icon, 10, 120, 250, 250);
    // GUI.image(panel, icon, 100, 120, 250, 250);

    String[] ba = { "1", "2" };
    // Inputs.main(ba);

    System.out.println("yayy");
  }

  public static void exit() {
    System.out.println("byeee mofo");
  }

  public static String input(String question) {

    return "baba";
  }

}

/*
 * manifesto sitrng bitte = please / your're welcome scheisse du mensch du
 * dankeschön = thankyou very much bitteschön = bitte very much moutarde =
 * mustard indeed
 * 
 */