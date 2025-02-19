package org.example.service;

import org.example.entity.SuperMercado;
import org.example.exception.ExceptioNoContent;
import org.example.exception.ExceptionConflict;
import org.example.repository.SuperMercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuperMercadoService {
    @Autowired
    SuperMercadoRepository repository;
    public SuperMercado buscarSupermercadoId(Long id){
        Optional<SuperMercado> superMercado = repository.findById(id);
        if(superMercado.isPresent()){
            return repository.getReferenceById(id);
        }
        throw  new ExceptioNoContent("super Mercado nao existe");
    }
}
