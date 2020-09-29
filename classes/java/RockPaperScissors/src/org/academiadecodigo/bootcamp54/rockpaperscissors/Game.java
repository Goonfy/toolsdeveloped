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

        endGame();
    }

    private void checkWinCondition(Hand playerOneHand, Hand playerTwoHand) {
        if (playerOneHand == playerTwoHand) {
            System.out.println("It's a tie!!!");
            return;
        }

        Player winner = playerOne;

        switch (playerOneHand) {
            case SCISSORS:
                winner = playerTwoHand == Hand.PAPER ? playerOne : playerTwo;
                break;
            case PAPER:
                winner = playerTwoHand == Hand.ROCK ? playerOne : playerTwo;
                break;
            case ROCK:
                winner = playerTwoHand == Hand.SCISSORS ? playerOne: playerTwo;
                break;
        }

        winner.win();
        System.out.println("Player " + winner.getName() + " Wins the round!!!");
    }

    private void endGame() {
        Player winner = playerOne;

        if (playerOne.getScore() < playerTwo.getScore()) { winner = playerTwo; }

        System.out.println("Player " + winner.getName() + " Wins the game!!!");
    }
}
