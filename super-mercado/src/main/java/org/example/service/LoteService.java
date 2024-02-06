package org.example.service;

import org.example.entity.Lote;
import org.example.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoteService {
    @Autowired
    LoteRepository repository;

    public Lote cadastrarLote(Lote lote) {
        repository.save(lote);
        return lote;
    }
}
