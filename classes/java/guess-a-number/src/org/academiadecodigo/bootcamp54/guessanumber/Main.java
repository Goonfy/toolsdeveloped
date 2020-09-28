package org.academiadecodigo.bootcamp54.guessanumber;

public class Main {
    // TODO: have a game supporting any number of players - done
    // TODO: have a lower limit too (optional, default to 0) - done
    // TODO: have a maximum number of rounds - done
    // TODO: have players not repeating their guesses

    // TODO: make players not deaf - not repeating theirs or other players' guesses

    public static void main(String[] args) {
        Game game = new Game(0, 10, 10, 5);
        game.spawnPlayers();
        game.start();
    }
}
