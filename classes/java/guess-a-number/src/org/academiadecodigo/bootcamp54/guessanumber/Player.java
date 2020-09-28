package org.academiadecodigo.bootcamp54.guessanumber;

public class Player {
    private int guessedNumber;
    private int[] guessedNumbersList;

    private String name;

    public Player(String name, int maxRounds) {
        this.name = name;

        this.guessedNumbersList = new int[maxRounds];
    }

    public void guess(int minimum, int maximum, int roundNumber) {
        guessedNumber = Generator.getRandomNumber(minimum, maximum);

        for (int i = 0; i < roundNumber; i++) {
            guessedNumbersList[roundNumber] = guessedNumber;

            if (guessedNumber == guessedNumbersList[i]) {
                guessedNumber = Generator.getRandomNumber(minimum, maximum);
                guessedNumbersList[roundNumber] = guessedNumber;

                i = 0;
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
