package org.academiadecodigo.bootcamp54;

public class Main {

    public static void main(String[] args) {

        TodoList todoList = new TodoList();

        todoList.add(Importance.HIGH, 1, "Go Shopping");
        todoList.add(Importance.LOW, 1, "Clean House");
        todoList.add(Importance.MEDIUM, 1, "Go to Gym");
        todoList.add(Importance.HIGH, 3, "Play computer");
        todoList.add(Importance.HIGH, 2, "Play soccer");
        todoList.add(Importance.HIGH, 4, "Play tenis");
        todoList.add(Importance.MEDIUM, 1, "Throw away garbage");

        while (!todoList.getIsEmpty()) {
            System.out.println(todoList.getRemove());
        }
    }
}
