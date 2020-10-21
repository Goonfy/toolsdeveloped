package org.academiadecodigo.gnunas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HistogramInheritance extends HashMap<String, Integer> implements Iterable<String> {

    public void add(String words) {
        for (String word : words.split(" ")) {
            if (containsKey(word)) {
                put(word, get(word) + 1);
                continue;
            }

            put(word, 1);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return keySet().iterator();
    }
}
