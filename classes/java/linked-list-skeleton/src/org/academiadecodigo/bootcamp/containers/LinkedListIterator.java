package org.academiadecodigo.bootcamp.containers;

import org.academiadecodigo.bootcamp.containers.LinkedList.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        node = node.getNext();
        return node.getData();
    }

    @Override
    public void remove() {
        linkedList.remove(node.getData());
    }

    public T getData() {
        return node.getData();
    }
}
