package org.example.service;

import org.example.DTO.caixa.CaixaDTO;
import org.example.entity.Caixa;

import org.example.entity.SuperMercado;
import org.example.exception.ExceptionConflict;
import org.example.repository.CaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CaixaService {
    @Autowired
    CaixaRepository repository;
    @Autowired
    SuperMercadoService superMercadoService;

    public Caixa cadastrarCaixa(CaixaDTO request){
        SuperMercado superMercado = superMercadoService.buscarSupermercadoId(request.getIdSupermercado());
        Optional<Caixa> c =repository.findByNumero(request.getNumero());
        if (c.isPresent()){
           throw  new ExceptionConflict("caixa já cadastrado");
        }
        Caixa caixa = new Caixa(request.getNumero(), request.getTipoCaixa(),request.getStatus(),superMercado);
        repository.save(caixa);
        return caixa;
    }

    public String abrindoFechandoCaixa(Integer request,Boolean funcionamento) {
        Optional<Caixa> caixa = repository.findByNumero(request);
        if(caixa.isEmpty()){
            throw new ExceptionConflict("Caixa nao encontrado");
        }
        Caixa caixa2 = new Caixa(caixa.get().getId(),caixa.get().getNumero(),caixa.get().getTipoCaixa(),caixa.get().getStatus(),caixa.get().getIdSupermercado());
        caixa2.setStatus(funcionamento);
        repository.save(caixa2);
        if(funcionamento){
          return  "Caixa aberto";
        }
        return  "Caixa fechado";
    }
    public Caixa buscarCaixaByNumero(Integer id) {
        Optional<Caixa> caixa = repository.findByNumero(id);
        if(caixa.isPresent()){
            return caixa.get();
        }
        throw  new ExceptionConflict("O caixa não foi encontrado");
    }
}
