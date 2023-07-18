package Model;

import Model.Characters.Fighter;
import Model.Characters.Player;
import Model.Items.HealthPot;
import Model.Items.Item;
import Model.Weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

public class gameModel {
    private List<Item> playerInventory = new ArrayList<>();
    private List<Weapon> playerWeapons = new ArrayList<>();
    private List<Item> testNPCInventory = new ArrayList<>();
    private List<Weapon> testNPCWeapons = new ArrayList<>();
    private HealthPot hpSmall = new HealthPot("Elixir of Life", 20, 0);
    private HealthPot hpMedium = new HealthPot("Elixir of Life", 45, 0);
    private HealthPot hpBig = new HealthPot("Elixir of Life", 75, 0);
    private Weapon woodSword = new Weapon("Oak Sword", 20, 50);

    private Fighter p1 = new Player("Tenzin", 200, 150,
            30, playerInventory, playerWeapons);
    private Fighter testNPC = new Player("Goliath", 500, 300,
            100, testNPCInventory, testNPCWeapons);


    public void gameModel(){}

    public Fighter getPlayer(){
        return p1;
    }

    public Fighter getNPC(){
        return testNPC;
    }
}
