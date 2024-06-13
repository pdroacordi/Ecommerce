package br.com.pedroacordi.ecommerce.service.variante;

import br.com.pedroacordi.ecommerce.model.Produto;
import br.com.pedroacordi.ecommerce.model.Variante;

import java.util.List;

public interface IVarianteService {
    public Variante adicionarNova(Variante nova);
    public Variante alterarDados(Variante variante);
    public List<Variante> recuperarPorProduto(Produto p);
    public Variante recuperarPorId(Integer id);
}
