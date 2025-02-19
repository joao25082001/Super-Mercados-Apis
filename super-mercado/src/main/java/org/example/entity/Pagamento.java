package org.example.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private Long id;
    private String pagamento;
    private BigDecimal valorTotal;
    @ManyToOne
    @JoinColumn(name = "id_venda")
    private Venda venda;

    public Pagamento(String pagamento, BigDecimal valorTotal, Venda venda) {
        this.pagamento = pagamento;
        this.valorTotal = valorTotal;
        this.venda = venda;
    }

    public Pagamento() {
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

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
}
