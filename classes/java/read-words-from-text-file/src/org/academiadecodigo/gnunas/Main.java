package org.academiadecodigo.gnunas;

public class Main {
    public static void main(String[] args) {
        WordReader wordReader = new WordReader();
        wordReader.readFileByLine("test.txt");

        for (String word : wordReader) {
            System.out.println(word);
        }
    }
}
