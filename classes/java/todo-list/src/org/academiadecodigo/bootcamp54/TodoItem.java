package org.academiadecodigo.bootcamp54;

public class TodoItem implements Comparable<TodoItem> {

    private final Importance importance;
    private final Integer priority;
    private final String todoMessage;

    public TodoItem(Importance importance, int priority, String todoMessage) {
        this.importance = importance;
        this.priority = priority;
        this.todoMessage = todoMessage;
    }

    @Override
    public int compareTo(TodoItem o) {

        if (importance.compareTo(o.importance) == 0) {
            return priority.compareTo(o.priority);
        }

        return importance.compareTo(o.importance);
    }

    @Override
    public String toString() {
        
        return "TodoItem{" +
                "priorityType=" + importance +
                ", priority=" + priority +
                ", todoMessage='" + todoMessage + '\'' +
                '}';
    }
}
