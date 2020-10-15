package org.academiadecodigo.bootcamp.containers;

import org.academiadecodigo.bootcamp.containers.LinkedList.Node;

import java.util.Iterator;

public class LinkedListIterator<T> implements Iterator<T> {
    private final LinkedList<T> linkedList;

    private Node<T> node;

    public LinkedListIterator(LinkedList<T> linkedList) {
        node = linkedList.getHead();

        this.linkedList = linkedList;
    }

    @Override
    public boolean hasNext() {
        return node.getNext() != null;
    }

    @Override
    public T next() {
        if (node.getNext() == null) {
            return node.getData();
        }

        node = node.getNext();
        return node.getData();
    }

    @Override
    public void remove() {
        node = node.getNext();
        linkedList.remove(node.getData());
    }
}
