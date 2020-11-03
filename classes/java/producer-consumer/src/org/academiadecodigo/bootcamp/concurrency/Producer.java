package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

import java.util.Random;

/**
 * Produces and stores integers into a blocking queue
 */
public class Producer implements Runnable {

    private final BQueue<Integer> queue;
    private final int elementNum;

    /**
     * @param queue      the blocking queue to add elements to
     * @param elementNum the number of elements to produce
     */
    public Producer(BQueue<Integer> queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    @Override
    public void run() {
        for (int i = 0; i < elementNum; i++) {
            queue.offer(new Random().nextInt(20));
        }
    }

}
