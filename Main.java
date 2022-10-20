import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game myGame = new Game();
        Player myPlayer = new Player();
        myPlayer.playerNameInput();
        myGame.gameStarter();
        myPlayer.setTotalTries(myGame.setLevel());
                while (myGame.getUserGuess() != myGame.getRandomNum()) {
                    System.out.println("You have " +  myPlayer.getCounter() + " attempts to guess the number.");
                    System.out.print("Make a guess : ");
                    Scanner sn = new Scanner(System.in);
                    myGame.setUserGuess(sn.nextInt());
                        if (myGame.isValid() == 0) {
                            System.out.println("You won, " + myPlayer.getPlayerName() + "! Number is correct");
                            System.out.println("It took you " +myPlayer.getTotalTries() +" attempts to guess the number");
                            break;
                        }
                        if ( myPlayer.getTotalTries() <= 1) {
                            System.out.println("You've run out of guesses, " + myPlayer.getPlayerName() + " .You lost.");
                            break;
                        }
                        else if (myGame.isValid() == -1) {
                            System.out.println("Wrong! your guess is higher. Try lower ");
                            myPlayer.decrementCounter();
                            myPlayer.incrementTotalTries();
                        }
                        else if (myGame.isValid() == 1){
                            System.out.println("Wrong! your guess is lower. Try higher ");
                            myPlayer.decrementCounter();
                            myPlayer.incrementTotalTries();
                        }

                }
    }
}