package pilha.de.livros;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class PilhaTest {

    private static Pilha pilha;
    static IPilhaDAO pilhaDAO = mock(IPilhaDAO.class);

    @BeforeAll
    public static void setUpBeforeClass() {
        pilha = new Pilha(pilhaDAO);
    }

    @BeforeEach
    void setUp() {
        Livro livro1 = new Livro("A Bela e a Fera");
        Livro livro2 = new Livro("A queda dos mundos");
        Livro livro3 = new Livro("O pequeno príncipe");
        Livro livro4 = new Livro("Os indesejáveis");
        Livro livro5 = new Livro("A muralha");

        pilha.push(livro1);
        pilha.push(livro2);
        pilha.push(livro3);
        pilha.push(livro4);
        pilha.push(livro5);
    }

    @AfterEach
    void tearDown() {
        int i = pilha.count();
        while (i > 0) {
            pilha.pop();
            i--;
        }
    }

    @AfterAll
    public static void tearDownAfterClass() {
        pilha = null;
    }

    @Test
    @DisplayName("Teste NÃO add além do limite")
    void testNaoAddAlemDoLimite() {
        try {
            pilha.push(new Livro("O livro teste"));
            fail();
        } catch (ArrayStoreException e) {
            assertTrue(true);
        }
    }

    @Test
    @DisplayName("Teste Padrão de nome")
    void testNaoAddForaPadraoNome() {
        pilha.pop();
        pilha.push(new Livro("Clean Code"));
        Livro livro = pilha.pop();

        assertEquals("Os indesejáveis", livro.getTitulo());
    }

    @Test
    @DisplayName("Teste de Limite")
    void testLimiteDaPilha(){
        assertEquals(5, pilha.getLimite());
    }
}