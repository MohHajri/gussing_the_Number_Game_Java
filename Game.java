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

    static Scanner scan = new Scanner(System.in);
    static Random obj = new Random();
    static int EASY_LEVEL_ATTEMPTS = 15;
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

    public void gameStarter() {
        System.out.println("YOU ARE NOW PLAYING GUESS THE NUMBER GAME!");
        System.out.println("YOU HAVE LIMITED TRIES! BE CAREFUL. LET'S START ..");
        System.out.println("----------------------------------------------");
        System.out.println("Select the level of the game: hard, easy or medium");
        System.out.println("In the easy level, you have 15 guesses.");
        System.out.println("In the hard level, you have 3 guesses..");
        System.out.println("In the medium level, you have 7 guesses.");
    }

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