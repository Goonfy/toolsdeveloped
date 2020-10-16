package org.academiadecodigo.bootcamp54;

import java.util.Iterator;
import java.util.LinkedList;

public class Range implements Iterable<Integer> {

    private final Integer min;
    private final Integer max;

    private final LinkedList<Integer> linkedList;

    public Range(int min, int max) {
        this.min = min;
        this.max = max;

        linkedList = new LinkedList<>();
    }

    @Override
    public RangeIterator iterator() {
        return new RangeIterator(this);
    }

    public Integer getMax() {
        return max;
    }

    public Integer getMin() {
        return min;
    }

    public void linkedListAdd(Integer number) {
        linkedList.add(number);
    }

    public LinkedList<Integer> getLinkedList() {
        return linkedList;
    }
}
