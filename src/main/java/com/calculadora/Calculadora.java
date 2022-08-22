package com.calculadora;

public class Calculadora {
    public double somar(double a, double b) {
        return a + b;
    }

    public double dividir(double a, double b){
        if(b == 0) { throw new ArithmeticException();}
        return a / b;
    }

    public int timeOutOperation(int n){
        while (n > 0){
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                return 1;
            }
            n--;
        }
        return 1;
    }
}