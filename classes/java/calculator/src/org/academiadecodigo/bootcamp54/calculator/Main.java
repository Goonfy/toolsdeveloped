package org.academiadecodigo.bootcamp54.calculator;

public class Main {
    public static void main(String[] args) {
        Calculator chinese = new Calculator();
        Calculator spanish = new Calculator();

        chinese.brand = "tlintaetles";
        chinese.color = "gray";

        spanish.brand = "cucaracha";
        spanish.color = "amarilho";

        chinese.add(1, 1);

        System.out.println(spanish.brand + " " + spanish.color);
        System.out.println(chinese.brand + " " + chinese.color);
    }
}