package br.com.pedroacordi.ecommerce.controller;

import br.com.pedroacordi.ecommerce.model.Produto;
import br.com.pedroacordi.ecommerce.model.Variante;
import br.com.pedroacordi.ecommerce.service.variante.IVarianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VarianteController {

    @Autowired
    private IVarianteService service;

    @PostMapping("/variantes")
    public ResponseEntity<Variante> adicionar(@RequestBody Variante variante){
        Variante v = service.adicionarNova(variante);
        if(v != null)
            return ResponseEntity.ok(v);
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/variantes/{id}")
    public ResponseEntity<Variante> modificar(@RequestBody Variante variante, @PathVariable Integer id){
        variante.setId(id);
        Variante v = service.alterarDados(variante);
        if(v != null)
            return ResponseEntity.ok(v);
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/variantes/{id}")
    public ResponseEntity<Variante> recuperarPeloId(@PathVariable Integer id){
        Variante var = service.recuperarPorId(id);
        if(var != null)
            return ResponseEntity.ok(var);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/variantes")
    public ResponseEntity<List<Variante>> recuperarPeloProduto(@RequestParam(name="produto") Integer idProduto){
        Produto p = new Produto();
        p.setId(idProduto);
        return ResponseEntity.ok(service.recuperarPorProduto(p));
    }
}
