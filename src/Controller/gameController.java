package Controller;
import Model.*;
import Model.Characters.Fighter;
import Model.Characters.Player;
import Model.Items.HealthPot;
import Model.Items.StaminaPot;
import View.*;
import java.util.Random;
import java.util.Scanner;

public class gameController {
    private Scanner kb = new Scanner(System.in);
    private gameModel model = new gameModel();
    private gameView view = new gameView();


    public void startGame() {
        gameStarter();
        boolean moreGame = true;    // set to false at the end of game
        boolean playerAlive = true;    // set to false if player dies
        boolean playAgain = true;   // set to false is player doesn't want to play again
        boolean keepPlaying = true; // set to false if user does not wish to continue playing after discretion
//        keepPlaying = introToGame();
        if (keepPlaying) {
            while (playAgain) {
                while (moreGame && playerAlive) {
//                    preGame();
                    chapterOne();

                    moreGame = false;
                }
                view.displayPlayAgain();
                view.lineBreak();
                switch (getUserInputTwoOptions()){
                    case "1":
                        moreGame = true;
                        playerAlive = true;
                        break;
                    case "2":
                        playAgain = false;
                }
            }
        }
//        shop(model.getVisitedShop());                    // SHOP METHOD
//        combat(model.getPlayer(), model.getNPC());       // COMBAT METHOD
//        playerAlive = combat(model.getPlayer(), model.getNPC());  // example combat

    }

    // probably will change this, but for now it just loads the player with empty inventory and base weapons
    public void gameStarter(){
        model.getPlayer().getWeapons().add(model.getUnarmed());
        model.getPlayer().getWeapons().add(model.getRocks());
        model.getPlayer().getInventory().add(model.getPlayerHealthPotions());
        model.getPlayer().getInventory().get(model.getHEALTH_POT_CHOICE()).add(model.getHpSmall());
        model.getPlayer().getInventory().get(model.getHEALTH_POT_CHOICE()).add(model.getHpMedium());
        model.getPlayer().getInventory().get(model.getHEALTH_POT_CHOICE()).add(model.getHpBig());
        model.getPlayer().getInventory().add(model.getPlayerStaminaPotions());
        model.getPlayer().getInventory().get(model.getSTAMINA_POT_CHOICE()).add(model.getStaminaSmall());
        model.getPlayer().getInventory().get(model.getSTAMINA_POT_CHOICE()).add(model.getStaminaMedium());
        model.getPlayer().getInventory().get(model.getSTAMINA_POT_CHOICE()).add(model.getStaminaBig());
        model.getPlayer().getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getMEDIUM_CHOICE()).addAmount();
    }

    // Returns true if player wants to play after discretion is advised, if false, game is ended.
    public boolean introToGame(){
        view.gameStartLogo();
        view.lineBreak();
        next_input_lineBreak();
        view.beginGameIntro();
        view.displayKeepPlaying();
        view.lineBreak();
        switch (getUserInputTwoOptions()){
            case "1":
                return true;
            case "2":
                return false;
        }
        return false;
    }


    // just gets users name
    public void preGame(){
        view.bigDivider();
        view.setUpGame();
        getUsersName();
        view.bigDivider();
    }


    public void chapterOne(){
        view.chapterOneLogo();
        view.lineBreak();
        next_input_lineBreak();
        view.chapterOne_1();
        view.lineBreak();
        tightenTheScrewChoice_Ch1();
    }

    public void tightenTheScrewChoice_Ch1(){
        switch(getUserInputTwoOptions()){
            case "1":
                //tightens the screw
                view.bigDivider();
                view.playerTightenedScrews_Ch1();
                view.lineBreak();
                next_input_lineBreak();
                view.bigDivider();
                view.knockAtDoor_Ch1();
                view.lineBreak();
                openDoorChoice_Ch1();
                view.lineBreak();
                break;
            case "2":
                //doesn't tighten the screw
                view.bigDivider();
                view.playerDoesNotTightenScrews_Ch1();
                view.lineBreak();
                next_input_lineBreak();
                view.bigDivider();
                view.kroblagSneaksIn_Ch1();
                view.lineBreak();
                next_input_lineBreak();
                view.bigDivider();
                view.playerSeesKroblagInShower_Ch1();
                view.lineBreak();
                kroblagSneaksInShowerChoice_Ch1();
                view.lineBreak();
                next_input_lineBreak();
        }
    }

    public void kroblagSneaksInShowerChoice_Ch1(){
        switch(getUserInputFourOptions()){
            case "1":
                view.bigDivider();
                view.screamSeeingKroblag_Ch1();
                view.kroblagPlayerToSleep_Ch1();
                break;
            case "2":
                view.bigDivider();
                view.playerSaysHelloToKroblag_Ch1();
                break;
            case "3":
                view.bigDivider();
                view.shoveKroblag_Ch1();
                break;
            case "4":
                view.bigDivider();
                view.playerSlapsSelf_Ch1();
                view.kroblagPlayerToSleep_Ch1();
        }
    }

    public void openDoorChoice_Ch1(){
        switch(getUserInputThreeOptions()){
            case "1":
                // open door right away
                view.bigDivider();
                view.playerOpensDoorRightAway_Ch1();
                view.chapterOneRevealKroblag();
                break;
            case "2":
                // ask who it is
                view.bigDivider();
                view.playerAsksForIdentity_Ch1();
                view.lineBreak();
                switch(getUserInputTwoOptions()){
                    case "1":
                        // open for 'landlord'
                        view.bigDivider();
                        view.chapterOneRevealKroblag();
                        break;
                    case "2":
                        // dont open for 'landlord'
                        view.bigDivider();
                        view.playerDoesNotOpenDoor_Ch1();
                }
                break;
            case "3":
                // dont open for stranger
                view.bigDivider();
                view.playerDoesNotOpenDoor_Ch1();
        }
    }

    public void getUsersName(){
        boolean nameCorrect = false;
        while (!nameCorrect) {
            view.getUserPlayerName();
            model.getPlayer().setName(kb.nextLine());
            view.lineBreak();
            view.nameCorrect(model.getPlayer().getName());
            view.lineBreak();
            switch(getUserInputTwoOptions()){
                case "1":
                    nameCorrect = true;
                    break;
                case "2":
                    nameCorrect = false;
            }
        }
    }

    public void shop(boolean visited){
        if (!visited){
            visitShopFirstTime();
            model.setVisitedShop(true);
        }
        else {
            view.visitShop(model.getShopKeeper().getName());
            purchaseItems();
        }
    }

    public void purchaseHealthItem(){
        boolean playerDoneBuying = false;
        // while the player is still buying, and has more money than 0, stay in loop
        while (!playerDoneBuying && ((Player)model.getPlayer()).getMoney() > model.getNO_MONEY()){
            view.displayShopPotOptions(model.getHpSmall().toString(), model.getHpSmall().getPrice(),
                    model.getHpMedium().toString(), model.getHpMedium().getPrice(),
                    model.getHpBig().toString(), model.getHpBig().getPrice(),
                    ((Player) model.getPlayer()).getMoney());
            view.lineBreak();
            switch(getUserInputFourOptions()) {
                case "1":
                    if (((Player)model.getPlayer()).getMoney() > model.getPlayer().getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getSMALL_CHOICE()).getPrice()) {
                        view.purchasedItem(model.getPlayer().getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getSMALL_CHOICE()).getName());
                        model.getPlayer().getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getSMALL_CHOICE()).addAmount();
                        ((Player)model.getPlayer()).setMoney(((Player)model.getPlayer()).getMoney() -
                                model.getPlayer().getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getSMALL_CHOICE()).getPrice());
                    } else {
                        view.notEnoughMoney();
                    }
                    break;
                case "2":
                    if (((Player)model.getPlayer()).getMoney() > model.getPlayer().getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getMEDIUM_CHOICE()).getPrice()) {
                        view.purchasedItem(model.getPlayer().getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getMEDIUM_CHOICE()).getName());                        model.getPlayer().getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getMEDIUM_CHOICE()).addAmount();
                        ((Player)model.getPlayer()).setMoney(((Player)model.getPlayer()).getMoney() -
                                model.getPlayer().getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getMEDIUM_CHOICE()).getPrice());
                    } else {
                        view.notEnoughMoney();
                    }
                    break;
                case "3":
                    if (((Player)model.getPlayer()).getMoney() > model.getPlayer().getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getBIG_CHOICE()).getPrice()) {
                        view.purchasedItem(model.getPlayer().getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getBIG_CHOICE()).getName());
                        model.getPlayer().getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getBIG_CHOICE()).addAmount();
                        ((Player)model.getPlayer()).setMoney(((Player)model.getPlayer()).getMoney() -
                                model.getPlayer().getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getBIG_CHOICE()).getPrice());
                    } else {
                        view.notEnoughMoney();
                    }
                    break;
                case "4":
                    view.backOption();
                    playerDoneBuying = true;
            }
        }
    }
    
    public void purchaseStaminaItem(){
        boolean playerDoneBuying = false;
        // while the player is still buying, and has more money than 0, stay in loop
        while (!playerDoneBuying && ((Player)model.getPlayer()).getMoney() > model.getNO_MONEY()){
            view.displayShopPotOptions(model.getStaminaSmall().toString(), model.getStaminaSmall().getPrice(),
                    model.getStaminaMedium().toString(), model.getStaminaMedium().getPrice(),
                    model.getStaminaBig().toString(), model.getStaminaBig().getPrice(),
                    ((Player) model.getPlayer()).getMoney());
            view.lineBreak();
            switch(getUserInputFourOptions()) {
                case "1":
                    if (((Player)model.getPlayer()).getMoney() > model.getPlayer().getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getSMALL_CHOICE()).getPrice()) {
                        view.purchasedItem(model.getPlayer().getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getSMALL_CHOICE()).getName());
                        model.getPlayer().getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getSMALL_CHOICE()).addAmount();
                        ((Player)model.getPlayer()).setMoney(((Player)model.getPlayer()).getMoney() -
                                model.getPlayer().getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getSMALL_CHOICE()).getPrice());
                    } else {
                        view.notEnoughMoney();
                    }
                    break;
                case "2":
                    if (((Player)model.getPlayer()).getMoney() > model.getPlayer().getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getMEDIUM_CHOICE()).getPrice()) {
                        view.purchasedItem(model.getPlayer().getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getMEDIUM_CHOICE()).getName());                        model.getPlayer().getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getMEDIUM_CHOICE()).addAmount();
                        ((Player)model.getPlayer()).setMoney(((Player)model.getPlayer()).getMoney() -
                                model.getPlayer().getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getMEDIUM_CHOICE()).getPrice());
                    } else {
                        view.notEnoughMoney();
                    }
                    break;
                case "3":
                    if (((Player)model.getPlayer()).getMoney() > model.getPlayer().getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getBIG_CHOICE()).getPrice()) {
                        view.purchasedItem(model.getPlayer().getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getBIG_CHOICE()).getName());
                        model.getPlayer().getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getBIG_CHOICE()).addAmount();
                        ((Player)model.getPlayer()).setMoney(((Player)model.getPlayer()).getMoney() -
                                model.getPlayer().getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getBIG_CHOICE()).getPrice());
                    } else {
                        view.notEnoughMoney();
                    }
                    break;
                case "4":
                    view.backOption();
                    playerDoneBuying = true;
            }
        }
    }

    public void purchaseMeleeItems(){
        boolean playerDoneBuying = false;
        while (!playerDoneBuying){
            view.displayShopSpecificCombatOptions(model.getWoodSword().getName(), model.getSteelSword().getName(),
                    model.getWarHammer().getName(), model.getEnergySword().getName(),
                    model.getWoodSword().getPrice(), model.getSteelSword().getPrice(),
                    model.getWarHammer().getPrice(), model.getEnergySword().getPrice(),
                    ((Player)model.getPlayer()).getMoney(),
                    model.getPlayer().getWeapons().get(model.getMELEE_CHOICE()).getName(), "melee");
            view.lineBreak();
            switch(getUserInputFiveOptions()){
                case "1":
                    if (((Player) model.getPlayer()).getMoney() > 
                    model.getWoodSword().getPrice()){
                        view.purchasedItem(model.getWoodSword().getName());
                        model.getPlayer().getWeapons().set(model.getMELEE_CHOICE(), model.getWoodSword());
                        ((Player) model.getPlayer()).setMoney(((Player) model.getPlayer()).getMoney()-
                                model.getWoodSword().getPrice());
                    } else {
                        view.notEnoughMoney();
                    }
                    break;
                case "2":
                    if (((Player) model.getPlayer()).getMoney() >
                            model.getSteelSword().getPrice()){
                        view.purchasedItem(model.getSteelSword().getName());
                        model.getPlayer().getWeapons().set(model.getMELEE_CHOICE(), model.getSteelSword());
                        ((Player) model.getPlayer()).setMoney(((Player) model.getPlayer()).getMoney()-
                                model.getSteelSword().getPrice());
                    } else {
                        view.notEnoughMoney();
                    }
                    break;
                case "3":
                    if (((Player) model.getPlayer()).getMoney() >
                            model.getWarHammer().getPrice()){
                        view.purchasedItem(model.getWarHammer().getName());
                        model.getPlayer().getWeapons().set(model.getMELEE_CHOICE(), model.getWarHammer());
                        ((Player) model.getPlayer()).setMoney(((Player) model.getPlayer()).getMoney()-
                                model.getWarHammer().getPrice());
                    } else {
                        view.notEnoughMoney();
                    }
                    break;
                case "4":
                    if (((Player) model.getPlayer()).getMoney() >
                            model.getEnergySword().getPrice()){
                        view.purchasedItem(model.getEnergySword().getName());
                        model.getPlayer().getWeapons().set(model.getMELEE_CHOICE(), model.getEnergySword());
                        ((Player) model.getPlayer()).setMoney(((Player) model.getPlayer()).getMoney()-
                                model.getEnergySword().getPrice());
                    } else {
                        view.notEnoughMoney();
                    }
                    break;
                case "5":
                    view.backOption();
                    playerDoneBuying = true;
            }
        }
    }
    
    public void purchaseRangedItems(){
        boolean playerDoneBuying = false;
        while (!playerDoneBuying){
            view.displayShopSpecificCombatOptions(model.getSlingShot().getName(), model.getPistol().getName(),
                    model.getShotGun().getName(), model.getEnergyRifle().getName(),
                    model.getSlingShot().getPrice(), model.getPistol().getPrice(),
                    model.getShotGun().getPrice(), model.getEnergyRifle().getPrice(),
                    ((Player)model.getPlayer()).getMoney(),
                    model.getPlayer().getWeapons().get(model.getRANGED_CHOICE()).getName(), "ranged");
            view.lineBreak();
            switch(getUserInputFiveOptions()){
                case "1":
                    if (((Player) model.getPlayer()).getMoney() >
                            model.getSlingShot().getPrice()){
                        view.purchasedItem(model.getSlingShot().getName());
                        model.getPlayer().getWeapons().set(model.getRANGED_CHOICE(), model.getSlingShot());
                        ((Player) model.getPlayer()).setMoney(((Player) model.getPlayer()).getMoney()-
                                model.getSlingShot().getPrice());
                    } else {
                        view.notEnoughMoney();
                    }
                    break;
                case "2":
                    if (((Player) model.getPlayer()).getMoney() >
                            model.getPistol().getPrice()){
                        view.purchasedItem(model.getPistol().getName());
                        model.getPlayer().getWeapons().set(model.getRANGED_CHOICE(), model.getPistol());
                        ((Player) model.getPlayer()).setMoney(((Player) model.getPlayer()).getMoney()-
                                model.getPistol().getPrice());
                    } else {
                        view.notEnoughMoney();
                    }
                    break;
                case "3":
                    if (((Player) model.getPlayer()).getMoney() >
                            model.getShotGun().getPrice()){
                        view.purchasedItem(model.getShotGun().getName());
                        model.getPlayer().getWeapons().set(model.getRANGED_CHOICE(), model.getShotGun());
                        ((Player) model.getPlayer()).setMoney(((Player) model.getPlayer()).getMoney()-
                                model.getShotGun().getPrice());
                    } else {
                        view.notEnoughMoney();
                    }
                    break;
                case "4":
                    if (((Player) model.getPlayer()).getMoney() >
                            model.getEnergyRifle().getPrice()){
                        view.purchasedItem(model.getEnergyRifle().getName());
                        model.getPlayer().getWeapons().set(model.getRANGED_CHOICE(), model.getEnergyRifle());
                        ((Player) model.getPlayer()).setMoney(((Player) model.getPlayer()).getMoney()-
                                model.getEnergyRifle().getPrice());
                    } else {
                        view.notEnoughMoney();
                    }
                    break;
                case "5":
                    view.backOption();
                    playerDoneBuying = true;
            }
        }
    }

    public void purchaseCombatItems(){
        boolean playerDoneBuying = false;
        while(!playerDoneBuying){
            view.displayShopCombatOptions();
            view.lineBreak();
            switch (getUserInputThreeOptions()){
                case "1":
                    //melee
                    purchaseMeleeItems();
                    break;
                case "2":
                    // ranged
                    purchaseRangedItems();
                    break;
                case "3":
                    // back
                    view.backOption();
                    playerDoneBuying = true;
            }
        }
    }

    public void purchaseItems(){
        boolean playerDoneBuying = false;
        while (!playerDoneBuying){
            view.displayShopOptions();
            view.lineBreak();
            switch (getUserInputFourOptions()) {
                case "1":
                    purchaseCombatItems();
                    break;
                case "2":
                    purchaseHealthItem();
                    break;
                case "3":
                    purchaseStaminaItem();
                    break;
                case "4":
                    view.leaveShop(model.getShopKeeper().getName());
                    playerDoneBuying = true;
            }
        }
    }

    public void visitShopFirstTime(){
        view.visitShopFirstTime();
        view.lineBreak();
        next_input_lineBreak();
        view.bigDivider();
        view.visitShopFirstTime2(model.getShopKeeper().getName());
        view.lineBreak();
        view.displayFirstTimeShopOptions();
        view.lineBreak();
        switch(getUserInputFourOptions()){
            case "1":
                view.bigDivider();
                view.visitShopFirstTime3_1(model.getShopKeeper().getName());
                purchaseItems();
                break;
            case "2":
                view.bigDivider();
                view.visitShopFirstTime3_2(model.getShopKeeper().getName());
                purchaseItems();
                break;
            case "3":
                view.bigDivider();
                view.visitShopFirstTime3_3(model.getShopKeeper().getName());
                purchaseItems();
                break;
            case "4":
                view.bigDivider();
                view.leaveShop(model.getShopKeeper().getName());
        }
    }

    public Boolean combat(Fighter p1, Fighter npc){
        npc.getWeapons().add(model.getWoodSword());
        npc.getWeapons().add(model.getPistol());
        view.beginCombatDialogue(p1.getName(), npc.getName());
        next_input_lineBreak();
        // while player is alive && npc is alive, add loop later
        while(p1.getHP() > model.getNoHP() &&
                npc.getHP() > model.getNoHP()) {
            view.displayStats(p1.getName(), p1.getHP(), p1.getStamina(),
                    npc.getName(), npc.getHP(), npc.getStamina());
            // PLAYER ATTACK TURN
            playerAttack(p1, npc);
            // ENEMY ATTACK TURN
            enemyAttack(p1, npc);
        }
        if (npc.getHP() <= 0) {
            // Setting HP and Stamina to full after winning a fight
            p1.setHP(model.getFullHP());
            p1.setStamina(model.getFullStamina());
            npc.setHP(model.getFullHP()); // setting npc hp to 100 for testing
        }
        if (p1.getHP() <= model.getNoHP()){
            // Setting HP and Stamina to full after losing a fight
            p1.setHP(model.getFullHP());
            p1.setStamina(model.getFullStamina());
            npc.setHP(model.getFullHP());
            view.playerDeath();
            // returns that player died
            return false;
        }
        //returns that player is alive
        return true;
    }

    public void playerAttack(Fighter p1, Fighter npc){
        boolean optionChosen = false;   // this boolean allows players to use "back" option
        while (!optionChosen) {
            if (p1.getStamina() > model.getNoStamina()) {
                view.displayCombatOptions();
                switch (getUserInputFourOptions()) {
                    case "1":
                        // ATTACK
                        userAttackOptions(p1, npc);
                        switch (getUserInputThreeOptions()) {
                            case "1":
                                // MELEE ATTACK
                                playerMeleeAttack(p1, npc);
                                optionChosen = true;
                                break;
                            case "2":
                                // RANGED ATTACK
                                playerRangedAttack(p1, npc);
                                optionChosen = true;
                                break;
                            case "3":
                                // RETURN TO OPTIONS
                                view.backOption();
                        }
                        break;
                    case "2":
                        //  USE ITEMS
                        userPotionOptions(p1, npc);
                        switch (getUserInputThreeOptions()){
                            case "1":
                                // HEALTH POT
                                playerChooseHealthPots(p1,
                                        p1.getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getSMALL_CHOICE()).toString(),
                                        p1.getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getMEDIUM_CHOICE()).toString(),
                                        p1.getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getBIG_CHOICE()).toString()
                                        );
                                break;
                            case "2":
                                // STAMINA POT
                                playerChooseStaminaPot(p1,
                                        p1.getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getSMALL_CHOICE()).toString(),
                                        p1.getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getMEDIUM_CHOICE()).toString(),
                                        p1.getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getBIG_CHOICE()).toString());
                                break;
                            case "3":
                                // BACK
                                view.backOption();
                        }
                        break;
                    case "3":
                        // TAUNT
                        playerChooseTaunt();
                        break;
                    case "4":
                        // SURRENDER
                        // maybe you can surrender 2 fights maximum, before you die
                        System.out.println("Not implemented yet.");
                }
            } else {
                view.playerNoStamina();
                view.enterNext();
                kb.nextLine();
                System.out.println();
                p1.setStamina(model.getBasicStaminaRegen());
                optionChosen = true;
            }
        }
    }

    public void enemyAttack(Fighter p1, Fighter npc){
        if (npc.getHP()>model.getNoHP()){
            model.setEnemyChoice(randomNumberGenerator(model.getEnemyInitialChoice()));
            switch(model.getEnemyChoice()){
                case 0:
                    // MELEE WILL FOLLOW THRU
                    view.enemyAttacks(npc.getWeapons().get(model.getMELEE_CHOICE()).toString());
                    p1.setHP(p1.getHP()-npc.getWeapons().get(model.getMELEE_CHOICE()).getDamage());
                    break;
                case 1:
                    // RANGED
                    if (rangedMissChance()){
                        view.enemyRangedAttack(npc.getWeapons().get(model.getRANGED_CHOICE()).toString());
                        p1.setHP(p1.getHP()-npc.getWeapons().get(model.getRANGED_CHOICE()).getDamage());
                    } else {
                        view.enemyMissedRangedAttack();
                    }
                    break;
                case 2:
                    // USE ITEMS
                    System.out.println("enemy item used");
                    break;
            }
            view.enterNext();
            kb.nextLine();
            System.out.println();
            view.bigDivider();
        } else {
            view.enemyDied(npc.getName());
        }
    }

    public void playerMeleeAttack(Fighter p1, Fighter npc){
        view.meleeAttack(p1.getWeapons().get(model.getMELEE_CHOICE()).toString());
        npc.setHP(npc.getHP() - model.getPlayer().getWeapons().get(model.getMELEE_CHOICE()).getDamage());
        if (npc.getHP()>model.getNoHP()){
            meleeHitChance();
        }
        p1.setStamina(p1.getStamina() -
                p1.getWeapons().get(model.getMELEE_CHOICE()).getStaminaUsage());
        next_input_lineBreak();
    }

    public void playerRangedAttack(Fighter p1, Fighter npc){
        if (rangedMissChance()){
            view.rangedAttack(p1.getWeapons().get(model.getRANGED_CHOICE()).toString());
            npc.setHP(npc.getHP() - model.getPlayer().getWeapons().get(model.getRANGED_CHOICE()).getDamage());
        } else {
            view.missedRangedAttack();
        }
        next_input_lineBreak();
    }

    public void userPotionOptions(Fighter p1, Fighter npc){
        view.displayPotionOptions();
    }

    public void playerChooseHealthPots(Fighter p1, String small, String medium, String big){
        view.displaySpecificPotOptions(small, medium, big);
        switch (getUserInputFourOptions()){
            case "1":
                if (p1.getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getSMALL_CHOICE())
                                .getAmount() > 0){
                    ((HealthPot)(p1.getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getSMALL_CHOICE())))
                            .useItem(p1);
                    view.playerChoseSmallPotion(p1.getInventory().get(model.getHEALTH_POT_CHOICE())
                            .get(model.getSMALL_CHOICE()).toString());
                    p1.getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getSMALL_CHOICE()).minusAmount();
                } else {
                    view.playerChoseEmptyPotion();
                }
                break;
            case "2":
                if (p1.getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getMEDIUM_CHOICE())
                        .getAmount() > 0){
                    ((HealthPot)(p1.getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getMEDIUM_CHOICE())))
                            .useItem(p1);
                    view.playerChoseMediumPotion(p1.getInventory().get(model.getHEALTH_POT_CHOICE())
                            .get(model.getMEDIUM_CHOICE()).toString());
                    p1.getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getMEDIUM_CHOICE()).minusAmount();
                } else {
                    view.playerChoseEmptyPotion();
                }
                break;
            case "3":
                if (p1.getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getBIG_CHOICE())
                        .getAmount() > 0){
                    ((HealthPot)(p1.getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getBIG_CHOICE())))
                            .useItem(p1);
                    view.playerChoseBigPotion(p1.getInventory().get(model.getHEALTH_POT_CHOICE())
                            .get(model.getBIG_CHOICE()).toString());
                    p1.getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getBIG_CHOICE()).minusAmount();
                } else {
                    view.playerChoseEmptyPotion();
                }
                break;
            case "4":
                view.backOption();
        }
    }
    
    public void playerChooseStaminaPot(Fighter p1, String small, String medium, String big){
        view.displaySpecificPotOptions(small, medium, big);
        switch (getUserInputFourOptions()){
            case "1":
                if (p1.getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getSMALL_CHOICE())
                        .getAmount() > 0){
                    ((StaminaPot)(p1.getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getSMALL_CHOICE())))
                            .useItem(p1);
                    view.playerChoseSmallPotion(p1.getInventory().get(model.getSTAMINA_POT_CHOICE())
                            .get(model.getSMALL_CHOICE()).toString());
                    p1.getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getSMALL_CHOICE()).minusAmount();
                } else {
                    view.playerChoseEmptyPotion();
                }
                break;
            case "2":
                if (p1.getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getMEDIUM_CHOICE())
                        .getAmount() > 0){
                    ((StaminaPot)(p1.getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getMEDIUM_CHOICE())))
                            .useItem(p1);
                    view.playerChoseMediumPotion(p1.getInventory().get(model.getSTAMINA_POT_CHOICE())
                            .get(model.getMEDIUM_CHOICE()).toString());
                    p1.getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getMEDIUM_CHOICE()).minusAmount();
                } else {
                    view.playerChoseEmptyPotion();
                }
                break;
            case "3":
                if (p1.getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getBIG_CHOICE())
                        .getAmount() > 0){
                    ((StaminaPot)(p1.getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getBIG_CHOICE())))
                            .useItem(p1);
                    view.playerChoseBigPotion(p1.getInventory().get(model.getSTAMINA_POT_CHOICE())
                            .get(model.getBIG_CHOICE()).toString());
                    p1.getInventory().get(model.getSTAMINA_POT_CHOICE()).get(model.getBIG_CHOICE()).minusAmount();
                } else {
                    view.playerChoseEmptyPotion();
                }
                break;
            case "4":
                view.backOption();
        }
    }

    public void playerChooseTaunt(){
        view.displayTaunt();
        view.lineBreak();
    }

    public void userAttackOptions(Fighter p1, Fighter npc){
        view.userAttackOptions(p1.getWeapons().get(model.getMELEE_CHOICE()).toString(),
                p1.getWeapons().get(model.getRANGED_CHOICE()).toString());
    }

    public void meleeHitChance(){
        if(randomNumberGenerator(model.getCounterHitDamage()) >=
                model.getPlayer().getWeapons().get(model.getMELEE_CHOICE()).getHitChance()){
            model.getPlayer().setHP(model.getPlayer().getHP()-model.getCounterHitDamage());
            view.counterHit();
        }
    }

    public boolean rangedMissChance(){
        if (randomNumberGenerator(model.getMissedRange()) <=
                model.getPlayer().getWeapons().get(model.getRANGED_CHOICE()).getHitChance()){
            return true;        // RETURNS TRUE IF HIT WAS SUCCESSFUL
        }
        return false;
    }

    public String getUserInputFiveOptions(){
        boolean validInput = false;
        String input = "";
        while (!validInput){
            view.userEnter();
            input = kb.nextLine();
            if (input.equals("1") ||
                    input.equals("2")||
                    input.equals("3")||
                    input.equals("4")||
                    input.equals("5")){
                validInput = true;
            } else {
                view.invalidInput();
            }
        }
        return input;
    }

    public String getUserInputFourOptions(){
        boolean validInput = false;
        String input = "";
        while (!validInput){
            view.userEnter();
            input = kb.nextLine();
            if (input.equals("1") ||
                input.equals("2")||
                input.equals("3")||
                input.equals("4")){
                validInput = true;
            } else {
                view.invalidInput();
            }
        }
        return input;
    }

    public String getUserInputThreeOptions(){
        boolean validInput = false;
        String input = "";
        while (!validInput){
            view.userEnter();
            input = kb.nextLine();
            if (input.equals("1") ||
                    input.equals("2")||
                    input.equals("3")){
                validInput = true;
            } else {
                view.invalidInput();
            }
        }
        return input;
    }

    public String getUserInputTwoOptions(){
        boolean validInput = false;
        String input = "";
        while (!validInput){
            view.userEnter();
            input = kb.nextLine();
            if (input.equals("1") ||
                    input.equals("2")){
                validInput = true;
            } else {
                view.invalidInput();
            }
        }
        return input;
    }

    public int randomNumberGenerator(int range){
        Random rand = new Random();
        return rand.nextInt(range+1);
    }

    public void next_input_lineBreak(){
        view.enterNext();
        kb.nextLine();
        view.lineBreak();
    }


}
