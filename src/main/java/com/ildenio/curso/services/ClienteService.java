package com.ildenio.curso.services;

import com.ildenio.curso.domain.Cliente;
import com.ildenio.curso.repositories.ClienteRepository;
import com.ildenio.curso.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repo;

    public Cliente buscar(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! id: "+id+" ,Tipo: "+Cliente.class.getName()));
    }
}
