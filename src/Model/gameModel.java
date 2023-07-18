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
    // HEALTH POTS
    private HealthPot hpSmall = new HealthPot("Elixir of Life", 20, 0);
    private HealthPot hpMedium = new HealthPot("Elixir of Life", 45, 0);
    private HealthPot hpBig = new HealthPot("Elixir of Life", 75, 0);
    // MELEE WEAPONS
    private Weapon unarmed = new Melee("Fists", 10, 0,
            1, 10);
    private Weapon woodSword = new Melee("Wood Practice Sword", 20, 20,
            3, 15);
    private Weapon steelSword = new Melee("Bent Blade", 30, 75,
            5, 20);
    private Weapon warHammer = new Melee("Electric War Hammer", 50, 150,
            7, 35);
    private Weapon energySword = new Melee("Energy Sword", 100, 500,
            9, 15);
    private int counterHitDamage = 10;
    // RANGED WEAPONS
    private Weapon rocks = new Ranged("Rocks", 10, 0,
            10, 10);
    private Weapon slingShot = new Ranged("Sling Shot", 15, 15,
            25, 15);
    private Weapon pistol = new Ranged("Blaster Pistol", 35,  80,
            40, 15);
    private Weapon shotGun = new Ranged("Sawed-Off Shot Gun", 80, 200,
            70, 25);
    private Weapon energyRifle = new Ranged("Energy Rifle", 150, 800,
            90, 40);
    // IDK YET
    private List<Item> playerInventory = new ArrayList<>();
    private List<Weapon> playerWeapons = new ArrayList<>(2);
    private List<Item> testNPCInventory = new ArrayList<>();
    private List<Weapon> testNPCWeapons = new ArrayList<>();
    // CHARACTERS
    private Fighter p1 = new Player("Tenzin", 100, 150,
            30, playerInventory, playerWeapons);
    private int basicStaminaRegen = 25;
    private Fighter testNPC = new Player("Chump", 50, 200,
            100, testNPCInventory, testNPCWeapons);
    private int enemyMaxWeaponsIndex = 1;


    public void gameModel(){}

    public Fighter getPlayer(){
        return p1;
    }

    public Fighter getNPC(){
        return testNPC;
    }

    public HealthPot getHpSmall() {
        return hpSmall;
    }

    public HealthPot getHpMedium() {
        return hpMedium;
    }

    public HealthPot getHpBig() {
        return hpBig;
    }

    public Weapon getUnarmed() {
        return unarmed;
    }

    public Weapon getWoodSword() {
        return woodSword;
    }

    public Weapon getSteelSword() {
        return steelSword;
    }

    public Weapon getWarHammer() {
        return warHammer;
    }

    public Weapon getEnergySword() {
        return energySword;
    }

    public Weapon getRocks() {
        return rocks;
    }

    public Weapon getSlingShot() {
        return slingShot;
    }

    public Weapon getPistol() {
        return pistol;
    }

    public Weapon getShotGun() {
        return shotGun;
    }

    public Weapon getEnergyRifle() {
        return energyRifle;
    }

    public List<Item> getPlayerInventory() {
        return playerInventory;
    }

    public List<Weapon> getPlayerWeapons() {
        return playerWeapons;
    }

    public List<Item> getTestNPCInventory() {
        return testNPCInventory;
    }

    public List<Weapon> getTestNPCWeapons() {
        return testNPCWeapons;
    }

    public Fighter getP1() {
        return p1;
    }

    public Fighter getTestNPC() {
        return testNPC;
    }

    public int getCounterHitDamage(){
        return counterHitDamage;
    }

    public int getBasicStaminaRegen() {
        return basicStaminaRegen;
    }

    public int getEnemyMaxWeaponsIndex() {
        return enemyMaxWeaponsIndex;
    }
}
