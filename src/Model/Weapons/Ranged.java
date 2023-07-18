package Model.Weapons;

public class Ranged extends Weapon{
    public Ranged(String name, int dmg, int price, int hitChance) {
        super(name, dmg, price, hitChance);
    }

    // random number between 1-100;
        // if number is equal or less than hitChance,
            //hit
        // else
            // miss
}
