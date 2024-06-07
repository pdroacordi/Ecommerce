package br.com.pedroacordi.ecommerce.controller;

import br.com.pedroacordi.ecommerce.model.Cliente;
import br.com.pedroacordi.ecommerce.service.cliente.IClienteService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    private IClienteService serv;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAll(){
        return ResponseEntity.ok(serv.recuperarTodos());
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Integer id){
        Cliente result = serv.recuperarPeloId(id);
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> insertClient(@RequestBody Cliente novo){
        try {
            Cliente result = serv.cadastrarNovoCliente(novo);
            if(result != null)
                return ResponseEntity.ok(result);
        }catch(Exception e){
            System.out.println("Log ERRO ao cadastrar: "+e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("clientes/{id}")
    public ResponseEntity<Cliente> updateClient(@RequestBody Cliente cliente, @PathVariable Integer id){
        try{
            cliente.setId(id);
            Cliente result = serv.alterarCliente(cliente);
            if(result != null)
                return ResponseEntity.ok(result);
        }catch(Exception e){
            System.out.println("Log ERRO ao atualizar: "+e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("clientes/busca")
    public ResponseEntity<Cliente> searchByPhone(@RequestParam(name="telefone") String telefone){
        Cliente result = serv.recuperarPeloTelefone(telefone);
        if(result != null)
            return ResponseEntity.ok(result);
        return ResponseEntity.notFound().build();
    }
}
