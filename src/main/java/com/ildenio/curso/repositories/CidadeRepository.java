package com.ildenio.curso.repositories;


import com.ildenio.curso.domain.Categoria;
import com.ildenio.curso.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
