package exemplo.vendas;

public class Venda {

    private final double VALOR;
    private final Cliente CLIENTE;
    private final ICredito CREDITOSERVICE;
    private final boolean PAGAMENTOAVISTA;

    public Venda(double valor, Cliente cliente, ICredito creditoservice, boolean pagamentoavista) {
        super();
        this.VALOR = valor;
        this.CLIENTE = cliente;
        this.CREDITOSERVICE = creditoservice;
        this.PAGAMENTOAVISTA = pagamentoavista;
    }

    public double getVALOR() {
        return VALOR;
    }

    public Cliente getCLIENTE() {
        return CLIENTE;
    }

    public boolean checkout(){
        double limite;
        if (PAGAMENTOAVISTA){ return true; }
        try {
            limite = CREDITOSERVICE.getLimite(CLIENTE.getCPF());
            return !(VALOR > limite);
        } catch (RuntimeException e) {
            return false;
        }
    }
}
