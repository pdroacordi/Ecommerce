package br.com.pedroacordi.ecommerce.controller;

import br.com.pedroacordi.ecommerce.model.Categoria;
import br.com.pedroacordi.ecommerce.service.categoria.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    private ICategoriaService service;
    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> getAll(){
        return ResponseEntity.ok(service.listarTudo());
    }

    @PostMapping("/categorias")
    public ResponseEntity<Categoria> addNew(@RequestBody Categoria nova){
        Categoria res = service.criar(nova);
        if(res != null)
            return ResponseEntity.status(201).body(res);
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<Categoria> alter(@RequestBody Categoria categ, @PathVariable Integer id){
        categ.setId(id);
        Categoria res = service.alterar(categ);
        if(res != null)
            return ResponseEntity.ok(res);
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        service.deletar(id);
        return ResponseEntity.ok("Deleted");
    }
}
