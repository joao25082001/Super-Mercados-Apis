package org.example.service;


import org.example.DTO.produto.ProdutoDTO;
import org.example.DTO.produto.RequestProdutoAtualizacao;
import org.example.entity.Lote;
import org.example.entity.Produto;
import org.example.entity.SuperMercado;
import org.example.exception.ExceptioNoContent;
import org.example.exception.ExceptionConflict;
import org.example.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository repository;
    @Autowired
    SuperMercadoService superMercadoService;

    public ProdutoDTO cadastroProduto(ProdutoDTO request) {
        Optional<Produto> produtoExiste = verificaCodigo(request.getCodigo());
        SuperMercado mercado = superMercadoService.buscarSupermercadoId(request.getIdSupermercado());
        if (produtoExiste.isEmpty()) {
            Produto produto = new Produto.ProdutoBuilder().
                    nome(request.getNome()).
                    codigo(request.getCodigo()).
                    marca(request.getMarca()).
                    quantidadeUnidade(request.getQuantidadeUnidade()).
                    superMercado(mercado).
                    valor(request.getValor()).
                    tipo(request.getTipo()).
                    build();
            repository.save(produto);
            return request;

        }
        throw new ExceptionConflict("Produto já cadastrado");

    }

    private Optional<Produto> verificaCodigo(String codigo) {
        Optional<Produto> produtoExiste = repository.findByCodigo(codigo);
        if (produtoExiste.isPresent()) {
            throw new ExceptionConflict("Produto já cadastrado");
        }
        return produtoExiste;
    }

    public List<ProdutoDTO> exibiProduto() {
        List<Produto> p = repository.findAll();
        if (p.isEmpty()) {
            throw new ExceptioNoContent("0 informações encontradas");
        }

        return p.stream()
                .map(produto ->
                        new ProdutoDTO.ProdutoDTOBuilder().
                                nome(produto.getNome()).
                                codigo(produto.getCodigo()).
                                marca(produto.getMarca()).
                                quantidadeUnidade(produto.getQuantidade()).
                                valor(produto.getValor()).
                                tipo(produto.getTipo()).
                                quantidade(produto.getQuantidade()).
                                build())
                .collect(Collectors.toList());
    }

    public RequestProdutoAtualizacao atualizaProduto(Long id, RequestProdutoAtualizacao request) {
        Optional<Produto> produto = repository.findById(id);
        if (produto.isEmpty()) {
            throw new ExceptioNoContent("Cliente nao encontrado");
        }
        Produto valoresAtualizar = repository.getReferenceById(id);
        Produto produtoAtualizado
                = new Produto.ProdutoBuilder().nome(valoresAtualizar.getNome())
                .id(valoresAtualizar.getId())
                .codigo(valoresAtualizar.getCodigo())
                .marca(valoresAtualizar.getMarca())
                .tipo(valoresAtualizar.getTipo())
                .superMercado(valoresAtualizar.getIdSupermercado()).build();


        produtoAtualizado.setValor(request.getValor());
        produtoAtualizado.setNome(request.getNome());
        produtoAtualizado.setQuantidade(request.getQuantidade());
        produtoAtualizado.setQuantidadeUnidade(request.getQuantidadeUnidade());
        repository.save(produtoAtualizado);
        return request;
    }

    public void deletarProduto(Long id) {
        if (repository.findById(id).isEmpty()) {
            throw new ExceptioNoContent("0 informações encontradas");
        }
        repository.deleteById(id);
    }
    public Produto buscarProdutoById(Long id){
        Optional<Produto> Produto = repository.findById(id);
        if(Produto.isPresent()){
            return repository.getReferenceById(id);
        }
        throw  new ExceptionConflict("Produto nao cadastrado");
    }
    public Produto retornaByCodigo(String id){
        Optional<Produto> produto = repository.findByCodigo(id);
        if(produto.isPresent()){
            return produto.get();
        }
        throw  new ExceptionConflict("Produto nao encontrado");
    }

}

