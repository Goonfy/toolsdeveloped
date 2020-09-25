package org.academiadecodigo.bootcamp54.guessanumber;

import java.lang.reflect.Array;

public class Main {

    // TODO: have a game supporting any number of players - almost done
    // TODO: have a lower limit too (optional, default to 0) - almost done
    // TODO: have a maximum number of rounds - done
    // TODO: have players not repeating their guesses

    // TODO: make players not deaf - not repeating theirs or other players' guesses

    public static void main(String[] args) {
        int numberOfPlayers = 5;
        Player[] players = new Player[numberOfPlayers];

        for (int i = 0; i < players.length; i++) {
            players[i] = new Player("Player" + i);
        }

        Game game = new Game(0, 10, 10, players);
        game.start();
    }
}
