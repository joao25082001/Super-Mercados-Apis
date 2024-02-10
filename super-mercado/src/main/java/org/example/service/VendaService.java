package org.example.service;

import org.example.DTO.venda.VendaDTO;
import org.example.entity.Cliente;
import org.example.entity.Jornada;
import org.example.entity.Venda;
import org.example.exception.ExceptioNoContent;
import org.example.exception.ExceptionConflict;
import org.example.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class VendaService {
    @Autowired
    VendaRepository repository;
    @Autowired
    ClienteService serviceCliente;
    @Autowired
    JornadaService jornadaService;
    public Venda verificaVendaExiste(Long id) {
        Integer nmrVendas = repository.contaVendas(id);
        if(nmrVendas > 1){
            throw  new ExceptionConflict("mais de uma venda para o mesmo cliente, inicie outra venda");
        }
        Optional<Venda> venda = repository.findById(id);
        if(venda.isPresent()){
            return venda.get();
        }
        throw new ExceptioNoContent("Venda nao existe");
    }

    public VendaDTO cadastraVenda(VendaDTO request) throws IOException{
        Cliente cliente = serviceCliente.buscaClienteByCpf(request.getCliente().getCpf());
        Jornada jornada = jornadaService.buscaJornadaByCaixa(request.getCaixa());
        if(cliente== null){
            serviceCliente.cadastroClienteSemCep(request.getCliente());
        }
        cliente = serviceCliente.buscaClienteByCpf(request.getCliente().getCpf());
        Venda venda = new Venda(request.getDataHora(),cliente,jornada);
        repository.save(venda);
        return request;
    }
}
