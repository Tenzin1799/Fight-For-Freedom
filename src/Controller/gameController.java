package Controller;
import Model.*;
import Model.Characters.Fighter;
import View.*;

import java.util.Scanner;

public class gameController {
    private Scanner kb = new Scanner(System.in);
    private gameModel model = new gameModel();
    private gameView view = new gameView();

    public void startGame(){
        combat(model.getPlayer(), model.getNPC());
    }

    public void combat(Fighter p1, Fighter npc){
        view.beginCombatDialogue(p1.getName(), npc.getName());

        // while player is alive && npc is alive, add loop later
        view.displayStats(p1.getName(), p1.getHP(), p1.getStamina(),
                npc.getName(), npc.getHP(), npc.getStamina());
        boolean optionChosen = false;   // this boolean allows players to use "back" option
        while(!optionChosen){
            view.displayCombatOptions();
            switch (getUserInputFourOptions()) {
                case "1":
                    view.userAttackOptions();
                    switch (getUserInputThreeOptions()) {
                        case "1":
                            System.out.println("Melee attack");
                            npc.setHP(npc.getHP() - 20);
                            optionChosen = true;
                            break;
                        case "2":
                            System.out.println("Ranged attack");
                            npc.setHP(npc.getHP() - 20);
                            optionChosen = true;
                            break;
                        case "3":
                            System.out.println("Back");
                    }
                    break;
                case "2":
                    System.out.println("Use Item");
                    break;
                case "3":
                    System.out.println("Taunt");
                    break;
                case "4":
                    System.out.println("Surrender");
            }
        }
//        view.bigDivider();

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

}
