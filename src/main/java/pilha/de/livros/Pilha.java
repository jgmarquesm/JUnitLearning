package pilha.de.livros;

import java.util.ArrayList;

public class Pilha {

    final private int limite = 5;

    public int getLimite() {
        return limite;
    }

    ArrayList<Livro> pilhaDeLivros = new ArrayList<>();

    public void push(Livro livro){
        if (pilhaDeLivros.size() >= limite){ throw new ArrayStoreException();}
        if (!livro.getTitulo().startsWith("A") && !livro.getTitulo().startsWith("O")){ return;}
        pilhaDeLivros.add(livro);
    }

    public Livro pop(){
        Livro livro = pilhaDeLivros.get(pilhaDeLivros.size()-1);
        pilhaDeLivros.remove(pilhaDeLivros.size()-1);
        return livro;
    }

    public int count(){
        return pilhaDeLivros.size();
    }
}
