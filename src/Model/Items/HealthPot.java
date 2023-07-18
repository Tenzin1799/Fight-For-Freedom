package Model.Items;

import Model.Characters.Fighter;

public class HealthPot extends Item{

    public HealthPot(String name, int booster, int amount) {
        super(name, booster, amount);
    }

    public void useItem(Fighter person) {
        person.setHP(person.getHP()+booster);
    }
}
