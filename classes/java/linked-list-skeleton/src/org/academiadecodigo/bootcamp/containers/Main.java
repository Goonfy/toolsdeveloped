package org.academiadecodigo.bootcamp.containers;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("aflsfsa");
        linkedList.add("wewrwr");
        linkedList.add("ssfsf");

        Iterator<String> iterator = linkedList.iterator();
        for (String s : linkedList) {
            if (s.equals("ssfsf")) {
                iterator.remove();
            }

            iterator.next();
        }

        for (String s : linkedList) {
            System.out.println(s);
        }
    }
}
