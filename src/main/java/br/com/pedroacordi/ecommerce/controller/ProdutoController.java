package br.com.pedroacordi.ecommerce.controller;

import br.com.pedroacordi.ecommerce.model.Categoria;
import br.com.pedroacordi.ecommerce.model.Produto;
import br.com.pedroacordi.ecommerce.service.produto.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private IProdutoService service;

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> getAll(){
        return ResponseEntity.ok(service.recuperarTodos());
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Integer id){
        Produto res = service.recuperarPorID(id);
        if(res != null)
            return ResponseEntity.ok(res);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/produtos")
    public ResponseEntity<Produto> create(@RequestBody Produto produto){
        Produto res = service.cadastrar(produto);
        if(res != null)
            return ResponseEntity.status(201).body(res);
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produto> alter(@RequestBody Produto produto, @PathVariable Integer id){
        produto.setId(id);
        Produto res = service.alterar(produto);
        if(res != null)
            return ResponseEntity.ok(res);
        return  ResponseEntity.badRequest().build();
    }

    @GetMapping("produtos/search")
    public ResponseEntity<List<Produto>> getByKeyword(@RequestParam(name="key") String keyword){
        List<Produto> lista = service.recuperarPorPalavraChave(keyword);
        if(lista.size() > 0)
            return ResponseEntity.ok(lista);
        return ResponseEntity.notFound().build();

    }

    @GetMapping("produtos/categoria/{id}")
    public ResponseEntity<List<Produto>> getByCategory(@PathVariable Integer id){
        Categoria categoria = new Categoria();
        categoria.setId(id);
        return ResponseEntity.ok(service.recuperarPorCategoria(categoria));
    }
}
