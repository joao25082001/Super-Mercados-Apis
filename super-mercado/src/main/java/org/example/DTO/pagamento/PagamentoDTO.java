package org.example.DTO.pagamento;

import jakarta.persistence.*;
import org.example.entity.Venda;

import java.math.BigDecimal;

public class PagamentoDTO {

    private String pagamento;
    private BigDecimal valorTotal;
    private Long venda;
    private  String troco;

    public PagamentoDTO(String pagamento, BigDecimal valorTotal, Long venda) {
        this.pagamento = pagamento;
        this.valorTotal = valorTotal;
        this.venda = venda;
    }

    public String getTroco() {
        return troco;
    }

    public void setTroco(String troco) {
        this.troco = troco;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Long getVenda() {
        return venda;
    }

    public void setVenda(Long venda) {
        this.venda = venda;
    }
}
