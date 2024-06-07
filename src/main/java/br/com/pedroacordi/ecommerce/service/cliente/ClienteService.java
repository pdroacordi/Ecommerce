package br.com.pedroacordi.ecommerce.service.cliente;

import br.com.pedroacordi.ecommerce.dao.ClienteDAO;
import br.com.pedroacordi.ecommerce.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteService implements IClienteService{

    @Autowired
    private ClienteDAO dao;
    @Override
    public Cliente cadastrarNovoCliente(Cliente novo) {
        return dao.save(novo);
    }

    @Override
    public Cliente alterarCliente(Cliente cliente) {
        return dao.save(cliente);
    }

    @Override
    public Cliente recuperarPeloId(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public Cliente recuperarPeloTelefone(String telefone) {
        return dao.findByTelefone(telefone);
    }

    @Override
    public List<Cliente> recuperarTodos() {
        return (List<Cliente>)dao.findAll();
    }
}
