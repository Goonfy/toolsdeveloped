package org.academiadecodigo.bootcamp54.rockpaperscissors;

public class Player {
    private final String name;

    private int score;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Hand chooseHand() {
        return Hand.values()[(int)(Math.random() * Hand.values().length)];
    }

    public void win() {
        score++;
    }

    public int getScore() {
        return score;
    }
}
