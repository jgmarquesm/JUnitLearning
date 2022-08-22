package pilha.de.livros;

import java.util.ArrayList;

public class Pilha {

    final private int limite = 5;

    public int getLimite() {
        return limite;
    }

    ArrayList<Livro> pilhaDeLivros = new ArrayList<>();

    public void push(Livro livro){
        if (pilhaDeLivros.size() >= limite){ return;}
        if (!livro.getTitulo().startsWith("A") && !livro.getTitulo().startsWith("O")){return;}
        pilhaDeLivros.add(livro);
    }

    public String pop(){
        return pilhaDeLivros.get(pilhaDeLivros.size()-1).getTitulo();
    }

    public int count(){
        return pilhaDeLivros.size();
    }
}
