package org.example.service;

import org.example.entity.Venda;
import org.example.exception.ExceptioNoContent;
import org.example.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendaService {
    @Autowired
    VendaRepository repository;
    public Venda verificaVendaExiste(Long id){
        Optional<Venda> venda = repository.findById(id);
        if(venda.isPresent()){
            return venda.get();
        }
        throw new ExceptioNoContent("Venda nao existe");
    }
}
