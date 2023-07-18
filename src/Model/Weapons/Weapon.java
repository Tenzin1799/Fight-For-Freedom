package Model.Weapons;

public class Weapon {
    private String name;
    private int damage;
    private int price;
    private int hitChance;
    private int staminaUsage;

    public Weapon(String name, int dmg, int price, int hitChance, int staminaUsage){
        this.name = name;
        this.damage = dmg;
        this.price = price;
        this.hitChance = hitChance;
        this.staminaUsage = staminaUsage;
    }

    public String toString(){
        return name;
    }

    public int getHitChance(){
        return hitChance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStaminaUsage() {
        return staminaUsage;
    }
}
