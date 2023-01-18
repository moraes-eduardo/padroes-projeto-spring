package dio.padroesprojetospring.model.repositories;

import org.springframework.data.repository.CrudRepository;
import dio.padroesprojetospring.model.entities.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

    public Iterable<Produto> findByDescricaoContainingIgnoreCase(String parteDescricao);
    
}

