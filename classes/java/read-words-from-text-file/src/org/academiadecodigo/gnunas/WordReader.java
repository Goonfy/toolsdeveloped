package org.academiadecodigo.gnunas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class WordReader implements Iterable<String> {
    private final LinkedList<String> wordsList;

    public WordReader() {
        wordsList = new LinkedList<>();
    }

    public void readFileByLine(String file) {
        try {
            FileReader reader = new FileReader(file);

            BufferedReader bReader = new BufferedReader(reader);

            String line;

            while ((line = bReader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.isEmpty()) {
                        continue;
                    }

                    wordsList.add(word);
                }
            }

            bReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Iterator<String> iterator() {
        return wordsList.iterator();
    }
}
