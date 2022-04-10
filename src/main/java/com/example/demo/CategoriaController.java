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
public class CategoriaController {

	@Autowired
	CategoriaRepository repository;
	
	@GetMapping("/categoria")
	public List<Categoria> getAllCategorias(){
		return repository.findAll();
	}

	@GetMapping("/categoria/{id}")
	public Categoria getCategoriaById(@PathVariable Long id){
		return repository.findById(id).get();
	}

	@ResponseBody
	@PostMapping("/categoria")
	public Categoria saveCategoria(@RequestBody Categoria categoria){
		return repository.save(categoria);
	}

	@DeleteMapping("/categoria/{id}")
	public void deleteCategoria(@PathVariable Long id){
		repository.deleteById(id);
	}
	
	@PutMapping ("/categoria/{id}")
	public ResponseEntity<Categoria> updateCategoria(@PathVariable Long id, @RequestBody Categoria categoria) throws ResourceAccessException{
	     Categoria p = repository.findById(id).orElseThrow(() -> new ResourceAccessException("Categoria não encontrada com id :: " + id));

	     p.setNome(categoria.getNome());
	     p.setDescricao(categoria.getDescricao());
	     
	     final Categoria upP = repository.save(p);
	     return ResponseEntity.ok(upP);
	}

}