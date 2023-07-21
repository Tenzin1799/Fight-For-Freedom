package Model;

import Model.Characters.Fighter;
import Model.Characters.Player;
import Model.Items.HealthPot;
import Model.Items.Item;
import Model.Items.StaminaPot;
import Model.Weapons.Melee;
import Model.Weapons.Ranged;
import Model.Weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

public class gameModel {
    //  TOOLS
    private boolean visitedShop = false;
    private final int NO_MONEY = 0;

    // EMPTY HP AND STAMINA CHOOSER
    private final int NO_STAMINA = 0;
    private final int NO_HP = 0;
    private final int MELEE_CHOICE = 0;
    private final int RANGED_CHOICE = 1;
    private final int HEALTH_POT_CHOICE = 0;
    private final int STAMINA_POT_CHOICE = 1;
    private final int SMALL_CHOICE = 0;
    private final int MEDIUM_CHOICE = 1;
    private final int BIG_CHOICE = 2;

    // HEALTH POTS
    private HealthPot hpSmall = new HealthPot("Elixir of Nurture", 20, 0, 20);
    private HealthPot hpMedium = new HealthPot("Elixir of Life", 45, 0, 40);
    private HealthPot hpBig = new HealthPot("Elixir of The Gods", 75, 0, 70);
    private StaminaPot staminaSmall = new StaminaPot("Energy Drink", 20, 0, 20);
    private StaminaPot staminaMedium = new StaminaPot("Adrenaline Acid", 50, 0, 40);
    private StaminaPot staminaBig = new StaminaPot("Liquid NITRO-9000", 100, 0, 70);

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
            50, 15);
    private Weapon shotGun = new Ranged("Sawed-Off Shot Gun", 80, 200,
            80, 25);
    private Weapon energyRifle = new Ranged("Energy Rifle", 150, 800,
            90, 40);
    private int missedRange = 100;

    // IDK YET
    private List<List<Item>> playerInventory = new ArrayList<>();
    private List<Item> playerHealthPotions = new ArrayList<>();
    private List<Item> playerStaminaPotions = new ArrayList<>();
    private List<Weapon> playerWeapons = new ArrayList<>(2);
    private List<List<Item>> testNPCInventory = new ArrayList<>();
    private List<Weapon> testNPCWeapons = new ArrayList<>();
    private List<Item> testNPCPotions = new ArrayList<>();

    //NEEDED FOR ENEMY COMBAT
    private int enemyInitialChoice = 1;    // CHANGE TO 2 LATER TO USE ITEMS FOR ENEMY
    // (if they should be allowed to use items)
    // (you need to add items to their inventory if you do this)
    private int enemyChoice;

    // CHARACTERS
    private final int FULL_HP = 100;
    private final int FULL_STAMINA = 150;
    private Fighter p1 = new Player("Tenzin", FULL_HP, FULL_STAMINA,
            30, playerInventory, playerWeapons);
    private int basicStaminaRegen = 25;
    private Fighter testNPC = new Fighter("Chump", 50, 200, testNPCInventory, testNPCWeapons);
    private Fighter shopKeeper = new Fighter("The Bloated One");


//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////
    public void gameModel(){}

    public int getFullHP(){
        return FULL_HP;
    }

    public int getFullStamina(){
        return FULL_STAMINA;
    }

    public int getSMALL_CHOICE() {
        return SMALL_CHOICE;
    }

    public int getMEDIUM_CHOICE() {
        return MEDIUM_CHOICE;
    }

    public int getBIG_CHOICE() {
        return BIG_CHOICE;
    }

    public int getNoStamina() {
        return NO_STAMINA;
    }

    public int getNoHP() {
        return NO_HP;
    }

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

    public StaminaPot getStaminaSmall() {
        return staminaSmall;
    }

    public StaminaPot getStaminaMedium() {
        return staminaMedium;
    }

    public StaminaPot getStaminaBig() {
        return staminaBig;
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

    public List<Weapon> getPlayerWeapons() {
        return playerWeapons;
    }

    public List<List<Item>> getTestNPCInventory() {
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

    public Fighter getShopKeeper(){return shopKeeper;}

    public int getCounterHitDamage(){
        return counterHitDamage;
    }

    public int getBasicStaminaRegen() {
        return basicStaminaRegen;
    }

    public int getEnemyInitialChoice() {
        return enemyInitialChoice;
    }

    public int getEnemyChoice() {
        return enemyChoice;
    }

    public void setEnemyChoice(int enemyChoice) {
        this.enemyChoice = enemyChoice;
    }

    public int getMELEE_CHOICE() {
        return MELEE_CHOICE;
    }

    public int getRANGED_CHOICE() {
        return RANGED_CHOICE;
    }

    public int getMissedRange() {
        return missedRange;
    }

    public int getHEALTH_POT_CHOICE() {
        return HEALTH_POT_CHOICE;
    }

    public int getSTAMINA_POT_CHOICE() {
        return STAMINA_POT_CHOICE;
    }

    public List<Item> getTestNPCPotions() {
        return testNPCPotions;
    }

    public List<Item> getPlayerStaminaPotions() {
        return playerStaminaPotions;
    }

    public List<Item> getPlayerHealthPotions() {
        return playerHealthPotions;
    }

    public boolean getVisitedShop() {
        return visitedShop;
    }

    public void setVisitedShop(boolean visitedShop) {
        this.visitedShop = visitedShop;
    }

    public int getNO_MONEY() {
        return NO_MONEY;
    }
}
