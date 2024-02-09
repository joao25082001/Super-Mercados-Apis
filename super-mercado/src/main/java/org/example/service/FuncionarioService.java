package org.example.service;

import org.example.DTO.funcionario.FuncionarioDTO;
import org.example.entity.Funcionario;
import org.example.entity.SuperMercado;
import org.example.exception.ExceptioNoContent;
import org.example.exception.ExceptionConflict;
import org.example.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {
    @Autowired
    FuncionarioRepository repository;
    @Autowired
    SuperMercadoService superMercadoService;

    public Funcionario cadastrarFuncionario(FuncionarioDTO request) {
        validaFuncExiste(request.getCpf());
        SuperMercado superMercado = superMercadoService.buscarSupermercadoId(request.getIdSupermercado());
        Funcionario funcionario =
                new Funcionario.FuncionarioBuilder().
                        cpf(request.getCpf()).
                        nome(request.getNome()).
                        carteiraTrabalho(request.getNumeroCarteira())
                        .superMercado(superMercado).build();
        repository.save(funcionario);
        return funcionario;
    }

    public Funcionario buscarFuncionarioById(String id) {
        Optional<Funcionario> funcionario = repository.findByCpf(id);
        if (funcionario.isPresent()) {
            return funcionario.get();
        }

        throw new ExceptionConflict("O funcionario não foi encontrado");
    }

    public void validaFuncExiste(String id) {
        Optional<Funcionario> funcionario = repository.findByCpf(id);
        if (funcionario.isPresent()) {
            throw new ExceptionConflict("O funcionario não foi encontrado ja existe");
        }
    }

    public List<FuncionarioDTO> exibirUsuario() {
        List<Funcionario> funcionarios = repository.findAll();
        if (funcionarios.isEmpty()) {
            throw new ExceptioNoContent("não há funcionarios cadastrados");
        }
        return funcionarios.stream()
                .map(funcionario ->
                        new FuncionarioDTO
                                (funcionario.getCpf(), funcionario.getNome(), funcionario.getNumeroCarteira()))
                                    .collect(Collectors.toList());
    }

    public void deletaFuncionario(String cpf) {
        buscarFuncionarioById(cpf);
        try{
            repository.deleteByCpf(cpf);
        }catch (Exception e){
            throw  new RuntimeException("existe jornadas cadastradas para esse funcionario");
        }


    }
}
