package org.example.service;

import org.example.DTO.cliente.ClienteDTO;
import org.example.DTO.cliente.RelatorioClienteDTO;
import org.example.DTO.cliente.RequestAtualizacao;
import org.example.DTO.produto.ProdutoDTO;
import org.example.entity.Cliente;
import org.example.entity.Endereco;
import org.example.exception.ExceptioNoContent;
import org.example.exception.ExceptionConflict;
import org.example.projection.ProjectionRelatorioCliente;
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
            enderecoService.ObtendoInformacoesEndereco(cep, cliente);
            return new ClienteDTO.ClienteDTObuilder().mensagem("Usuario cadastrado").nome(nome).build();
        }
        throw new ExceptionConflict("CPF já cadastrado");
    }

    public ClienteDTO cadastroClienteSemCep(Cliente cliente) throws IOException {
        Optional<Cliente> clienteExiste = verificaCpf(cliente.getCpf());
        if (clienteExiste.isEmpty()) {
            repository.save(cliente);
            return new ClienteDTO.ClienteDTObuilder().mensagem("Usuario cadastrado").nome(cliente.getNome()).build();
        }
        return null;
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

    public Cliente buscaClienteByCpf(String cpf) {
        Optional<Cliente> cliente = repository.findByCpf(cpf);
        if (cliente.isPresent()) {
            return cliente.get();
        }
        return null;
    }
    public void clienteCpf(String cpf) {
        Optional<Cliente> cliente = repository.findByCpf(cpf);
        if (cliente.isPresent()) {
            return;
        }
        throw new ExceptioNoContent("Cliente não encontrado");
    }

    public List<RelatorioClienteDTO> exibirRelatorio(String cpf) {
        clienteCpf(cpf);
        List<ProjectionRelatorioCliente> resultado = repository.buscaInfoRelatorioCliente(cpf);

        return resultado.stream()
                .map(relatorio ->
                        new RelatorioClienteDTO(
                                new ProdutoDTO.ProdutoDTOBuilder()
                                        .nome(relatorio.getProdutoNome())
                                        .codigo(relatorio.getCodigo())
                                        .build(),
                                new Cliente.Clientebuilder()
                                        .nome(relatorio.getNome())
                                        .cpf(relatorio.getCpf())
                                        .dataNascimento(relatorio.getData_Nascimento())
                                        .build(),
                                new Endereco.EnderecoBuild()
                                        .cep(relatorio.getCep())
                                        .uf(relatorio.getUf())
                                        .logradouro(relatorio.getLogradouro())
                                        .build(), relatorio.getCompraDia()
                        )
                )
                .collect(Collectors.toList());

    }
}

