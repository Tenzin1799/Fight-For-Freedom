package Model.Items;

import Model.Characters.Fighter;

public class StaminaPot extends Item{

    public StaminaPot(String name, int booster, int amount, int price) {
        super(name, booster, amount, price);
    }

    public void useItem(Fighter person){
        person.setStamina(person.getStamina()+booster);
    }
}
