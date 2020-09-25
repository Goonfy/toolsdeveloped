package org.academiadecodigo.bootcamp54.guessanumber;

public class Game {
    private int minimum;
    private int maximum;

    private int maxRounds;

    private Player[] players;

    public Game(int minimum, int maximum, int maxRounds, Player[] players) {
        this.minimum = minimum;
        this.maximum = maximum;

        this.maxRounds = maxRounds;

        this.players = players;
    }

    public void start() {
        int numberToGuess = Generator.getRandomNumber(minimum, maximum);
        System.out.println("Number to guess: " + numberToGuess);

        for (int i = 0; i < maxRounds; i++) {
            for (Player player : players) {
                player.guess(minimum, maximum);
                System.out.println("Number " + player.getName() + " guessed: " + player.getGuessedNumber());

                if (player.getGuessedNumber() == numberToGuess) {
                    System.out.println(player.getName() + " Wins!!!");

                    return;
                }
            }
        }

        System.out.println("No one guessed right!!");
    }
}
