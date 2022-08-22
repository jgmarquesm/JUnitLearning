package pilha.de.livros;

public class testPilhaDeLivros {


    public boolean testRetiraUltimoLivroInserido(){

        Pilha pilhaDeLivros = new Pilha();
        Livro livro;

        livro = new Livro("A culpa é das estrelas");
        pilhaDeLivros.push(livro);

        livro = new Livro("O pequeno Príncipe");
        pilhaDeLivros.push(livro);

        livro = new Livro("A cabana");
        pilhaDeLivros.push(livro);

        String resultadoEsperado = "A cabana";
        return pilhaDeLivros.pop().equals(resultadoEsperado);
    }

    public boolean testNaoAddAlemDoLimite(){

        Pilha pilhaDeLivros = new Pilha();
        Livro livro;

        livro = new Livro("A culpa é das estrelas");
        pilhaDeLivros.push(livro);

        livro = new Livro("O pequeno Príncipe");
        pilhaDeLivros.push(livro);

        livro = new Livro("A cabana");
        pilhaDeLivros.push(livro);

        livro = new Livro("O naufrago");
        pilhaDeLivros.push(livro);

        livro = new Livro("O melhor livro");
        pilhaDeLivros.push(livro);

        livro = new Livro("O livro acima do limite");
        pilhaDeLivros.push(livro);

        return pilhaDeLivros.count() == pilhaDeLivros.getLimite();
    }

    public boolean testNaoAddForaPadraoNome(){

        Pilha pilhaDeLivros = new Pilha();
        Livro livro;

        livro = new Livro("A culpa é das estrelas");
        pilhaDeLivros.push(livro);

        livro = new Livro("O pequeno Príncipe");
        pilhaDeLivros.push(livro);

        livro = new Livro("Clean Code");
        pilhaDeLivros.push(livro);

        String resultadoEsperado = "O pequeno Príncipe";
        return pilhaDeLivros.pop().equals(resultadoEsperado);
    }
}
