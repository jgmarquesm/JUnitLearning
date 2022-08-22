package calculadora;

public class testCalculadora {

    private Calculadora calculadora;

    public void testSomar() {

        // Arrange
        calculadora = new Calculadora();
        int resultadoEsperado = 10;

        // Act
        int resultado = calculadora.somar(7, 3);

        // Assert
        if (resultado == resultadoEsperado){
            System.out.println("Passou.");
        } else {
            System.out.println("Falhou.");
        }
    }
}

