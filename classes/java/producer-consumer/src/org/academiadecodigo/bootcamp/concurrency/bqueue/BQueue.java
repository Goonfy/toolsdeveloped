package org.academiadecodigo.bootcamp.concurrency.bqueue;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Blocking Queue
 *
 * @param <T> the type of elements stored by this queue
 */
public class BQueue<T> {

    private final LinkedList<T> list;

    private final int limit;

    /**
     * Constructs a new queue with a maximum size
     *
     * @param limit the queue size
     */
    public BQueue(int limit) {

        list = new LinkedList<>();

        this.limit = limit;

    }

    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     *
     * @param data the data to add to the queue
     */
    public synchronized void offer(T data) {

        while (getSize() == getLimit()) {

            System.out.println("Queue is full, waiting...");

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " added: " + data);

        list.add(data);

        notifyAll();

    }

    /**
     * Retrieves and removes data from the head of the queue
     * Blocking operation if the queue is empty
     *
     * @return the data from the head of the queue
     */
    public synchronized T poll() {

        while (getSize() == 0) {

            System.out.println("Queue is empty, waiting...");

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        T removedIndex = list.remove();

        System.out.println(Thread.currentThread().getName() + " removed: " + removedIndex);

        notifyAll();

        return removedIndex;

    }

    /**
     * Gets the number of elements in the queue
     *
     * @return the number of elements
     */
    public int getSize() {
        //System.out.println("Tamanho: " + list.size());

        return list.size();

    }

    /**
     * Gets the maximum number of elements that can be present in the queue
     *
     * @return the maximum number of elements
     */
    public int getLimit() {

       return limit;

    }

}
