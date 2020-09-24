package org.academiadecodigo.bootcamp54.calculator;

public class Calculator {
    public String color;
    public String brand;

    public Calculator(String color, String brand) {
        this.color = color;
        this.brand = brand;
    }

    public int add(int n1, int n2) {
        return n1 + n2;
    }

    public float add(float n1, float n2) {
        return n1 + n2;
    }
}
