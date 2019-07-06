package com.ildenio.curso.services;

import com.ildenio.curso.domain.Categoria;
import com.ildenio.curso.repositories.CategoriaRepository;
import com.ildenio.curso.services.exception.DataIntegrityExceptiion;
import com.ildenio.curso.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! id: "+id+" ,Tipo: "+Categoria.class.getName()));
    }
    public Categoria insert(Categoria obj){
        obj.setId(null);
        return repo.save(obj);
    }
    public Categoria update(Categoria obj){
        find(obj.getId());
        return repo.save(obj);
    }
    public void delete(Integer id){
        find(id);
        try{
        repo.deleteById(id);
    }
        catch(DataIntegrityViolationException e){
            throw new DataIntegrityExceptiion("Não é possível excluir uma categoria que possui produtos");
        }

        }
}
