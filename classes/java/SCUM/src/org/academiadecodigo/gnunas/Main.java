package org.academiadecodigo.gnunas;

public class Main {
    public static void main(String[] args) {
        MonoOperation<String> monoOperation = String::toUpperCase;
        BiOperation<String> biOperation = String::concat;

        Machine<String> machine = new Machine<>();
        System.out.println(machine.operation("test", monoOperation));
        System.out.println(machine.operation("test", "test", biOperation));
    }
}
