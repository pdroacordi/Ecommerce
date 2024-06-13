package br.com.pedroacordi.ecommerce.service.variante;

import br.com.pedroacordi.ecommerce.model.Produto;
import br.com.pedroacordi.ecommerce.model.Variante;
import br.com.pedroacordi.ecommerce.dao.VarianteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VarianteService implements IVarianteService{

    @Autowired
    private VarianteDAO dao;

    @Override
    public Variante adicionarNova(Variante nova) {
        return dao.save(nova);
    }

    @Override
    public Variante alterarDados(Variante variante) {
        return dao.save(variante);
    }

    @Override
    public List<Variante> recuperarPorProduto(Produto p) {
        return dao.findByProduto(p);
    }

    @Override
    public Variante recuperarPorId(Integer id) {
        return dao.findById(id).orElse(null);
    }
}
