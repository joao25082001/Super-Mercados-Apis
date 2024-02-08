package org.example.service;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.example.DTO.itemVenda.ItemVendaDTO;
import org.example.DTO.produto.ProdutoDTO;
import org.example.entity.Produto;
import org.example.entity.Venda;
import org.example.repository.ControleProdutoRepository;
import org.example.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemVendaService {
    @Autowired
    VendaRepository vendaRepository;
    @Autowired
    ControleProdutoRepository controleProdutoRepository;
    @Autowired
    VendaService vendaService;
    @Autowired
    ProdutoService produtoService;
   /* public ItemVendaDTO cadastraCompra(ItemVendaDTO request) {
    for(int i = 0; i < request.getControleProduto().size();i++){
        produtoService.buscarProdutoById(request.getControleProduto().get(i).getId_produto().getId());
    }
        Venda venda = vendaService.verificaVendaExiste(request.getVenda().getId());

    }*/
}
