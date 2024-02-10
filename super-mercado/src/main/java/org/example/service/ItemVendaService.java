package org.example.service;


import org.example.DTO.itemVenda.ItemVendaDTO;
import org.example.DTO.venda.ItensRetornoVendaDTO;
import org.example.entity.ItemVenda;
import org.example.entity.Produto;
import org.example.entity.Venda;
import org.example.exception.ExceptionConflict;
import org.example.repository.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemVendaService {

    @Autowired
    ItemVendaRepository itemVendaRepository;
    @Autowired
    VendaService vendaService;
    @Autowired
    ControleProdutoService controleService;
    @Autowired
    ProdutoService produtoService;

    public ItensRetornoVendaDTO cadastraCompra(ItemVendaDTO request) {
        Venda venda = vendaService.verificaVendaExiste(request.getVenda().getId());
        List<ItemVenda> itens = new ArrayList<>();
        List<Produto> produtos = new ArrayList<>();
        BigDecimal valorApagar = BigDecimal.ZERO;
        for (int i = 0; i < request.getControleProduto().size(); i++) {
            ItemVenda item = new ItemVenda();
            BigDecimal valorProduto =(controleService.buscaControleProdutoByCodigo(request.getControleProduto().get(i)).getIdProduto().getValor());
            item.setControleProduto(controleService.buscaControleProdutoByCodigo(request.getControleProduto().get(i)));
            item.setVenda(venda);
            itens.add(item);
            valorApagar = valorApagar.add(valorProduto);
            produtos.add(controleService.buscaControleProdutoByCodigo(request.getControleProduto().get(i)).getIdProduto());
        }
        itemVendaRepository.saveAll(itens);

        return new ItensRetornoVendaDTO(
                        itens.get(0).getVenda().getDataHora(),
                        venda.getJornada().getFuncionario().getCpf(),
                        produtos,valorApagar.setScale(2)
                        );



    }
}
