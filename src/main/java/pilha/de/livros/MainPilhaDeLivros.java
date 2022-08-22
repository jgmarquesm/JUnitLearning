package pilha.de.livros;

public class MainPilhaDeLivros {
    public static void main(String[] args) {

        testPilhaDeLivros testPilhaDeLivros = new testPilhaDeLivros();
        System.out.printf("Segue Padrão de tamanho? %b.%n", testPilhaDeLivros.testNaoAddAlemDoLimite());
        System.out.printf("Retira último? %b.%n", testPilhaDeLivros.testRetiraUltimoLivroInserido());
        System.out.printf("Segue padrão de nome? %b.%n", testPilhaDeLivros.testNaoAddForaPadraoNome());

    }
}
