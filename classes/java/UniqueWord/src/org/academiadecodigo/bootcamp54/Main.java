package org.academiadecodigo.bootcamp54;

public class Main {
    private static final String STRING = "ola ola ola ola caramelo caramelo academia";

    public static void main(String[] args) {
        UniqueWord uniqueWord = new UniqueWord(STRING);

        for (String word : uniqueWord) {
            System.out.println(word);
        }
    }
}
