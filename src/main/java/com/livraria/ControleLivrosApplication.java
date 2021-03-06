package com.livraria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.livraria.model.Livros;
import com.livraria.repository.LivrariaRepositorio;


@SuppressWarnings({ "unused", "deprecation" })
@SpringBootApplication
public class ControleLivrosApplication {

	/* @Bean
	public CommandLineRunner run(@Autowired LivrariaRepositorio livraria) {
		return args-> {
			Livros livro = Livros.builder()
					.edicaolivro("1").editoralivro("Mundo Novo").isbnlivro("isbn-teste").nomeautorlivro("Rildo").titulolivro("O teste").build();
			livraria.save(livro);
		};
		
	} */
	
	public static void main(String[] args) {
		SpringApplication.run(ControleLivrosApplication.class, args);
	}
	
	
}
