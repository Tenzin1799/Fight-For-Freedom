package Model.Weapons;

public class Weapon {
    private String name;
    private int damage;
    private int price;
    private int hitChance;

    public Weapon(String name, int dmg, int price, int hitChance){
        this.name = name;
        this.damage = dmg;
        this.price = price;
        this.hitChance = hitChance;
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
}
