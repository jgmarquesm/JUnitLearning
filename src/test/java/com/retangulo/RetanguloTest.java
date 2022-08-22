package com.retangulo;

// Testes parametrizados

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RetanguloTest {

    private static Retangulo retangulo;

    // Quando vamos fazer um teste quem que o assert é Equals, devemos usar o CsvSource, pois ele possibilita a passagem
    // de múltiplos paramentros, e mesmo que o método ou o construtor receba somente um, temos que receber de alguma forma
    // o resultado esperado, por isso ele é recomendado.
    @ParameterizedTest(name = "test-{index}: Base: {0} * Altura: {1} -> Área: {2}.")
    @CsvSource({"10, 20, 200", "4, 5, 20", "20, 2, 40", "99, 1, 99", "13, 15, 195"})
    @DisplayName("Teste de Área")
    @Order(1)
    void testArea(double base, double altura, double area) {

        retangulo = new Retangulo(base, altura);
        assertEquals(area, retangulo.area());
    }

    @ParameterizedTest(name = "test-{index}: Base: {0} * Altura: {1} -> Perímetro: {2}.")
    @CsvSource({"10, 20, 60", "4, 5, 18", "20, 2, 44", "99, 1, 200", "13, 15, 56"})
    @DisplayName("Teste de Perímetro")
    @Order(2)
    void testPerimetro(double base, double altura, double perimetro) {

        retangulo = new Retangulo(base, altura);
        assertEquals(perimetro, retangulo.perimetro());
    }

    /*
    Quando formos fazer um assertTrue passando apenas um valor, não precisamos usar o CsvSource, podemos usar o
    ValueSource e passar um set de valores.
    Exemplo:

    public boolean isOdd(int num){ return num % 2 == 0; }

    @ParameterizedTest(name = "test-{index}: O número {0} é par.")
    @ValueSource(ints = {1, 2, 4, 5, 7, 10, 12, 14, 18, 16})
    @DisplayName("É par?")
    @Order(3)
    void testIsOdd(int num){ assertTrue(isOdd(num)); }
    */
}