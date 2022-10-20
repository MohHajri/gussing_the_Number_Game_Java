import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game myGame = new Game();
        Player myPlayer = new Player();
        myPlayer.playerNameInput(); // could read user name from Main and then assign it to player.
        myGame.gameStarter(); // could implement function that only prints intro in Main.
        myPlayer.setTotalTries(myGame.setLevel()); // The logic of storing total tries in user is working, but
                                                   // it seems to be broken ideologically. because each time game ends
                                                   // user has no total tries, but it still exists, so to renew it you need to 
                                                   // create a new game. And rn Game and Player are not related anyhow!!!
        // Problems with formatting.
                while (myGame.getUserGuess() != myGame.getRandomNum()) {
                    System.out.println("You have " +  myPlayer.getCounter() + " attempts to guess the number.");
                    System.out.print("Make a guess : ");
                    Scanner sn = new Scanner(System.in);
                    myGame.setUserGuess(sn.nextInt());
                    // problems with formatting.
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
                            // So what happens here:
                            //     You get user input - not related to game
                            //     You check intput - related to game
                            //     You take actions dependent on input - related to game
                            //     You change tries amount - related to the game
                            // Conclusion - you have a lot of game related logic outside of Game class.
                            // Try to use Main to get input and then call only the Game functions that are depend
                            // on input
                            System.out.println("Wrong! your guess is higher. Try lower ");
                            myPlayer.decrementCounter();
                            myPlayer.incrementTotalTries();
                        }
                        else if (myGame.isValid() == 1){
                            System.out.println("Wrong! your guess is lower. Try higher ");
                            // These 2 lines are repeating in previous if so could be moved outside of it
                            myPlayer.decrementCounter();
                            myPlayer.incrementTotalTries();
                        }

                }
    }
}