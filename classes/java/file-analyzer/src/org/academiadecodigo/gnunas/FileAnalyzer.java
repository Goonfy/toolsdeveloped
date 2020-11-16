package org.academiadecodigo.gnunas;

import org.academiadecodigo.gnunas.file.FileHandler;

import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class FileAnalyzer {

    private final FileHandler fileHandler;
    private final String path;

    public FileAnalyzer(FileHandler fileHandler, String path) {
        this.fileHandler = fileHandler;
        this.path = path;
    }

    public void printWords() throws IOException {
        fileHandler.getStream(path)
                .forEach(System.out::println);
    }

    public long countWords() throws IOException {
        return fileHandler.getStream(path)
                .count();
    }

    public Optional<String> getFirstWordLongerThan(int size) throws IOException {
        return fileHandler.getStream(path)
                .filter(s -> s.length() > size)
                .findFirst();
    }

    public void getTheLongestWords(int numberOfWords) throws IOException {
        fileHandler.getStream(path)
                .sorted((x, y) -> y.length() - x.length())
                .limit(numberOfWords)
                .forEach(System.out::println);
    }

    public void compareCommonWords(String fileToCompare) throws IOException {
        Set<String> set = fileHandler.getStream(fileToCompare).collect(Collectors.toSet());

        fileHandler.getStream(path)
                .distinct()
                .filter(set::contains)
                .forEach(System.out::println);
    }
}
