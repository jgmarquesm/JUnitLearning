package mock.pessoa.mockito;

import static org.mockito.Mockito.*;

public class MockPessoa {

    /*
    public static void main(String[] args){
        Pessoa alguem = mock(Pessoa.class); // -> Usando a própria Classe para Mock: não recomendado.
        alguem.falar();
    }
    */

    public static void main(String[] args){
        IPessoa alguem = mock(IPessoa.class); // -> Garante isolamento pois evita acesso ao ambiente.
        when(alguem.getIdade()).thenReturn(25);
        when(alguem.falar()).thenReturn("Oi, eu sou o Goku!");
        alguem.voar();
        System.out.println(alguem.falar());
        System.out.println(alguem.getIdade());
    }
}
