package exemplo.vendas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class VendaTest {

    @Test
    @DisplayName("Aprovando compra com verificação de crédito")
    public void aprovandoCredito() {

        Cliente cliente = new Cliente("12345678900", "João");
        boolean pagamentoavista = false;

        ICredito creditoService = mock(ICredito.class);
        when(creditoService.getLimite(cliente.getCPF())).thenReturn(2100.0);

        Venda venda = new Venda(2000, cliente, creditoService, pagamentoavista);

        assertTrue(venda.checkout());
    }

    @Test
    @DisplayName("Reprovando compra com verificação de crédito")
    public void reprovandoCredito() {

        Cliente cliente = new Cliente("12345678900", "João");
        boolean pagamentoavista = false;

        ICredito creditoService = mock(ICredito.class);
        when(creditoService.getLimite(cliente.getCPF())).thenReturn(1000.0);

        Venda venda = new Venda(2000, cliente, creditoService, pagamentoavista);

        assertFalse(venda.checkout());
    }

    @Test
    @DisplayName("Aprovando compra sem verificação de crédito")
    public void aprovandoCompra() {

        Cliente cliente = new Cliente("12345678900", "João");
        boolean pagamentoavista = true;

        ICredito creditoService = mock(ICredito.class);
        when(creditoService.getLimite(cliente.getCPF())).thenReturn(2100.0);

        verify(creditoService, never()).getLimite(cliente.getCPF());
    }

    @Test
    @DisplayName("Reprovando compra por erro na cominucação com a verificação de crédito")
    public void erroComunicacaoComWebService() {

        Cliente cliente = new Cliente("12345678900", "João");
        boolean pagamentoavista = false;

        ICredito creditoService = mock(ICredito.class);
        when(creditoService.getLimite(anyString())).thenThrow(new RuntimeException());

        Venda venda = new Venda(2000, cliente, creditoService, pagamentoavista);

        assertFalse(venda.checkout());
    }
}