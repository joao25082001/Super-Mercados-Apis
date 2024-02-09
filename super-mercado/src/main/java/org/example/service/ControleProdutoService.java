package org.example.service;

import org.example.DTO.controleProduto.ControleProdutoDTO;
import org.example.DTO.produto.ProdutoDTO;
import org.example.entity.ControleProduto;
import org.example.entity.Lote;
import org.example.entity.Produto;
import org.example.entity.SuperMercado;
import org.example.repository.ControleProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ControleProdutoService {
    @Autowired
    ProdutoService produtoService;
    @Autowired
    LoteService loteService;
    @Autowired
    ControleProdutoRepository repository;


    public ControleProduto cadastroControle(ControleProdutoDTO request) {
        Produto produto = produtoService.buscarProdutoById(request.getId_produto());
        Lote lote = loteService.buscarLoteById(request.getIdLote());
        ControleProduto controleProduto = new ControleProduto(request.getDataVencimento(),lote,produto);
        repository.save(controleProduto);
        return controleProduto;
    }
    public ControleProduto buscaControleProdutoByCodigo(String request) {
        Produto produto = produtoService.retornaByCodigo(request);
        List<ControleProduto> controle = repository.findByIdProduto(produto);
        return  controle.get(0);
    }



}
