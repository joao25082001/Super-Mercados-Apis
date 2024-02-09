package org.example.service;


import org.example.DTO.itemVenda.ItemVendaDTO;
import org.example.DTO.venda.ItensRetornoVendaDTO;
import org.example.entity.ItemVenda;
import org.example.entity.Produto;
import org.example.entity.Venda;
import org.example.repository.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public ItensRetornoVendaDTO cadastraCompra(ItemVendaDTO request) {
        Venda venda = vendaService.verificaVendaExiste(request.getVenda().getId());

        List<ItemVenda> itens = new ArrayList<>();
        List<Produto> produtos = new ArrayList<>();
        for (int i = 0; i < request.getControleProduto().size(); i++) {
            ItemVenda item = new ItemVenda();
            item.setVenda(venda);
            item.setControleProduto(controleService.buscaControleProdutoByCodigo(request.getControleProduto().get(i)));
            itens.add(item);
            produtos.add(controleService.buscaControleProdutoByCodigo(request.getControleProduto().get(i)).getIdProduto());
        }
        itemVendaRepository.saveAll(itens);

        return new ItensRetornoVendaDTO(
                        itens.get(0).getVenda().getDataHora(),
                        venda.getCliente().getCpf(),
                        venda.getJornada().getFuncionario().getCpf(),
                        produtos
                        );



    }
}
