package mock.pessoa.mockito;

public class Pessoa implements IPessoa{

    final private int idade;

    public Pessoa(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public String falar(){
        return "Eu tenho " + getIdade() + " anos.";
    }

    public void voar(){
        System.out.println("Oops! Eu não vôo.");
    }
}
