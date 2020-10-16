package org.academiadecodigo.bootcamp.containers;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("aflsfsa");
        linkedList.add("wewrwr");
        linkedList.add("ssfsf");

        LinkedListIterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            iterator.next();

            if (iterator.getData().equals("aflsfsa")) {
                iterator.remove();
            }

            //iterator.next();
        }

        for (String s : linkedList) {
            System.out.println(s);
        }
    }
}
