package org.example.service;


import org.example.DTO.produto.ProdutoDTO;
import org.example.entity.Produto;
import org.example.entity.SuperMercado;
import org.example.exception.ExceptioNoContent;
import org.example.exception.ExceptionConflict;
import org.example.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
