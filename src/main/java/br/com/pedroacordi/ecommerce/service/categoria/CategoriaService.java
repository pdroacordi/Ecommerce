package br.com.pedroacordi.ecommerce.service.categoria;

import br.com.pedroacordi.ecommerce.dao.CategoriaDAO;
import br.com.pedroacordi.ecommerce.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaService implements ICategoriaService{

    @Autowired
    private CategoriaDAO dao;

    @Override
    public Categoria criar(Categoria nova) {
        return dao.save(nova);
    }

    @Override
    public Categoria alterar(Categoria categoria) {
        return dao.save(categoria);
    }

    @Override
    public List<Categoria> listarTudo() {
        return dao.findAllByOrderByNomeAsc();
    }

    @Override
    public void deletar(Integer id) {
        dao.deleteById(id);
    }
}
