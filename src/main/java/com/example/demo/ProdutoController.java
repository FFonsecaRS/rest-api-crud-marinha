package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProdutoController {

	@Autowired
	ProdutoRepository repository;
	CategoriaRepository catRepo;
	
	@GetMapping("/produto")
	public List<Produto> getAllProdutos(){
		return repository.findAll();
	}

	@GetMapping("/produto/{id}")
	public Produto getProdutoById(@PathVariable Long id){
		return repository.findById(id).get();
	}

	@ResponseBody
	@PostMapping("/produto")
	public Produto saveProduto(@RequestBody Produto produto){
		return repository.save(produto);
	}

	@DeleteMapping("/produto/{id}")
	public void deleteProduto(@PathVariable Long id){
		repository.deleteById(id);
	}
	
	@PutMapping ("/produto/{id}")
	public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produto) throws ResourceAccessException{
	     Produto p = repository.findById(id).orElseThrow(() -> new ResourceAccessException("Produto não encontrado com id :: " + id));

	     p.setCodigo(produto.getCodigo());
	     p.setNome(produto.getNome());
	     p.setValor(produto.getValor());
	     p.setCategoria(produto.getCategoria());
	     
	     final Produto upP = repository.save(p);
	     return ResponseEntity.ok(upP);
	}

}