package br.com.pedroacordi.ecommerce.dao;

import br.com.pedroacordi.ecommerce.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {
    public Cliente findByTelefone(String telefone);
}
