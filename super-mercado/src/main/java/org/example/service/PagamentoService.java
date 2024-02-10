package org.example.service;

import org.example.DTO.pagamento.PagamentoDTO;
import org.example.entity.Pagamento;
import org.example.entity.Produto;
import org.example.entity.Venda;
import org.example.exception.ExceptionConflict;
import org.example.projection.RecuperaProdutosVenda;
import org.example.projection.VerificaValorTotalPagamentoProjection;
import org.example.repository.ItemVendaRepository;
import org.example.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PagamentoService {
    @Autowired
    VendaService vendaService;
    @Autowired
    ProdutoService produtoService;
    @Autowired
    PagamentoRepository repository;
    @Autowired
    ItemVendaRepository itemVendaRepository;

    @Transactional
    public PagamentoDTO cadastraPagamento(PagamentoDTO request) throws ExceptionConflict {
        Venda venda = vendaService.verificaVendaExiste(request.getVenda());
        VerificaValorTotalPagamentoProjection valorTotalRecuperado = repository.verificaValorTotalPagamento(venda.getId());
        BigDecimal valorTotalCompra = new BigDecimal(String.valueOf(valorTotalRecuperado.getValor()));
        List<RecuperaProdutosVenda> codigos = repository.recuperaCodigos(venda.getId());
        for (RecuperaProdutosVenda c : codigos) {
            Produto p = produtoService.retornaByCodigo(c.getCodigo());
            produtoService.diminuiUnidade(p);
        }
        if (valorTotalCompra.compareTo(request.getValorTotal()) > 0) {
            throw new ExceptionConflict("valor de pagamento insuficiente");
        }
        itemVendaRepository.deleteAllByVenda(venda);
        Pagamento pagamento = new Pagamento(request.getPagamento(), valorTotalCompra, venda);
        repository.save(pagamento);
        BigDecimal troco = request.getValorTotal().subtract(valorTotalCompra);
        request.setTroco(String.valueOf(troco));
        return request;

    }
}
