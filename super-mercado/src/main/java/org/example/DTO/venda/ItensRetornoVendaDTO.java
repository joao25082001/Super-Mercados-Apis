package org.example.DTO.venda;

import jakarta.persistence.*;
import org.example.entity.Cliente;
import org.example.entity.Jornada;
import org.example.entity.Produto;

import java.util.List;

public class ItensRetornoVendaDTO {


    private String dataHora;

    private String cliente;

    private String jornada;

    List<Produto> produtos;

    public ItensRetornoVendaDTO(String dataHora, String cliente, String jornada, List<Produto> produtos) {
        this.dataHora = dataHora;
        this.cliente = cliente;
        this.jornada = jornada;
        this.produtos = produtos;
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
