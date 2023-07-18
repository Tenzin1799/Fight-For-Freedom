package Controller;
import Model.*;
import Model.Characters.Fighter;
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
        combat(model.getPlayer(), model.getNPC());
    }

    public void combat(Fighter p1, Fighter npc){
        npc.getWeapons().add(model.getWoodSword());
        npc.getWeapons().add(model.getPistol());
        view.beginCombatDialogue(p1.getName(), npc.getName());

        // while player is alive && npc is alive, add loop later
        while(p1.getHP() > model.getNoHP() &&
                npc.getHP() > model.getNoHP()) {
            view.displayStats(p1.getName(), p1.getHP(), p1.getStamina(),
                    npc.getName(), npc.getHP(), npc.getStamina());
            boolean optionChosen = false;   // this boolean allows players to use "back" option
            // PLAYER ATTACK TURN
            while (!optionChosen) {
                if (p1.getStamina() > model.getNoStamina()) {
                    view.displayCombatOptions();
                    switch (getUserInputFourOptions()) {
                        case "1":
                            view.userAttackOptions(p1.getWeapons().get(model.getMELEE_CHOICE()).toString(),
                                    p1.getWeapons().get(model.getRANGED_CHOICE()).toString());
                            switch (getUserInputThreeOptions()) {
                                case "1":
                                    // MELEE ATTACK
                                    view.meleeAttack(p1.getWeapons().get(model.getMELEE_CHOICE()).toString());
                                    npc.setHP(npc.getHP() - model.getPlayer().getWeapons().get(model.getMELEE_CHOICE()).getDamage());
                                    if (npc.getHP()>model.getNoHP()){
                                        meleeHitChance();
                                    }
                                    p1.setStamina(p1.getStamina() -
                                            p1.getWeapons().get(model.getMELEE_CHOICE()).getStaminaUsage());
                                    view.enterNext();
                                    kb.nextLine();
                                    optionChosen = true;
                                    break;
                                case "2":
                                    // RANGED ATTACK
                                    if (rangedMissChance()){
                                        view.rangedAttack(p1.getWeapons().get(model.getRANGED_CHOICE()).toString());
                                        npc.setHP(npc.getHP() - model.getPlayer().getWeapons().get(model.getRANGED_CHOICE()).getDamage());
                                    } else {
                                        view.missedRangedAttack();
                                    }
                                    view.enterNext();
                                    kb.nextLine();
                                    optionChosen = true;
                                    break;
                                case "3":
                                    // RETURN TO OPTIONS
                                    System.out.println("Back");
                            }
                            break;
                        case "2":
                            //  USE ITEMS
                            break;
                        case "3":
                            // TAUNT
                            break;
                        case "4":
                            // SURRENDER
                            // maybe you can surrender 2 fights maximum, before you die
                    }
                } else {
                    view.playerNoStamina();
                    view.enterNext();
                    kb.nextLine();
                    p1.setStamina(model.getBasicStaminaRegen());
                    optionChosen = true;
                }
            }
            // ENEMY ATTACK TURN
            if (npc.getHP()>model.getNoHP()){
                model.setEnemyChoice(randomNumberGenerator(model.getEnemyInitialChoice()));
                switch(model.getEnemyChoice()){
                    case 0:
                        // MELEE WILL FOLLOW THRU
                    case 1:
                        // RANGED
                        if (rangedMissChance()){
                            view.rangedAttack(npc.getWeapons().get(model.getRANGED_CHOICE()).toString());
                            p1.setHP(p1.getHP()-npc.getWeapons().get(model.getRANGED_CHOICE()).getDamage());
                        } else {
                            view.enemyMissedRangedAttack();
                        }
                        break;
                    case 2:
                        // USE ITEMS
                        System.out.println("item Used");
                        break;
                }
                view.enterNext();
                kb.nextLine();
                view.bigDivider();
            } else {
                view.enemyDied(npc.getName());
            }
        }
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
