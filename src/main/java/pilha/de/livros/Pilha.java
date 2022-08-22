package pilha.de.livros;

import java.util.ArrayList;

public class Pilha {

    final private int limite = 5;
    public int getLimite() {
        return limite;
    }

    ArrayList<Livro> pilhaDeLivros = new ArrayList<>();

    /*PilhaDAO pilhaDAO = new PilhaDAO(); -> Criamos uma interface IPilhaDAO que tem os métodos necessaários em PilhaDAO
    e então implementamos uma Classe Falsa com esses métodos falsos para substituir na nossa classe e realizar os testes
    unitários.
    A Classe PilhaDAO não foi apagada, apenas susbtituída pela FakePilhaDAO para realização dos testes unitários,
    uma vez que queremos testar o comportamento apenas de Pilha e não a integração entre as classes.
    private IPilhaDAO pilhaDAO;
    -------
    public Pilha(IPilhaDAO pilhaDAO){
        this.pilhaDAO = pilhaDAO;
    }
    -------
    Criando agora usando mock:
    */
    private IPilhaDAO pilhaDAO;

    public Pilha(IPilhaDAO pilhaDAO){
        this.pilhaDAO = pilhaDAO;
    }

    public void push(Livro livro){
        if (pilhaDeLivros.size() >= limite){ throw new ArrayStoreException();}
        if (!livro.getTitulo().startsWith("A") && !livro.getTitulo().startsWith("O")){ return;}
        pilhaDeLivros.add(livro);
        pilhaDAO.save(this);
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
