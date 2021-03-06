package com.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livraria.model.Livros;

@Repository
public interface LivrariaRepositorio extends JpaRepository<Livros, Integer> {

}
