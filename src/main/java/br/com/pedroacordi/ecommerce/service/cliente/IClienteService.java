package br.com.pedroacordi.ecommerce.service.cliente;

import br.com.pedroacordi.ecommerce.model.Cliente;
import org.springframework.stereotype.Component;

import java.util.List;

public interface IClienteService {
    public Cliente cadastrarNovoCliente(Cliente novo);
    public Cliente alterarCliente(Cliente cliente);
    public Cliente recuperarPeloId(Integer id);
    public Cliente recuperarPeloTelefone(String telefone);
    public List<Cliente> recuperarTodos();
}
