package Model;

import Model.Characters.Fighter;
import Model.Characters.Player;
import Model.Items.HealthPot;
import Model.Items.Item;
import Model.Weapons.Melee;
import Model.Weapons.Ranged;
import Model.Weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

public class gameModel {
    private List<Item> playerInventory = new ArrayList<>();
    private List<Weapon> playerWeapons = new ArrayList<>();
    private List<Item> testNPCInventory = new ArrayList<>();
    private List<Weapon> testNPCWeapons = new ArrayList<>();
    // HEALTH POTS
    private HealthPot hpSmall = new HealthPot("Elixir of Life", 20, 0);
    private HealthPot hpMedium = new HealthPot("Elixir of Life", 45, 0);
    private HealthPot hpBig = new HealthPot("Elixir of Life", 75, 0);
    // MELEE WEAPONS
    private Weapon unarmed = new Melee("Fists", 10, 0, 1);
    private Weapon woodSword = new Melee("Wood Practice Sword", 20, 20, 3);
    private Weapon steelSword = new Melee("Bent Blade", 30, 75, 5);
    private Weapon warHammer = new Melee("Electric War Hammer", 50, 150, 7);
    private Weapon energySword = new Melee("Energy Sword", 100, 500, 9);
    // RANGED WEAPONS
    private Weapon rocks = new Ranged("Rocks", 10, 0, 10);
    private Weapon slingShot = new Ranged("Sling Shot", 15, 15, 25);
    private Weapon pistol = new Ranged("Blaster Pistol", 35,  80, 40);
    private Weapon shotGun = new Ranged("Sawed-Off Shot Gun", 80, 200, 70);
    private Weapon energyRifle = new Ranged("Energy Rifle", 150, 800, 90);



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
