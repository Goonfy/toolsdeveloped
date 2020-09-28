package org.academiadecodigo.bootcamp54.rockpaperscissors;

public class Game {
    private final Player playerOne;
    private final Player playerTwo;

    private final int bestOf;

    public Game(int bestOf) {
        this.playerOne = new Player("Esdrubal");
        this.playerTwo = new Player("Antonieta");

        this.bestOf = bestOf;
    }

    public void start() {
        while (playerOne.getScore() <= bestOf / 2 && playerTwo.getScore() <= bestOf / 2) {
            Hand playerOneHand = playerOne.chooseHand();
            Hand playerTwoHand = playerTwo.chooseHand();

            checkWinCondition(playerOneHand, playerTwoHand);
        }

        if (playerOne.getScore() > playerTwo.getScore()) {
            System.out.println("Player " + playerOne.getName() + " Wins the game!!!");

            return;
        }

        System.out.println("Player " + playerTwo.getName() + " Wins the game!!!");
    }

    private void checkWinCondition(Hand playerOneHand, Hand playerTwoHand) {
        if (playerOneHand == playerTwoHand) {
            System.out.println("It's a tie!!!");

            return;
        }

        if (playerOneHand == Hand.PAPER && playerTwoHand == Hand.ROCK) {
            playerOne.win();
            System.out.println("Player " + playerOne.getName() + " Wins the round!!!");

            return;
        }
        else if (playerOneHand == Hand.ROCK && playerTwoHand == Hand.SCISSORS) {
            playerOne.win();
            System.out.println("Player " + playerOne.getName() + " Wins the round!!!");

            return;
        }
        else if (playerOneHand == Hand.SCISSORS && playerTwoHand == Hand.PAPER) {
            playerOne.win();
            System.out.println("Player " + playerOne.getName() + " Wins the round!!!");

            return;
        }

        playerTwo.win();
        System.out.println("Player " + playerTwo.getName() + " Wins the round!!!");
    }
}
