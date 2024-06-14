package br.com.pedroacordi.ecommerce.service.pedido;

import br.com.pedroacordi.ecommerce.dto.FaturamentoMensal;
import br.com.pedroacordi.ecommerce.model.Pedido;

import java.util.List;

public interface IPedidoService {
    public Pedido criarNovoPedido(Pedido pedido);
    public Pedido alterarPedido(Pedido pedido);
    public List<Pedido> recuperarTodos();
    public Pedido recuperarPeloNum(Integer numPedido);
    public List<Pedido> recuperarPorStatus(Integer status);

    public List<FaturamentoMensal> recuperarFaturamento(Integer ano);
}
