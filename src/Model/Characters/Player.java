package Model.Characters;

import Model.Characters.Fighter;
import Model.Items.Item;
import Model.Weapons.Weapon;

import java.util.List;

public class Player extends Fighter {
    private int money;
    public Player(String name, int hp, int stamina, int money, List<Item> inventory, List<Weapon> weapons) {
        super(name, hp, stamina, inventory, weapons);
        this.money = money;
    }

    public Player(){}

    public void setMoney(int money){
        this.money = money;
    }

    public int getMoney(){
        return money;
    }
}
