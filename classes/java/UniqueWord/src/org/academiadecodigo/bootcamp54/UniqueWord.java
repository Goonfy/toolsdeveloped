package org.academiadecodigo.bootcamp54;

import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class UniqueWord implements Iterable<String> {

    private final TreeSet<String> treeSet;

    public UniqueWord(String word) {
        treeSet = new TreeSet<>();

        for (String w : word.split(" ")) {
            treeSet.add(w);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return treeSet.iterator();
    }
}
