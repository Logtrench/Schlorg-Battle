import javax.swing.*;
import java.awt.*;

class Main {

  // The way in which the game knows which panel to be on.
  public static int slide = new Integer(1);
  public static Player you = new Player();

  // The over all game within a loop
  public static void main(String[] args) {

    // if user wants to play again, play, if not, exit
    if (again()) {
      play();
    } else {
      exit();
    }
    // loop all above

  }

  public static boolean again() {

    // TO be filled in, atm it is always true;
    return true;

  }

  public static void play() {

    // a clean navigation of every panel. should call each panel after each other to
    // show the flow fo the game. (with ifs and whiles to find out where the use
    // wants to go, such as the shop)
    switch (slide) {
      case 1:
        // slide
        GUI.defeatPanel.setVisible(false);
        GUI.endPanel.setVisible(false);

        GUI.Menu();
        break;
      case 2:
        GUI.menuPanel.setVisible(false);
        GUI.defeatPanel.setVisible(false);
        GUI.endPanel.setVisible(false);

        // introPanel.setVisible(true);
        // slide 2
        GUI.Intro();
        break;
      case 3:
        GUI.introPanel.setVisible(false);

        // set other stuff like shop to false.
        // slide 3
        GUI.Fight();
        break;
      case 4:
        GUI.fightPanel.setVisible(false);
        GUI.shop();
        // only increase damage and increase health
        break;
      case 5:
        GUI.introPanel.setVisible(false);
        GUI.fightPanel.setVisible(false);
        // GUI.BearWin();
        GUI.lose();
        break;
      case 6:
        // slide 6
        GUI.choicePanel.setVisible(false);
        GUI.KingEnd();
        break;
      case 7:
        // slide 7
        GUI.choicePanel.setVisible(false);
        GUI.BearEnd();
        break;
      case 8:
        // slide 8
        GUI.fightPanel.setVisible(false);
        GUI.Choice();
        break;
      case 9:
        GUI.joinPanel.setVisible(false);
        GUI.refusePanel.setVisible(false);
        GUI.end();
        break;
      default:
        System.out.println("default was called in play() this should not have happened");
        break;

    }

  }

  public static void exit() {
    // simply print the exit message and exit the system.
    System.out.println("byeee mofo");
    System.exit(0);

  }

}

/*
 * manifesto sitrng bitte = please / your're welcome scheisse du mensch du
 * dankeschön = thankyou very much bitteschön = bitte very much moutarde =
 * mustard indeed
 * 
 */