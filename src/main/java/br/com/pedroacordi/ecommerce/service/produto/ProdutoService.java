package br.com.pedroacordi.ecommerce.service.produto;

import br.com.pedroacordi.ecommerce.dao.ProdutoDAO;
import br.com.pedroacordi.ecommerce.model.Categoria;
import br.com.pedroacordi.ecommerce.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoService implements IProdutoService{

    @Autowired
    private ProdutoDAO dao;

    @Override
    public Produto cadastrar(Produto novo) {
        return dao.save(novo);
    }

    @Override
    public Produto alterar(Produto produto) {
        return dao.save(produto);
    }

    @Override
    public List<Produto> recuperarTodos() {
        return dao.findByOrderByNomeAsc();
    }

    @Override
    public List<Produto> recuperarPorPalavraChave(String palavra) {
        return dao.findByNomeContaining(palavra);
    }

    @Override
    public Produto recuperarPorID(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<Produto> recuperarPorCategoria(Categoria categoria) {
        return dao.findByCategoriasContaining(categoria);
    }
}
