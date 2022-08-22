package fixtures;

import org.junit.jupiter.api.*;

public class TestMyFixture {

    @BeforeAll
    public static void setUpBeforeClass() {
        System.out.println("Esse método executa uma vez antes do primeiro teste.");
    }

    @AfterAll
    public static void setUpAfterClass() {
        System.out.println("Esse método executa uma vez depois do primeiro teste.");
    }

    @BeforeEach
    public void setUpBefore() {
        System.out.println("Esse método executa sempre antes de cada teste.");
    }

    @AfterEach
    public void setUpAfter() {
        System.out.println("Esse método executa sempre depois de cada teste.");
    }

    @Test
    public void test1(){
        System.out.println("-> Teste 1");
    }

    @Test
    public void test2(){
        System.out.println("-> Teste 2");
    }
}
