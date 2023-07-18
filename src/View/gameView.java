package View;

public class gameView {

    public void beginCombatDialogue(String playerName, String enemyName){
        System.out.println("Alright here we go, we have " + playerName + " up against " + enemyName +"!");
        System.out.println("Let the match begin!\n");
    }

    public void displayStats(String playerName, int playerHP, int playerStamina,
                             String enemyName, int enemyHP, int enemyStamina){

        //top section displays the enemy name, hp and stamina
        System.out.printf("%s%n", enemyName);
        System.out.print("HP: " + enemyHP +" [");
        for (int i = 1; i < enemyHP; i = i+10) {
            System.out.print("|");
        }
        System.out.println("]");
        System.out.print("Stamina: " + enemyStamina + " [");
        for (int i = 1; i < enemyStamina; i = i+10){
            System.out.print("|");
        }
        System.out.println("]");

        // creates a space between the two fighters for readability
        System.out.println("\nvs\n");


        // function is the same as above, but for the player
        System.out.printf("%s%n", playerName);
        System.out.print("HP: " + playerHP + " [");
        for (int i = 1; i < playerHP; i = i+10) {
            System.out.print("|");
        }
        System.out.println("]");
        System.out.print("Stamina: " + playerStamina + " [");
        for (int i = 1; i < playerStamina; i = i+10){
            System.out.print("|");
        }
        System.out.println("]\n\n");
    }

    public void displayCombatOptions(){
        System.out.println("1. Attack");
        System.out.println("2. Use Item");
        System.out.println("3. Taunt");
        System.out.println("4. Surrender");
        System.out.println();
    }

    public void userEnter(){
        System.out.print("you: ");
    }

    public void userAttackOptions(){
        System.out.println("1. Melee");
        System.out.println("2. Ranged");
        System.out.println("3. Back");

    }

    public void invalidInput(){
        System.out.println("Sorry, try again.");
    }

    public void meleeAttack(String meleeWeapon){
        System.out.println("You attacked with " + meleeWeapon + "!");
    }

    public void counterHit(){
        System.out.println("Enemy counter attacks and lands!");
    }

    public void enterNext(){
        System.out.print("Enter any key: ");
    }

    public void playerNoStamina(){
        System.out.println("You have no Stamina! You will have to rest! Brace for enemy attack!");
    }

    public void enemyAttacks(String weaponName){
        System.out.println("Enemy attacks with " +weaponName + "!");
    }

    public void enemyDied(String name){
        System.out.println(name +" falls to his death!");
    }

    public void bigDivider(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 20; j++){
                System.out.print(".");
            }
            System.out.println();
        }
    }
}
