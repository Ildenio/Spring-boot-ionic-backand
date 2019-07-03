package com.ildenio.curso.repositories;


import com.ildenio.curso.domain.Categoria;
import com.ildenio.curso.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
