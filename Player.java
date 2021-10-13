public class Player {

  private int health = 10;
  private int damage = 2;

  private int bearHealth = 30;
  private int bearDamage = 1;

  public static void main(String[] args) {

  }

  public void attack() {
    this.bearHealth -= this.damage;
    this.health -= this.bearDamage;
  }
  
  public int getHealth() {
    return this.health;
  }

  public int getBearHealth() {
    return this.bearHealth;
  }

  public int getDamage() {
    return this.damage;
  }

  public void setHealth(int x) {
    this.health += x;
  }

  public void setDamage(int x) {
    this.damage += x;
  }

}