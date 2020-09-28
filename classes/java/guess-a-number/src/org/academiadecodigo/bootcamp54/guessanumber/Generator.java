package org.academiadecodigo.bootcamp54.guessanumber;

public class Generator {
    public static int getRandomNumber(int minimum, int maximum) {
        return (int)(Math.random() * (maximum - minimum) + minimum);
    }
}
