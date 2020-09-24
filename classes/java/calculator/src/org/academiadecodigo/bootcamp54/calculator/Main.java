package org.academiadecodigo.bootcamp54.calculator;

public class Main {
    public static void main(String[] args) {
        Calculator chinese = new Calculator("gray", "tlintaetles");
        Calculator spanish = new Calculator("amarilho", "cucaracha");

        System.out.println(chinese.add(1, 1));
        System.out.println(spanish.add(1.4f, 2.5f));

        System.out.println("Brand: " + spanish.brand + " Color: " + spanish.color);
        System.out.println("Brand: " + chinese.brand + " Color: " + chinese.color);
    }
}