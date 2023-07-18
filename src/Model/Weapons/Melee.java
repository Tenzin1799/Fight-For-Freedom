package Model.Weapons;

public class Melee extends Weapon{
    public Melee(String name, int dmg, int price, int hitChance, int staminaUsage) {
        super(name, dmg, price, hitChance, staminaUsage);
    }

    // random number between 1-10
        // if number is equal or higher than hitChance
            // hit, counter-attack, fighter loses 10 hp
        // else
            // hit, no counter from enemy
}
