package br.com.pedroacordi.ecommerce.dao;

import br.com.pedroacordi.ecommerce.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
    public Usuario findByLogin(String login);
}
