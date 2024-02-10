package org.example.DTO.venda;


import org.example.entity.Produto;

import java.math.BigDecimal;
import java.util.List;

public class ItensRetornoVendaDTO {


    private String dataHora;

    private String cliente;

    private String jornada;

    List<Produto> produtos;
    private BigDecimal valorTotal;

    public ItensRetornoVendaDTO(String dataHora, String jornada, List<Produto> produtos, BigDecimal valorTotal) {
        this.dataHora = dataHora;
        this.jornada = jornada;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
