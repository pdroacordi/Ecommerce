package br.com.pedroacordi.ecommerce.controller;

import br.com.pedroacordi.ecommerce.model.Pedido;
import br.com.pedroacordi.ecommerce.service.pedido.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedidoController {

    @Autowired
    private IPedidoService service;

    @PostMapping("/pedidos")
    public ResponseEntity<Pedido> inserirNovo(@RequestBody Pedido novo){
        Pedido res = service.criarNovoPedido(novo);
        if(res != null)
            return ResponseEntity.ok(res);
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<Pedido>> recuperarTodos(){
        return ResponseEntity.ok(service.recuperarTodos());
    }

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> recuperarPeloId(@PathVariable Integer id){
        Pedido res = service.recuperarPeloNum(id);
        if(res != null)
            return ResponseEntity.ok(res);
        return ResponseEntity.notFound().build();
    }
}
