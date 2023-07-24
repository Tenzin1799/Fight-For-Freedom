package View;

public class gameView {

    //////////////////////// TOOLS ///////////////////////////////
    /////////////////////////////////////////////////////////////

    public void gameStartLogo(){
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||  FIGHT FOR FREEDOM  |||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    }

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
        System.out.print("(Hit Enter to continue)");
    }

    public void displayPlayAgain(){
        System.out.println("Would you like to play again?");
        System.out.println("1. Yes");
        System.out.println("2. No");
    }

    public void displayKeepPlaying(){
        System.out.println("Would you like to keep playing?");
        System.out.println("1. Yes");
        System.out.println("2. No");
    }

    //////////////////  Initial Set Up  /////////////////////////

    public void beginGameIntro(){
        System.out.println("This game is completely fictional. Any resemblance to real people or events\n" +
                "are purely coincidental. This game also includes violence and obscene language.\n" +
                "If you do not wish to continue, please end the game now.");
    }

    public void setUpGame(){
        System.out.println("All we need before you get started is the name for your character.");
    }

    public void getUserPlayerName(){
        System.out.print("What's your character's name?: ");
    }

    public void nameCorrect(String name){
        System.out.println("Alright, " + name +". Does that look right?");
        System.out.println("1. Yes");
        System.out.println("2. No");
    }

    ////////////////////// CHAPTER 1 ////////////////////////////
    /////////////////////////////////////////////////////////////

    public void chapterOneLogo(){
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||  CHAPTER ONE  ||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    }

    public void chapterOne_1() {
        System.out.println("The lock clicks as you turn the switch on the steel deadbolt \n" +
                "loosely screwed onto the door behind you. You really need to tighten those screws soon,\n" +
                "or you won’t have a lock for much longer. How else are you going to keep your \n" +
                "shitty one-bedroom apartment secure if not for that lonely metal lock? \n" +
                "Maybe you can do it tomorrow though. You’re exhausted after your long shift. \n" +
                "Eight hours of fake smiling and pretend happiness while you serve food at the \n" +
                "restaurant you work at, and it feels like you’re a proper blue collar man. \n" +
                "You’d be screwed if you actually did work in manual labor. Definitely not \n" +
                "lasting eight hours if you’re this tired from just serving food.");
        System.out.println("(Do you tighten the screws?)");
        System.out.println("1. Yes");
        System.out.println("2. No");
    }

    public void chapterOne_1_1(){
        System.out.println("Wow. Took that blue collar man comment to heart, didn’t you? \n" +
                "You dig through the toolbox you keep in the closet to find the right \n" +
                "screwdriver for the job. Once you’re able to locate one, you get to work. \n" +
                "While tightening the screws on the deadbolt, you can’t help but wonder \n" +
                "what life would have been like if you had listened to your parents and \n" +
                "studied engineering during your college days. Maybe you would’ve bought a \n" +
                "house by now. Or maybe a Tesla. Maybe you’d even have a girlfriend… or boyfriend? \n" +
                "Doesn’t matter now. You just need to worry about how you’re planning on \n" +
                "keeping the lights on for the next month. ");
    }

    public void chapterOne_1_1_1(){
        System.out.println("Just as you finish tightening the screws, you hear a knock at the door.");
        System.out.println("(What do you do?)");
        System.out.println("1. Open the door");
        System.out.println("2. \"Who is it?\"" );
        System.out.println("3. Ignore it. It's time to go take a shower.");
    }

    public void chapterOne_1_1_1_1(){
        System.out.println("You open the door without asking for identity. \n" +
                "What’s the point of having a lock if you’re just going to open it for anyone who knocks?");
        // reveal of kroblag
    }

    public void chapterOneRevealKroblag(){
        System.out.println("Standing in front of you is a tall creature. Chunky. \n" +
                "Green skin covered in scales. Yellow eyes with slits for it’s iris. \n" +
                "It’s clearly not human. It grins down at you. You notice it holds \n" +
                "some sort of device in it’s hand. Then the next thing you notice is your vision fading.");
    }

    public void chapterOne_1_1_1_2(){
        System.out.println("???: \"Your landlord.\"");
        System.out.println("(What do you do?)");
        System.out.println("1. Open the door");
        System.out.println("2. Ignore it. Fuck that guy.");
    }

    public void chapterOne_1_1_1_3(){
        System.out.println("You turn away from the door. If they really needed to get a hold of you, \n" +
                "they’d leave a note. Just as you begin walking away, the door bursts open. \n" +
                "Before you can react you are forced onto the floor. You hear a beep as \n" +
                "your attacker keeps you pinned down. Your vision fades as you drift into a slumber.");
        System.out.println("???: \"Where do you think you're going? You hairless monkey.\"");
    }


    //////////////////////// SHOP ///////////////////////////////
    /////////////////////////////////////////////////////////////
    public void visitShopFirstTime(){
        System.out.println("A bell chimes as you step inside the shop. The entire place is lit with \n" +
                "a red light, distorting the colors of everything inside. Even your clothes and skin have turned red. \n" +
                "Up ahead you see what appears to be the register. A long table stretching from \n" +
                "one end of the room to the other. Behind the register is a door leading to a backroom with a \n" +
                "partially torn sign that reads:\n\"Blorployees Only! MEANING ME. STAY OUT.\"");
    }

    public void visitShopFirstTime2(String name){
        System.out.println("The backroom door swings open. Slamming against the wall beside it. \n" +
                "From the backroom a large blob-like entity steps out. Or... more like, glides out. \n" +
                "It's movement isn't quite a slither. You aren't really sure how this creature is moving. But it is. \n" +
                "The green-tinted blob stops behind the register, and two little black balls plop out from within it. \n" +
                "They slide down it's jiggling body, then quickly slides up to the top. Locking into place. \n" +
                "The being stands still, however the jiggle ensues. Then suddenly you hear: \n");
        System.out.println(name+": \"Well??? Do you need something?\"");
    }

    public void displayFirstTimeShopOptions() {
        System.out.println("1. \"Uh... Hello. I wanted to see what items you were selling.\"");
        System.out.println("2. \"Yes. Sorry... What are you?\"");
        System.out.println("3. \"How the hell- Where is your mouth- HOW ARE YOU SPEAKING IN MY MIND!??\"");
        System.out.println("4. \"On second thought. I think I'm okay. (Leave)\"");
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
        System.out.println("The blob's black orbs blink, one after the other. Then a soft sigh is released \n" +
                "while it's body ripples outwards from it's center.\n");
        System.out.println(name+ ": \"Why do I always get the dumb ones. Ah, right. I'm the only shop in town.\n" +
                "Look, I don't have all day. Are you here to buy something or not?\"");
    }

    public void leaveShop(String name){
        // "On second thought. I think I'm okay. (leaves)"
        System.out.println(name + ": \"Suit yourself.\"");
    }

    public void visitShop(String name){
        System.out.println(name + ": \"Welcome back. What will it be today?\"");
    }

    public void displayShopOptions(){
        System.out.println("(What sort of items would you like to purchase?)");
        System.out.println("1. Weapons");
        System.out.println("2. Health Items");
        System.out.println("3. Stamina Items");
        System.out.println("4. Leave");
    }

    public void displayShopPotOptions(String small, int smallPrice, String medium, int mediumPrice, String big, int bigPrice, int playerMoney){
        System.out.println("Your money: $" + playerMoney);
        System.out.println("1. " + small +" - $" + smallPrice);
        System.out.println("2. " + medium+" - $" + mediumPrice);
        System.out.println("3. " + big+" - $" + bigPrice);
        System.out.println("4. Back");
    }

    public void notEnoughMoney(){
        System.out.println("You don't have enough money for this item.");
    }

    public void purchasedItem(String name){
        System.out.println("You've purchased " + name +".");
    }

    public void displayShopCombatOptions(){
        System.out.println("(You will automatically use the most recent weapon purchased. There's no point \n" +
                "in buying a weaker weapon once you already have a better one. Unless you enjoy pain.)");
        System.out.println("1. Melee");
        System.out.println("2. Ranged");
        System.out.println("3. Back");
    }

    public void displayShopSpecificCombatOptions(String wood,  String blade, String hammer, String energy,
                                        int woodPrice, int bladePrice, int hammerPrice, int energyPrice,
                                        int playerMoney, String playerMeleeWeapon, String weaponType){
        System.out.println("Your money: $" + playerMoney + " | Your "+ weaponType +" weapon: " + playerMeleeWeapon);
        System.out.println("1. " + wood +" - $" + woodPrice);
        System.out.println("2. " + blade +" - $" + bladePrice);
        System.out.println("3. " + hammer +" - $" + hammerPrice);
        System.out.println("4. " + energy +" - $" + energyPrice);
        System.out.println("5. Back");
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

    public void playerDeath(){
        System.out.println("You've died!");
    }

}
