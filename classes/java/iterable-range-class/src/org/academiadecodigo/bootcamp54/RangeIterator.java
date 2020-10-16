package org.academiadecodigo.bootcamp54;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RangeIterator implements Iterator<Integer> {

    private final Range range;

    private Integer current;

    public RangeIterator(Range range) {
        current = range.getMin() - 1;

        this.range = range;
    }

    @Override
    public boolean hasNext() {
        return current < range.getMax();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        for (int l : range.getLinkedList()) {
            if (l == current) {
                current++;
            }
        }

        return ++current;
    }

    @Override
    public void remove() {
        range.linkedListAdd(current);
    }

    public Integer getCurrent() {
        return current;
    }
}
