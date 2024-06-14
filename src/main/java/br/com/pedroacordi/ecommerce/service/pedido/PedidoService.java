package br.com.pedroacordi.ecommerce.service.pedido;

import br.com.pedroacordi.ecommerce.dao.PedidoDAO;
import br.com.pedroacordi.ecommerce.dto.FaturamentoMensal;
import br.com.pedroacordi.ecommerce.model.ItemPedido;
import br.com.pedroacordi.ecommerce.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoService implements IPedidoService{

    @Autowired
    private PedidoDAO dao;

    @Override
    public Pedido criarNovoPedido(Pedido pedido) {
        double total = 0.0;
        double desconto = 0.0;
        for(ItemPedido item : pedido.getItens()){
            item.setPedido(pedido);
            total += item.getValorTotal();
        }
        pedido.setValorBruto(total);
        if( total >= 50 )
            desconto = total * 0.10;

        pedido.setDesconto(desconto);
        pedido.setValorTotal( total - desconto );
        pedido.setStatus(1);

        return dao.save(pedido);
    }

    @Override
    public Pedido alterarPedido(Pedido pedido) {
        return dao.save(pedido);
    }

    @Override
    public List<Pedido> recuperarTodos() {
        return (List<Pedido>)dao.findAll();
    }

    @Override
    public Pedido recuperarPeloNum(Integer numPedido) {
        return dao.findById(numPedido).orElse(null);
    }

    @Override
    public List<Pedido> recuperarPorStatus(Integer status) {
        return dao.findAllByStatus(status);
    }

    @Override
    public List<FaturamentoMensal> recuperarFaturamento(Integer ano) {
        return dao.recuperarFaturamento(ano);
    }
}
