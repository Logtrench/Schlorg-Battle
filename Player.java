public class Player {

  private int health = 10;
  private int damage = 2;
  private int gold = 5;
  private int bearHealth = 30;
  private int bearDamage = 0;

  public static void main(String[] args) {

  }

  public void attack() {
    bearDamage = (int) (Math.random() * 4);
    this.bearHealth -= this.damage;
    this.health -= this.bearDamage;

    if (health <= 0 && bearHealth <= 0) {
      Main.slide = 10;
    } else if (health <= 0) {
      Main.slide = 5;
    } else if (bearHealth <= 0) {
      Main.slide = 8;
    }

  }

  public int getBearDamage() {
    return bearDamage;
  }

  public int getHealth() {
    return this.health;
  }

  public int getBearHealth() {
    return this.bearHealth;
  }
  
  public void setBearHealth(int x){
    this.bearHealth = x;
  }

  public int getDamage() {
    return this.damage;
  }

  public void setHealth(int x) {
    this.health = x;
  }

  public void setDamage(int x) {
    this.damage = x;
  }

  public int getGold() {
    return this.gold;
  }

  public void setGold(int x) {
    this.gold = x;
  }
  public void addGold(int x) {
    this.gold += x;
  }

  public void buyDamage() {
    if (gold >= 1) {
      damage += 1;
      gold -= 1;
      System.out.println("damage: " + damage);
    }
  }

  public void buyHealth() {
    if (gold >= 5) {
      health += 3;
      gold -= 5;
      System.out.println("Health: " + health);
    }
  }
}