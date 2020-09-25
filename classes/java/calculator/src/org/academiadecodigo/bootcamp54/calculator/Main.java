package org.academiadecodigo.bootcamp54.calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator("gray", "tlintaetles");

        System.out.println("Sum: " + calculator.add(1, 1));
        System.out.println("Sum float: " + calculator.add(1.4f, 2.5f));

        System.out.println("Divide: " + calculator.divide(1, 1));
        System.out.println("Divide float: " + calculator.divide(1.4f, 2.5f));

        System.out.println("Subtract: " + calculator.subtract(1, 1));
        System.out.println("Subtract float: " + calculator.subtract(1.4f, 2.5f));

        System.out.println("Multiply: " + calculator.multiply(1, 1));
        System.out.println("Multiply float: " + calculator.multiply(1.4f, 2.5f));

        System.out.println("Brand: " + calculator.brand + " Color: " + calculator.color);
    }
}