package org.academiadecodigo.gnunas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Histogram implements Iterable<String> {

    private final Map<String, Integer> mapList;

    public Histogram() {
        mapList = new HashMap<>();
    }

    public void add(String words) {
        for (String word : words.split(" ")) {
            if (mapList.containsKey(word)) {
                mapList.put(word, mapList.get(word) + 1);
                continue;
            }

            mapList.put(word, 1);
        }
    }

    public int get(String words) {
        return mapList.get(words);
    }

    @Override
    public Iterator<String> iterator() {
        return mapList.keySet().iterator();
    }
}
