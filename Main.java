import javax.swing.*;
import java.awt.*;

class Main {

  //The game will switch between panels using a variable called slide.
  public static int slide = new Integer(1);

  //creating the player instance
  public static Player you = new Player(30);

  //the initilizaiton of the game.
  public static void main(String[] args) {

    // calls upon play once to initialize. play requires no parameters which is why it is prefered over main
    play();

  }

  public static void play() {

    //a switch case to navigate the panels

    //every panel switching button should change slide and call upon play.
    switch (slide) {
      case 1:
        //the menu slide, where the player can choose cheats and start of game

        GUI.Menu();
        break;
      case 2:
        //the intro  slide, tells the beginning fo the story

        GUI.Intro();
        break;
      case 3:
        //the fight slide, ability to attack or go to the shop, sets invisible incase you meet and end condition
        GUI.Fight();
        break;
      case 4:
        //the shop slide, can buy health or damage before returning to fight
        
        GUI.shop();
        break;
      case 5:
        //the losing slide, shows when you die, you can play again from teh beginning
        
        GUI.lose();
        break;
      case 6:
        //the king end slide, if you choose to refuse the bears offer, this is one of three endings
        
        GUI.KingEnd();
        break;
      case 7:
        //the bear end slide, if you choose to join the bear, this is one of three endings

        GUI.BearEnd();
        break;
      case 8:
        //the choice slide, as you are about to kill the bear it wants you to join it.

        GUI.Choice();
        break;
      case 9:
        //the end slide, you have finished the game and are given the option to play again.
        
        GUI.end();
        break;
      case 10:
        //the both lose slide, this is the secret ending of the three. It is very hard to get. The sad ending

        GUI.BothLose();
        break;
      case 11:
        //The difficulty menu

        GUI.Difficulty();
        break;
      default:
        //This simply should never be called. The println is very useful for finding a specific bug in this switch case.
        
        System.out.println("default was called in play() this should not have happened");
        break;
    }

  }

}