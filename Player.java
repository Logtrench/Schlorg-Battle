public class Player {

  // initilization of player properties
  private int health = 10;
  private int damage = 2;
  private int gold = 5;
  private int bearHealth = 30;
  private int bearDamage = -1;

  // This parameter is for setting the difficulty
  private int setBearHealth = 0;

  // The constructor, if player doesn't choose difficulty, the constructor will be
  // default (30 bearHealth);
  public Player(int bearHealth) {
    this.setBearHealth = bearHealth;
  }

  // the attack method
  public void attack() {
    // bear damage is random and should be from 0-4 (very rarely 4)
    bearDamage = (int) (Math.random() * 4);

    // change the values of player and bear health
    this.bearHealth -= this.damage;
    this.health -= this.bearDamage;

    // check if any or both the user and bear died to switch the panel.
    if (health <= 0 && bearHealth <= 0) {
      GUI.fightPanel.setVisible(false);
      Main.slide = 10;

      // setting the ending for scoreboard
      Main.ending = "The Sad Ending";
    } else if (health <= 0) {
      GUI.fightPanel.setVisible(false);
      Main.slide = 5;
    } else if (bearHealth <= 0) {
      GUI.fightPanel.setVisible(false);
      Main.slide = 8;
    }

  }

  // get bear damage, useful for calculating the gold intake
  public int getBearDamage() {
    return bearDamage;
  }

  // good for setting difficulty
  public void setDifficultyHealth(int health) {
    this.setBearHealth = health;
    this.bearHealth = health;
  }

  // get health, useful in shop and fight panel
  public int getHealth() {
    return this.health;
  }

  // get bear health, useful in fight panel
  public int getBearHealth() {
    return this.bearHealth;
  }

  // get damage, good for fight and shop panel
  public int getDamage() {
    return this.damage;
  }

  // set health, good for cheats
  public void setHealth(int x) {
    this.health = x;
  }

  // set damage, good for cheats
  public void setDamage(int x) {
    this.damage = x;
  }

  // get gold, useful in shop panel
  public int getGold() {
    return this.gold;
  }

  // add gold, for earning income when fighting
  public void addGold(int x) {
    this.gold += x;
  }

  // buy damage function, makes buying damage easy in shop
  public void buyDamage() {
    if (gold >= 1) {
      damage += 1;
      gold -= 1;
    }
  }

  // buy health function, makes buying health easy in shop
  public void buyHealth() {
    if (gold >= 5) {
      health += 3;
      gold -= 5;
    }
  }

  // reset method, used in 3 places but a lot of lines, so a method makes it very
  // clean
  public void reset() {
    // resetting gold, damage, health, bear damage, bearHealth, cheatToggle, and
    // cheat
    gold = 5;
    health = 10;
    damage = 2;
    bearHealth = setBearHealth;
    Main.rounds = 0;

    // used as a UI check so must be reset again.
    bearDamage = -1;

    GUI.toggle = 1;
    GUI.cheat = "disabled!";
    Main.username = "";
  }

  // the cheat method
  public void cheat(int x) {
    // x will always be the toggle integer.

    // if toggle is -1, enable cheats
    if (x == -1) {
      GUI.menuPanel.setVisible(false);
      damage = 999;
      gold = 999;
      health = 999;
      GUI.cheat = "enabled!";
      Main.play();
    }
    // if toggle is 1, reset
    else if (x == 1) {
      GUI.menuPanel.setVisible(false);
      reset();
      GUI.cheat = "disabled!";
      Main.play();
    }
  }
}