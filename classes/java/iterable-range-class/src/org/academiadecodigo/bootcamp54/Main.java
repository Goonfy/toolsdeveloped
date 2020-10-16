package org.academiadecodigo.bootcamp54;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(1, 9);

        RangeIterator iterator = range.iterator();
        while (iterator.hasNext()){
            if (iterator.getCurrent() == 6) {
                iterator.remove();
            }

            iterator.next();
        }

        for (Integer r : range) {
            System.out.println(r);
        }
    }
}
