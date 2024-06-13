package br.com.pedroacordi.ecommerce.service.produto;

import br.com.pedroacordi.ecommerce.dao.ProdutoDAO;
import br.com.pedroacordi.ecommerce.model.Categoria;
import br.com.pedroacordi.ecommerce.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoService implements IProdutoService{

    @Autowired
    private ProdutoDAO dao;

    private static final int PAGE_SIZE = 5;

    @Override
    public Produto cadastrar(Produto novo) {
        return dao.save(novo);
    }

    @Override
    public Produto alterar(Produto produto) {
        return dao.save(produto);
    }

    @Override
    public Page<Produto> recuperarTodos(int numPagina) {
        Pageable pageable = PageRequest.of(numPagina, PAGE_SIZE );
        return dao.findByOrderByNomeAsc(pageable);
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
