package br.com.pedroacordi.ecommerce.service.usuario;

import br.com.pedroacordi.ecommerce.model.Usuario;
import br.com.pedroacordi.ecommerce.security.ECToken;

public interface IUsuarioService {
    public Usuario cadastrar(Usuario novo);
    public Usuario alterar(Usuario usuario);
    public ECToken login(Usuario usuario);
}
