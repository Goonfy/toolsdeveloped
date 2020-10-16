package org.academiadecodigo.bootcamp54;

import java.util.PriorityQueue;

public class TodoList {

    private PriorityQueue<TodoItem> priorityQueue;

    public TodoList() {
        priorityQueue = new PriorityQueue<>();
    }

    public void add(Importance importance, int priority, String todoMessage) {
        priorityQueue.add(new TodoItem(importance, priority, todoMessage));
    }

    public TodoItem getRemove() {
        return priorityQueue.remove();
    }

    public boolean getIsEmpty() {
        return priorityQueue.isEmpty();
    }
}
