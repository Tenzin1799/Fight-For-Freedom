package Model.Items;

import Model.Characters.Fighter;

public class HealthPot extends Item{

    public HealthPot(String name, int booster, int amount, int price) {
        super(name, booster, amount, price);
    }

    public void useItem(Fighter person) {
        person.setHP(person.getHP()+booster);
    }
}
