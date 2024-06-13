package br.com.pedroacordi.ecommerce.service.produto;

import br.com.pedroacordi.ecommerce.model.Categoria;
import br.com.pedroacordi.ecommerce.model.Produto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProdutoService {
    public Produto cadastrar(Produto novo);
    public Produto alterar(Produto produto);
    public Page<Produto> recuperarTodos(int numPagina);
    public List<Produto> recuperarPorPalavraChave(String palavra);

    public Produto recuperarPorID(Integer id);
    public List<Produto> recuperarPorCategoria(Categoria categoria);


}
