package org.example.service;

import org.example.entity.Lote;

import org.example.exception.ExceptionConflict;
import org.example.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoteService {
    @Autowired
    LoteRepository repository;

    public Lote cadastrarLote(Lote lote) {
        repository.save(lote);
        return lote;
    }
    public Lote buscarLoteById(Long id){
        Optional<Lote> lote = repository.findById(id);
        if(lote.isPresent()){
            return repository.getReferenceById(id);
        }
        throw  new ExceptionConflict("lote não encontrado");
    }

}
