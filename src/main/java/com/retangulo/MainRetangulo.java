package com.retangulo;

public class MainRetangulo {
    public static void main(String[] args) {

        testRetangulo testRetangulo = new testRetangulo();
        System.out.printf("Teste Área passou? %b.%n", testRetangulo.testCalcularArea());
        System.out.printf("Teste Perímetro passou? %b.%n", testRetangulo.testCalcularPerimetro());
    }
}
