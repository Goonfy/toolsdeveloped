package org.academiadecodigo.bootcamp.concurrency.bqueue;

/**
 * Blocking Queue
 *
 * @param <T> the type of elements stored by this queue
 */
public class BQueue<T> {

    private T head;

    private final int limit;
    private int size;

    /**
     * Constructs a new queue with a maximum size
     *
     * @param limit the queue size
     */
    public BQueue(int limit) {

        this.limit = limit;

    }

    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     *
     * @param data the data to add to the queue
     */
    public synchronized void offer(T data) {

        while (getSize() == 1) {
            System.out.println("Queue is full");

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " added: " + data);

        head = data;

        size++;

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
            System.out.println("Queue is empty");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " removed: " + head);

        size--;

        notifyAll();

        return head;

    }

    /**
     * Gets the number of elements in the queue
     *
     * @return the number of elements
     */
    public synchronized int getSize() {

        return size;

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
