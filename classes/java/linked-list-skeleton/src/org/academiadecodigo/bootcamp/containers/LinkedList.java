package org.academiadecodigo.bootcamp.containers;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    private final Node<T> head;
    private int length = 0;

    public LinkedList() {
        this.head = new Node<>(null);
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     * @param data the element to add
     */
    public void add(T data)  {

        Node<T> node = new Node<>(data);
        Node<T> iterator = head;
        while (iterator.getNext() != null){
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     * @param index the index of the element
     * @return the element
     */
    public T get(int index) {
        if (index >= length) {
            return null;
        }

        Node<T> iterator = head;
        int i = 0;

        while (iterator.getNext() != null) {
            iterator = iterator.getNext();

            if (i == index) {
                return iterator.getData();
            }

            i++;
        }

        return null;
    }

    /**
     * Returns the index of the element in the list
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(T data) {
        Node<T> iterator = head;
        int i = 0;

        while (iterator.getNext() != null) {
            if (iterator.getNext().getData() == data) {
                return i;
            }

            iterator = iterator.getNext();

            i++;
        }

        return -1;
    }

    /**
     * Removes an element from the list
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(T data) {
        if (size() <= 0) {
            return false;
        }

        Node<T> iterator = head;

        while (iterator.getNext() != null) {
            if (iterator.getNext().getData() == data) {
                length--;

                iterator.setNext(iterator.getNext().getNext());

                return true;
            }

            iterator = iterator.getNext();
        }

        return false;
    }

    public Node<T> getHead() {
        return head;
    }

    @Override
    public LinkedListIterator<T> iterator() {
        return new LinkedListIterator<>(this);
    }

    public static class Node<Y> {

        private Y data;
        private Node<Y> next;

        public Node(Y data) {
            this.data = data;
            next = null;
        }

        public Y getData() {
            return data;
        }

        public void setData(Y data) {
            this.data = data;
        }

        public Node<Y> getNext() {
            return next;
        }

        public void setNext(Node<Y> next) {
            this.next = next;
        }
    }

}
