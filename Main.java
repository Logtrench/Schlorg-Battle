import javax.swing.*;
import java.awt.*;

class Main {
  
  //The over all game within a loop
  public static void main(String[] args) {
    
    //if user wants to play again, play, if not, exit
    if (again()) {
      play();
    } else {
      exit();
    }
    //loop all above
    
  }

  public static boolean again() {

    //TO be filled in, atm it is always true;
    return true;

  }

  public static void play() {

    //a clean navigation of every panel. should call each panel after each other to show the flow fo the game. (with ifs and whiles to find out where the use wants to go, such as the shop)
    
    GUI.Menu();
  }

  public static void exit() {
    
    //simply print the exit message and exit the system.
    System.out.println("byeee mofo");
    System.exit(0);

  }

  public static String input(String question) {
      //Will delete this later, inputs has been replaced by GUI I think.
    
    return "baba";
  }

}

/*
 * manifesto sitrng bitte = please / your're welcome scheisse du mensch du
 * dankeschön = thankyou very much bitteschön = bitte very much moutarde =
 * mustard indeed
 * 
 */