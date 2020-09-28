package org.academiadecodigo.bootcamp54.guessanumber;

public class Player {
    private int guessedNumber;
    private int[] playerGuessedNumbersList;
    private static int[] guessedNumbersList;

    private String name;

    public Player(String name, int maxRounds) {
        this.name = name;

        this.playerGuessedNumbersList = new int[maxRounds];
        guessedNumbersList = new int[maxRounds];
    }

    public void guess(int minimum, int maximum, int roundNumber) {
        guessedNumber = Generator.getRandomNumber(minimum, maximum);
        playerGuessedNumbersList[roundNumber] = guessedNumber;
        guessedNumbersList[roundNumber] = guessedNumber;

        for (int i = 0; i < roundNumber; i++) {
            if (guessedNumber == playerGuessedNumbersList[i] || guessedNumber == guessedNumbersList[i]) {
                guess(minimum, maximum, roundNumber);
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getGuessedNumber() {
        return guessedNumber;
    }
}
