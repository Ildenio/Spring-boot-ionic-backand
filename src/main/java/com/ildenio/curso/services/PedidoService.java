package com.ildenio.curso.services;

import com.ildenio.curso.domain.Pedido;
import com.ildenio.curso.repositories.PedidoRepository;
import com.ildenio.curso.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repo;

    public Pedido buscar(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! id: "+id+" ,Tipo: "+Pedido.class.getName()));
    }
}
