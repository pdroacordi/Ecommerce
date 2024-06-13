package br.com.pedroacordi.ecommerce.controller;

import br.com.pedroacordi.ecommerce.model.Usuario;
import br.com.pedroacordi.ecommerce.security.ECToken;
import br.com.pedroacordi.ecommerce.service.usuario.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    IUsuarioService service;

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario novo){
        Usuario res = service.cadastrar(novo);
        if(res != null)
            return ResponseEntity.ok(res);
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> alterar(@RequestBody Usuario usuario, @PathVariable Integer id) {
        usuario.setIdUsuario(id);
        Usuario res = service.alterar(usuario);
        if(res != null)
            return ResponseEntity.ok(res);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/login")
    public ResponseEntity<ECToken> login(@RequestBody Usuario usuario){
        ECToken token = service.login(usuario);
        if(token == null)
            return ResponseEntity.status(403).build();
        return ResponseEntity.ok(token);
    }
}
