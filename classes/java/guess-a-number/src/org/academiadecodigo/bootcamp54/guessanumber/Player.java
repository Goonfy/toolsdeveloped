package org.academiadecodigo.bootcamp54.guessanumber;

public class Player {
    private int guessedNumber;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void guess(int minimum, int maximum) {
        guessedNumber = Generator.getRandomNumber(minimum, maximum);
    }

    public String getName() {
        return name;
    }

    public int getGuessedNumber() {
        return guessedNumber;
    }
}
