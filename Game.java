import java.util.Random;
import java.util.Scanner;

    public class Game {
        private int userGuess;
        private int randomNum;

    public int getRandomNum() {
        return this.randomNum;
    }
    public void setRandomNum(int randomNum) {
        this.randomNum = randomNum;
    }

    static Scanner scan = new Scanner(System.in); // You don't want to use scanner in this class, since you
                                                  // going to remove scanner in spring version and leave this file in
                                                  // spring boot version
    static Random obj = new Random(); // this line does nothing, guess why
    static int EASY_LEVEL_ATTEMPTS = 15; // I would created separate class called GameDifficulty for these values, 
                                         // but like this is also fine
    static int MEDIUM_LEVEL_ATTEMPTS = 7;
    static int HARD_LEVEL_ATTEMPTS = 3;

    public Game() {
        Random obj = new Random();
        randomNum = obj.nextInt(100);
    }

    public int getUserGuess() {
        return this.userGuess;
    }

    public void setUserGuess(int userGuess) {
        this.userGuess = userGuess;
    }

    /**
     * This function does tights your game class with external scanner interface
     * not good since you are going to get rid of scanner when doing spring boot.
     * Also it does not use game properties or methods, so it could be removed from game object.
     */
    public void gameStarter() {
        System.out.println("YOU ARE NOW PLAYING GUESS THE NUMBER GAME!");
        System.out.println("YOU HAVE LIMITED TRIES! BE CAREFUL. LET'S START ..");
        System.out.println("----------------------------------------------");
        System.out.println("Select the level of the game: hard, easy or medium");
        System.out.println("In the easy level, you have 15 guesses.");
        System.out.println("In the hard level, you have 3 guesses..");
        System.out.println("In the medium level, you have 7 guesses.");
    }

    /**
     * After user selected a level it would be nice to save the selected difficulty
     * into game class, because it is directly affects the game logic.
     */
    public int setLevel() {
        System.out.print("Choose a LEVEL: Type 'easy', 'medium' or 'hard': ");
        String level = scan.nextLine();
        if (level.equals("easy")) {
            return EASY_LEVEL_ATTEMPTS;
        } 
        else if (level.equals("medium")) {
            return MEDIUM_LEVEL_ATTEMPTS;
        } 
        else if (level.equals("hard")) {
            return HARD_LEVEL_ATTEMPTS;
        } 
        else {
            return setLevel();
        }

    }
    
    /**
     * userGuess seems to be external parameter, since you don't get it
     * directly from Game class, so would be nicer to pass it as parameter
     * Compare:
     * Game myGame = new Game();
     * int num = //get number from user
     * -----right now:
     * game.setUserGuess(num);
     * if (game.isValid()){...}
     * -----could be:
     * if (game.isValid(num)){...}
     */
    public int isValid() {
        if (userGuess > randomNum) {
            return -1;
        }
        if (userGuess < randomNum) {
            return 1;
        } 
        else {
            return 0;
        }
    }

}