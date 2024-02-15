package org.example.service;

import org.example.DTO.pagamento.PagamentoDTO;
import org.example.DTO.produto.ProdutoBaixoEstoque;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public PagamentoDTO cadastraPagamento(PagamentoDTO request) throws ExceptionConflict {

        Venda venda = vendaService.verificaVendaExiste(request.getVenda());
        Optional<Pagamento> pagamento1 = repository.findByVenda(venda);
        if(pagamento1.isPresent()){
            throw  new ExceptionConflict("já foi cadastrado um pagamento para essa compra");
        }
        Boolean baixaDemanda = false;
        List<ProdutoBaixoEstoque> baixoEstoques = new ArrayList<>();
        List<Integer> quantidadeAtuais = new ArrayList<>();
        VerificaValorTotalPagamentoProjection valorTotalRecuperado = repository.verificaValorTotalPagamento(venda.getId());
        BigDecimal valorTotalCompra = new BigDecimal(String.valueOf(valorTotalRecuperado.getValor()));
        List<RecuperaProdutosVenda> codigos = repository.recuperaCodigos(venda.getId());
        List<RecuperaProdutosVenda> codigosAgrupados = repository.recuperaCodigosAgrupados(venda.getId());
        for (RecuperaProdutosVenda c : codigosAgrupados) {
            Produto p = produtoService.retornaByCodigo(c.getCodigo());
            quantidadeAtuais.add(p.getQuantidade());
        }
            for (RecuperaProdutosVenda c : codigos) {
            Produto p = produtoService.retornaByCodigo(c.getCodigo());
            if(p.getQuantidade() == 0){
                itemVendaRepository.deleteAllByVenda(venda.getId());
                throw new ExceptionConflict("quantidade divergente no produto " + p.getNome() + " do codigo: " + p.getCodigo());
            }
            produtoService.diminuiUnidade(p);

        }
        for (int i = 0; i < quantidadeAtuais.size();i++) {
            Produto p = produtoService.retornaByCodigo(codigos.get(i).getCodigo());
            if( p.getQuantidade() <= quantidadeAtuais.get(i) * 0.25){
            baixoEstoques.add(new ProdutoBaixoEstoque(p.getNome(),p.getQuantidade()));
            baixaDemanda = true;
            }
        }
        if (valorTotalCompra.compareTo(request.getValorTotal()) > 0) {
            throw new ExceptionConflict("valor de pagamento insuficiente");
        }
        if(baixaDemanda){
            vendaService.sendEmail(baixoEstoques,venda.getJornada().getCaixa().getIdSupermercado().getEmail());
            request.setProdutoBaixoEstoqueList(baixoEstoques);
        }
        Pagamento pagamento = new Pagamento(request.getPagamento(), valorTotalCompra, venda);
        repository.save(pagamento);
        BigDecimal troco = request.getValorTotal().subtract(valorTotalCompra);
        request.setTroco(String.valueOf(troco));
        return request;

    }

}
