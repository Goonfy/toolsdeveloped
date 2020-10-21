package org.academiadecodigo.bootcamp54;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {

    private final Integer min;
    private final Integer max;

    private final boolean reversed;

    private int globalCurrent;

    private final List<Integer> linkedList;

    public Range(int min, int max, boolean reversed) {
        this.min = min;
        this.max = max;

        this.reversed = reversed;

        linkedList = new LinkedList<>();

        globalCurrent = 0;
    }

    public Iterator<Integer> iterator() {
        return reversed ? new Iterator<>() {
            private int current = max + 1;

            @Override
            public boolean hasNext() {
                return current > min;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                for (int l : linkedList) {
                    if (l == current) {
                        --current;
                    }
                }

                return globalCurrent = --current;
            }

            @Override
            public void remove() {
                linkedList.add(current);
            }

        } : new Iterator<>() {
            private int current = min - 1;

            @Override
            public boolean hasNext() {
                return current < max;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                for (int l : linkedList) {
                    if (l == current) {
                        ++current;
                    }
                }

                return globalCurrent = ++current;
            }

            @Override
            public void remove() {
                linkedList.add(current);
            }
        };
    }

    public int getCurrent() {
        return globalCurrent;
    }
}
