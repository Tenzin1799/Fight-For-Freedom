package View;

public class gameView {

    //////////////////////// TOOLS ///////////////////////////////
    /////////////////////////////////////////////////////////////
    public void lineBreak(){
        System.out.println();
    }

    public void backOption(){
        System.out.println("Back....");
    }

    public void invalidInput(){
        System.out.println("Sorry, try again.");
    }

    public void userEnter(){
        System.out.print("you: ");
    }

    public void bigDivider(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 20; j++){
                System.out.print(".");
            }
            System.out.println();
        }
    }

    public void enterNext(){
        System.out.print("Enter any key: ");
    }

    public void displayPotionOptions(){
        System.out.println("Items:");
        System.out.println("1. Health");
        System.out.println("2. Stamina");
        System.out.println("3. Back");
        System.out.println();
    }

    public void displaySpecificPotOptions(String small, String medium, String big){
        System.out.println("1. " + small);
        System.out.println("2. " + medium);
        System.out.println("3. " + big);
        System.out.println("4. Back");
        System.out.println();
    }

    //////////////////////// SHOP ///////////////////////////////
    /////////////////////////////////////////////////////////////
    public void visitShopFirstTime(){
        System.out.println("\tA bell chimes as you step inside the shop. The entire place is lit with \n" +
                "a red light, distorting the colors of everything inside. Even your clothes and skin have turned red. \n" +
                "Up ahead you see what appears to be the register. A long table stretching from \n" +
                "one end of the room to the other. Behind the register is a door leading to a backroom with a \n" +
                "partially torn sign that reads:\n\"Blorployees Only! MEANING ME. STAY OUT.\"");
    }

    public void visitShopFirstTime2(String name){
        System.out.println("The backroom door swings open. Slamming against the wall beside it. \n" +
                "From the backroom a large blob-like species steps out. Or... more like, glides out. \n" +
                "It's movement isn't quite a slither. You aren't really sure how this creature is moving. But it is. \n" +
                "The blob stops behind the register, and two little black balls plop out from within it. \n" +
                "They slide down it's jiggling body, then quickly slides up to the top. Locking into place. \n" +
                "The being stands still, however the jiggle ensues. Then suddenly you hear: \n");
        System.out.println(name+": \"Well??? Do you need something?\"");
    }

    public void displayFirstTimeShopOptions() {
        System.out.println("1. \"Uh... Hello. I wanted to see what items you were selling.\"");
        System.out.println("2. \"Yes. Sorry... What are you?\"");
        System.out.println("3. \"How the hell- Where is your mouth- HOW ARE YOU SPEAKING IN MY MIND!??\"");
        System.out.println("4. \"On second thought. I think I'm okay.\"");
    }

    public void visitShopFirstTime3_1(String name){
        // "Uh.. Hello. I wanted to see what items you were selling."
        System.out.println(name+": \"Ah, good. At first I thought you were one of those weirdos \n" +
                "that like to make long, awkward, uninterrupted... slightly romantic.. but still awkward eye-contact.\n" +
                "Anyways. I have plenty of items in store. Weapons, nourishments--- Well I guess that's all I have. \n" +
                "So what will it be?\"");
        // then use normal shop function
    }

    public void visitShopFirstTime3_2(String name){
        // "Hi- Sorry... What are you??"
        System.out.println(name +": \"First time seeing a Ba'Chunko eh? Don't worry, not my first rodeo. \n" +
                "Space is too big for one to come across every species. Hell, I've been running this shop for \n" +
                "for decades and I still see new folks every day. Any-who. I don't have all day, so if you would like to \n" +
                "make a purchase, let's get on with it.\"");
        // use normal shop function
    }

    public void visitShopFirstTime3_3(String name){
        // "How the hell- Where is your mouth- HOW ARE YOU SPEAKING IN MY MIND?"
        // shopKeeper will stare at you. sigh. and says "why do I always get idiots. oh right.
        // I'm the only shop in town. Look buddy, I don't have all day. Do you want to buy something or no?"
    }

    public void visitShopFirstTime3_4(String name){
        // "On second thought. I think I'm okay. (leaves)"
    }

    public void visitShop(){

    }




    //////////////////////// COMBAT /////////////////////////////
    /////////////////////////////////////////////////////////////
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

    public void userAttackOptions(String melee, String ranged){
        System.out.println("1. Melee - " + melee);
        System.out.println("2. Ranged - " + ranged);
        System.out.println("3. Back");
        System.out.println();
    }

    public void meleeAttack(String meleeWeapon){
        System.out.println("You attacked with " + meleeWeapon + "!");
    }

    public void counterHit(){
        System.out.println("Enemy counter attacks and lands!");
    }

    public void rangedAttack(String rangedWeapon){
        System.out.println("You attacked with " + rangedWeapon + "!!");
    }

    public void missedRangedAttack(){
        System.out.println("You missed!!");
    }

    public void enemyRangedAttack(String rangedWeapon){
        System.out.println("Enemy attacked with " + rangedWeapon +"!!");
    }

    public void enemyMissedRangedAttack(){
        System.out.println("Enemy missed a long ranged attack!!");
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

    public void playerChoseSmallPotion(String name){
        System.out.println("Drank small potion!");
    }

    public void playerChoseMediumPotion(String name){
        System.out.println("Drank medium potion!");
    }

    public void playerChoseBigPotion(String name){
        System.out.println("Drank big potion!");
    }

    public void playerChoseEmptyPotion(){
        System.out.println("You don't have any to use!");
    }

    public void displayTaunt(){
        System.out.println("you: \"That's all you got??\"");
    }

}
