package com.calculadora;

public class testCalculadora {

    private Calculadora calculadora;

    public void testSomar() {

        // Arrange
        calculadora = new Calculadora();
        double resultadoEsperado = 10;

        // Act
        double resultado = calculadora.somar(7, 3);

        // Assert
        if (resultado == resultadoEsperado){
            System.out.println("Passou.");
        } else {
            System.out.println("Falhou.");
        }
    }
}

