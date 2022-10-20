import java.util.Scanner;

public class Player {
    private String playerName;
    private int counter;
    private int totalTries;

    public int getTotalTries() {
        return this.totalTries;
    }

    public void setTotalTries(int totalTries) {
        this.totalTries = totalTries;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void decrementCounter() {
        counter--;
    }
    public void incrementTotalTries() {
        totalTries++;
    }

    public void playerNameInput() {
        System.out.println("Enter your name: ");
        Scanner s = new Scanner(System.in);
        setPlayerName(s.nextLine());

    }

}
