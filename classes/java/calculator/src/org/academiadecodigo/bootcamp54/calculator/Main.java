package org.academiadecodigo.bootcamp54.calculator;

public class Main {
    public static void main(String[] args) {
        Calculator chinese = new Calculator("gray", "tlintaetles");
        Calculator spanish = new Calculator("amarilho", "cucaracha");

        System.out.println("Sum: " + chinese.add(1, 1));
        System.out.println("Sum float: " + spanish.add(1.4f, 2.5f));

        System.out.println("Divide: " + chinese.divide(1, 1));
        System.out.println("Divide float: " + spanish.divide(1.4f, 2.5f));

        System.out.println("Subtract: " + chinese.subtract(1, 1));
        System.out.println("Subtract float: " + spanish.subtract(1.4f, 2.5f));

        System.out.println("Multiply: " + chinese.multiply(1, 1));
        System.out.println("Multiply float: " + spanish.multiply(1.4f, 2.5f));

        System.out.println("Brand: " + spanish.brand + " Color: " + spanish.color);
        System.out.println("Brand: " + chinese.brand + " Color: " + chinese.color);
    }
}