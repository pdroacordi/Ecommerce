package br.com.pedroacordi.ecommerce.service.categoria;

import br.com.pedroacordi.ecommerce.model.Categoria;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ICategoriaService {
    public Categoria criar(Categoria nova);
    public Categoria alterar(Categoria categoria);
    public List<Categoria> listarTudo();
    public void deletar(Integer id);
}
