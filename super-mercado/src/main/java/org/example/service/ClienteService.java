package org.example.service;

import org.example.DTO.Cliente.ClienteDTO;
import org.example.DTO.Cliente.RequestAtualizacao;
import org.example.entity.Cliente;
import org.example.entity.Endereco;
import org.example.exception.ExceptioNoContent;
import org.example.exception.ExceptionConflict;
import org.example.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository repository;
    @Autowired
    EnderecoService enderecoService;

    public ClienteDTO cadastroCliente(String nome, String dataNascimento, String cpf, String cep) throws IOException {
        Optional<Cliente> clienteExiste = verificaCpf(cpf);
        if (clienteExiste.isEmpty()) {
            Cliente cliente = new Cliente.Clientebuilder().nome(nome).dataNascimento(dataNascimento).cpf(cpf).build();
            repository.save(cliente);
            enderecoService.ObtendoInformacoesEndereco(cep,cliente);
            return new ClienteDTO.ClienteDTObuilder().mensagem("Usuario cadastrado").nome(nome).build();
        }
        throw new ExceptionConflict("CPF já cadastrado");

    }

    private Optional<Cliente> verificaCpf(String cpf) {
        Optional<Cliente> clienteExiste = repository.findByCpf(cpf);
        if (clienteExiste.isPresent()) {
            throw new ExceptionConflict("CPF já cadastrado");
        }

        return clienteExiste;
    }

    public List<ClienteDTO> exibirUsuario() {
        List<Cliente> clientes = repository.findAll();
        if (clientes.isEmpty()) {
            throw new ExceptioNoContent("0 informações encontradas");
        }

        return clientes.stream()
                .map(clienteDTO ->
                        new ClienteDTO.ClienteDTObuilder().
                                nome(clienteDTO.getNome()).
                                cpf(clienteDTO.getCpf()).
                                dataNascimento(clienteDTO.getDataNascimento()).
                                build())
                .collect(Collectors.toList());

    }

    public RequestAtualizacao atualizarUsuario(Long id, RequestAtualizacao request) {
        Optional<Cliente> cliente = repository.findById(id);
        if (cliente.isEmpty()) {
            throw new ExceptioNoContent("Cliente nao encontrado");
        }
        Cliente clienteAtualizado = repository.getReferenceById(id);
        clienteAtualizado.setCpf(clienteAtualizado.getCpf());
        clienteAtualizado.setNome(request.getNome());
        clienteAtualizado.setDataNascimento(request.getDataNascimento());
        repository.save(clienteAtualizado);
        return request;

    }

    public void deletarUsuario(Long id) {
        Optional<Cliente> cliente = repository.findById(id);
        if (cliente.isEmpty()) {
            throw new ExceptioNoContent("Cliente nao encontrado");
        }
        Cliente clienteAdeletar = repository.getReferenceById(id);
        repository.delete(clienteAdeletar);

    }
}

