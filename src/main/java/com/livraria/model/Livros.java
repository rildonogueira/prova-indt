package com.livraria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class Livros {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idlivro;
	
	@Column(nullable = false)
	@NotEmpty(message = "{campo.titulolivro.obrigatorio}")
	private String titulolivro;
	
	@Column(nullable = false)
	@NotEmpty(message = "{campo.edicaolivro.obrigatorio}")
	private String edicaolivro;
	
	@Column(nullable = false)
	@NotEmpty(message = "{campo.editoralivro.obrigatorio}")
	private String editoralivro;
	
	@Column(nullable = false)
	@NotEmpty(message = "{campo.nomeautorlivro.obrigatorio}")
	private String nomeautorlivro;
	
	@Column(nullable = false)
	@NotEmpty(message = "{campo.isbnlivro.obrigatorio}")
	private String isbnlivro;
	
}
