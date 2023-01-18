package dio.padroesprojetospring.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import dio.padroesprojetospring.model.entities.Produto;
import dio.padroesprojetospring.model.repositories.ProdutoRepository;
import jakarta.validation.Valid;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados MySQL) em uma
 * interface simples e coesa (API REST).
 * 
 * @author moraes-eduardo
 */
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	public ProdutoRepository produtoRepository;

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	public @ResponseBody Produto salvarProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}

	@GetMapping
	public Iterable<Produto> obterProdutos() {
		return produtoRepository.findAll();
	}

	@GetMapping(path = "/descricao/{parteDescricao}")
	public Iterable<Produto> obterProdutosPorDescricao(@PathVariable String parteDescricao) {
		return produtoRepository.findByDescricaoContainingIgnoreCase(parteDescricao);
	}

	@GetMapping(path = "/{id}")
	public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
		return produtoRepository.findById(id);
	}

	@DeleteMapping(path = "/{id}")
	public void excluirProduto(@PathVariable int id) {
		produtoRepository.deleteById(id);
	}

}
