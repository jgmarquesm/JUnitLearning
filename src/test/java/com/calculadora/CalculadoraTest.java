package com.calculadora;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/* Opções de ordenação:
- Usando nome do método testado: @TestMethodOrder(MethodOrderer.MethodName.class)
- Usando Order Anontation: @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
- De forma pseudo aleatória: @TestMethodOrder(MethodOrderer.Random.class)

Aqui usarei Order Annotation
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculadoraTest {

    private static Calculadora calc;

    @BeforeAll
    public static void setUp(){
        calc = new Calculadora();
    }

    @AfterAll
    public static void tearDown() {
        calc = null;
    }

    @Test
    @Order(1)
    void somar25() {
        double resultadoEsperado = 25;
        double resultado = calc.somar(11, 14);

        assertEquals(resultado, resultadoEsperado); // -> 6ms;
        /* Nesse exemplo, podemos ver que é mais eficiente, NESSE CASO, usar o assertEqual ao inves do assertTrue.
        Poderia ter sido feito assim:

        Calculadora calc = new Calculadora();
        assertEquals(25, calc.somar(11, 14));

        */
    }

    @Test
    @Order(2)
    void somar20(){
        double resultadoEsperado = 20;
        double resultado = calc.somar(9.0, 11);

        assertTrue(resultado == resultadoEsperado); // -> 50 ms
    }

    @Test
    @Order(3)
    @DisplayName("Exemplo Display: somar negativos")
    void somarNegativos(){
        assertEquals(-10, calc.somar(-1, -9));
    }

    // Podemos ainda fazer todos esses testes acima em somente um...
    @Test
    @Order(7)
    @DisplayName("Teste várias Somas")
    void somar(){
        assertAll(() -> assertEquals(25, calc.somar(11, 14)),
                () -> assertEquals(20, calc.somar(9, 11)),
                () -> assertEquals(-10, calc.somar(-1, -9)),
                () -> assertEquals(1, calc.somar(1, 1)) // Falha
        );
    }

    /*
    No último teste tivemos o seguinte resultado:

    expected: <1> but was: <2>
    Comparison Failure:
    Expected :1
    Actual   :2

    Mostarndo que apenas um dos teste, o indicado, falhou;
    */

    @Test
    @Order(4)
    @DisplayName("Divisão por zero")
    void testDividirPorZero(){
        try {
            calc.dividir(9, 0);
            // Nesse caso não precisamos explicitar o fail() pois o compilador Java já dispara a excessão
            // quando tentamos fazer a divisão por zero.
        } catch (ArithmeticException e) {
            assertTrue(true);
        }
    }

    @Test
    @Order(5)
    @DisplayName("Divisão")
    void testDivisao(){
        assertAll(() -> assertEquals(10.0, calc.dividir(100, 10)),
                () -> assertEquals(2, calc.dividir(4, 2)),
                () -> assertEquals(1, calc.dividir(20, 20))
        );
    }

    @Test
    @Order(8)
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    @DisplayName("Falhando Time Out Test")
    void testTimeOutFail(){
        assertEquals(1, calc.timeOutOperation(10));
    }

    @Test
    @Order(6)
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    @DisplayName("Teste Time Out")
    void testTimeOut(){
             assertEquals(1, calc.timeOutOperation(3));
    }
}