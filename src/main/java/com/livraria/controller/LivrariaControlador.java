package com.livraria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.livraria.model.Livros;
import com.livraria.repository.LivrariaRepositorio;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(value = "API Livraria")
@RequestMapping("/livraria")
public class LivrariaControlador {
	
	@Autowired
	private LivrariaRepositorio livrariaRepositorio;
	

	@ApiOperation(value = "Retorna Todos os livros cadastrados")
	@GetMapping("/listartodos")
	public List<Livros> listarTodosLivros(){
		return livrariaRepositorio.findAll();
	}
	
	@Value("${application.name}")
	private String applicationName;
	
	@ApiOperation(value = "Retorna mensagem com o nome da empresa")
	@GetMapping("/hello")
	public String helloword() {
		return applicationName;
	}
	
	
	
	@ApiOperation(value = "Salvando os dados de um novo Livro")
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin
	@PostMapping("/salvar")
	public Livros salvarLivros(@Valid @RequestBody Livros livros) {
		return livrariaRepositorio.save(livros);
		
	}
	
	
	@ApiOperation(value = "Busca os dados de um livro pelo ID")
	@GetMapping("/buscaid/{id}")
	public Livros retornaDadosId(@PathVariable Integer id) {
		return livrariaRepositorio
				.findById(id)
				.orElseThrow( ()-> new ResponseStatusException(
						HttpStatus.NOT_FOUND, "Livro não encontrado"));
	}
	
	@ApiOperation(value = "Deletando os dados de um livro pelo ID")
	@DeleteMapping("/deleteId/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletaLivroId(@PathVariable Integer id) {
		livrariaRepositorio
				.findById(id)
				.map(livros -> {
					livrariaRepositorio.delete(livros);
					return Void.TYPE;
				})
				.orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
	}
	
	@ApiOperation(value = "Alterando os dados de um livro pelo ID e dados passados")
	@PutMapping("/atualiza/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarLivro(@PathVariable Integer id, @Valid @RequestBody Livros livrosAtualizado) {
		livrariaRepositorio
				.findById(id)
				.map(livros -> {
					livrosAtualizado.setIdlivro(livros.getIdlivro());
					return livrariaRepositorio.save(livrosAtualizado);
				})
				.orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
	}
}
