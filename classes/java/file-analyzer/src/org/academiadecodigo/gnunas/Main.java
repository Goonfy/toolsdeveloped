package org.academiadecodigo.gnunas;

import org.academiadecodigo.gnunas.file.FileHandler;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileAnalyzer fileAnalyzer = new FileAnalyzer(new FileHandler(), "text");

        try {
            fileAnalyzer.printWords();
            System.out.println("---------");
            System.out.println(fileAnalyzer.countWords());
            System.out.println("---------");
            fileAnalyzer.getFirstWordLongerThan(3).ifPresent(System.out::println);
            System.out.println("---------");
            fileAnalyzer.getTheLongestWords(3);
            System.out.println("---------");
            fileAnalyzer.compareCommonWords("text2");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
