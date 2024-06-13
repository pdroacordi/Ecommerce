package br.com.pedroacordi.ecommerce.service.usuario;

import br.com.pedroacordi.ecommerce.dao.UsuarioDAO;
import br.com.pedroacordi.ecommerce.model.Usuario;
import br.com.pedroacordi.ecommerce.security.ECToken;
import br.com.pedroacordi.ecommerce.security.ECTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioService implements IUsuarioService{

    @Autowired
    UsuarioDAO dao;

    @Override
    public Usuario cadastrar(Usuario novo) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senha = encoder.encode(novo.getSenha());
        novo.setSenha(senha);
        return dao.save(novo);
    }

    @Override
    public Usuario alterar(Usuario usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senha = encoder.encode(usuario.getSenha());
        usuario.setSenha(senha);
        return dao.save(usuario);
    }

    @Override
    public ECToken login(Usuario usuario) {
        Usuario u  = dao.findByLogin(usuario.getLogin());
        if( u == null)
            return null;
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if( encoder.matches(usuario.getSenha(), u.getSenha()) ){
            return ECTokenUtil.generateToken(u);
        }
        return null;
    }
}
