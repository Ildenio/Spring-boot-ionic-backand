package com.ildenio.curso.services;

import com.ildenio.curso.domain.Categoria;
import com.ildenio.curso.repositories.CategoriaRepository;
import com.ildenio.curso.services.exception.DataIntegrityExceptiion;
import com.ildenio.curso.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.ildenio.curso.dto.CategoriaDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! id: "+id+" ,Tipo: "+Categoria.class.getName()));
    }
    @Transactional
    public Categoria insert(Categoria obj){
        obj.setId(null);
        return repo.save(obj);

    }
    public Categoria update(Categoria obj){
        Categoria newObj = find(obj.getId());
        updateData(newObj,obj);
        return repo.save(newObj);
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
    public List<Categoria> findAll() {
       return repo.findAll();
    }
    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }
    private void updateData(Categoria newObj,Categoria obj){
        newObj.setNome(obj.getNome());
        newObj.setNome(obj.getNome());
    }
    public Categoria fromDto(CategoriaDTO objDto){
        return new Categoria(objDto.getId(),objDto.getNome());
    }

}
