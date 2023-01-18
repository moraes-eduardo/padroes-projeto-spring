package dio.padroesprojetospring.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dio.padroesprojetospring.model.entities.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

    public Iterable<Produto> findByDescricaoContainingIgnoreCase(String parteDescricao);
    
}

