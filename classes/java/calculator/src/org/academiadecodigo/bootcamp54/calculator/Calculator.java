package org.academiadecodigo.bootcamp54.calculator;

public class Calculator {
    public String color;
    public String brand;

    public Calculator(String color, String brand) {
        this.color = color;
        this.brand = brand;
    }

    public int add(int n1, int n2) { return n1 + n2; }
    public float add(float n1, float n2) { return n1 + n2; }

    public int divide(int n1, int n2) { return n1 / n2; }
    public float divide(float n1, float n2) { return n1 / n2; }

    public int subtract(int n1, int n2) { return n1 - n2; }
    public float subtract(float n1, float n2) { return n1 - n2; }

    public int multiply(int n1, int n2) { return n1 * n2; }
    public float multiply(float n1, float n2) { return n1 * n2; }
}
