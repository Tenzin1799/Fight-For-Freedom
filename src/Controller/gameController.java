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
        combat(model.getPlayer(), model.getNPC());
    }

    public void combat(Fighter p1, Fighter npc){
        npc.getWeapons().add(model.getWoodSword());
        npc.getWeapons().add(model.getPistol());
        view.beginCombatDialogue(p1.getName(), npc.getName());

        // while player is alive && npc is alive, add loop later
        while(p1.getHP() > 0 &&
                npc.getHP() > 0) {
            view.displayStats(p1.getName(), p1.getHP(), p1.getStamina(),
                    npc.getName(), npc.getHP(), npc.getStamina());
            boolean optionChosen = false;   // this boolean allows players to use "back" option
            // PLAYER ATTACK TURN
            while (!optionChosen) {
                if (p1.getStamina() > 0) {
                    view.displayCombatOptions();
                    switch (getUserInputFourOptions()) {
                        case "1":
                            view.userAttackOptions();
                            switch (getUserInputThreeOptions()) {
                                case "1":
                                    // MELEE ATTACK
                                    view.meleeAttack(p1.getWeapons().get(0).toString());
                                    npc.setHP(npc.getHP() - model.getPlayer().getWeapons().get(0).getDamage());
                                    if (npc.getHP()>0){
                                        meleeHitChance();
                                    }
                                    p1.setStamina(p1.getStamina() -
                                            p1.getWeapons().get(0).getStaminaUsage());
                                    view.enterNext();
                                    kb.nextLine();
                                    optionChosen = true;
                                    break;
                                case "2":
                                    // RANGED ATTACK
                                    System.out.println("Ranged attack");
                                    npc.setHP(npc.getHP() - 20);
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
            if (npc.getHP()>0){
                view.enemyAttacks(npc.getWeapons().get(randomNumberGenerator(model.getEnemyMaxWeaponsIndex())).getName());
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
        if(randomNumberGenerator(model.getCounterHitDamage()) >= model.getPlayer().getWeapons().get(0).getHitChance()){
            model.getPlayer().setHP(model.getPlayer().getHP()-model.getCounterHitDamage());
            view.counterHit();
        }
    }

    public int randomNumberGenerator(int range){
        Random rand = new Random();
        return rand.nextInt(range+1);
    }

}
