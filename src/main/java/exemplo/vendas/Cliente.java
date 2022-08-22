package exemplo.vendas;

public class Cliente {

    private final String CPF;
    private final String NOME;

    public Cliente(String cpf, String nome) {
        this.CPF = cpf;
        this.NOME = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getNOME() {
        return NOME;
    }
}
