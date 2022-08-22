package pilha.de.livros;

// Com o mockito, essa classe já não é mais necessária. Repare pela falta de uso dela.

public class FakePilhaDAO implements IPilhaDAO{

    @Override
    public void save(Pilha pilha) {
        System.out.println("Salvo!");
    }
}
