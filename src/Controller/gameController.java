package Controller;
import Model.*;
import Model.Characters.Fighter;
import Model.Items.HealthPot;
import Model.Items.StaminaPot;
import View.*;
import java.util.Random;
import java.util.Scanner;

public class gameController {
    private Scanner kb = new Scanner(System.in);
    private gameModel model = new gameModel();
    private gameView view = new gameView();


    public void startGame(){
        model.getPlayer().getWeapons().add(model.getUnarmed());
        model.getPlayer().getWeapons().add(model.getRocks());
        model.getPlayer().getInventory().add(model.getPlayerHealthPotions());
        model.getPlayer().getInventory().get(model.getHEALTH_POT_CHOICE()).add(model.getHpSmall());
//        model.getPlayer().getInventory().get(model.getHEALTH_POT_CHOICE()).get(model.getSMALL_CHOICE()).addAmount();
        model.getPlayer().getInventory().get(model.getHEALTH_POT_CHOICE()).add(model.getHpMedium());
        model.getPlayer().getInventory().get(model.getHEALTH_POT_CHOICE()).add(model.getHpBig());
        model.getPlayer().getInventory().add(model.getPlayerStaminaPotions());
        model.getPlayer().getInventory().get(model.getSTAMINA_POT_CHOICE()).add(model.getStaminaSmall());
        model.getPlayer().getInventory().get(model.getSTAMINA_POT_CHOICE()).add(model.getStaminaMedium());
        model.getPlayer().getInventory().get(model.getSTAMINA_POT_CHOICE()).add(model.getStaminaBig());


        combat(model.getPlayer(), model.getNPC());
    }

    public void shop(boolean visited){
        if (!visited){
            view.visitShopFirstTime();

            visited = true;
        }
        view.visitShop();
    }

    public void combat(Fighter p1, Fighter npc){
        npc.getWeapons().add(model.getWoodSword());
        npc.getWeapons().add(model.getPistol());
        view.beginCombatDialogue(p1.getName(), npc.getName());
        view.enterNext();
        kb.nextLine();
        view.lineBreak();
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
        }
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
        view.enterNext();
        kb.nextLine();
        view.lineBreak();
    }

    public void playerRangedAttack(Fighter p1, Fighter npc){
        if (rangedMissChance()){
            view.rangedAttack(p1.getWeapons().get(model.getRANGED_CHOICE()).toString());
            npc.setHP(npc.getHP() - model.getPlayer().getWeapons().get(model.getRANGED_CHOICE()).getDamage());
        } else {
            view.missedRangedAttack();
        }
        view.enterNext();
        kb.nextLine();
        System.out.println();
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

    public int randomNumberGenerator(int range){
        Random rand = new Random();
        return rand.nextInt(range+1);
    }

}
