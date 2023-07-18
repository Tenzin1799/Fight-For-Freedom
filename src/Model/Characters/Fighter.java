package Model.Characters;

import Model.Items.Item;
import Model.Weapons.Weapon;
import java.util.List;

public class Fighter {
    private String name;
    private int HP;
    private int stamina;
    private List<Item> inventory;
    private List<Weapon> weapons;

    public Fighter(){}

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public Fighter(String name, int hp, int stamina, List<Item> inventory, List<Weapon> weapons){
        this.name = name;
        HP = hp;
        this.stamina = stamina;
        this.inventory = inventory;
        this.weapons = weapons;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public void setName(String name){
        this.name = name;
    }

}
