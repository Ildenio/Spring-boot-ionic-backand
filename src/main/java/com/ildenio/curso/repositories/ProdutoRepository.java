package com.ildenio.curso.repositories;



import com.ildenio.curso.domain.Categoria;
import com.ildenio.curso.domain.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    @Transactional(readOnly=true)
    @Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
    Page<Produto> search(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);
    //Colocando o padrão de nome na costrução do metado que ja vem definido no Spring o proprio Spring gerencia
    //operação sem ser necessario a inserção das anotações que faz as associações meio que no manual
    // Page<Produto> findDistinctByNomeContainingAndCategoriasIn( String nome,  List<Categoria> categorias, Pageable pageRequest);
}
