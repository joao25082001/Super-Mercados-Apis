package org.example.DTO.venda;

import org.example.entity.Produto;

import java.util.List;

public class RelatorioMes {
    private String cpfs;
    private String produtos;
    private Integer compraDia;
    private String data;


    public RelatorioMes(String cpfs, String produtos, Integer compraDia, String data) {
        this.cpfs = cpfs;
        this.produtos = produtos;
        this.compraDia = compraDia;
        this.data = data;
    }

    public String getCpfs() {
        return cpfs;
    }

    public void setCpfs(String cpfs) {
        this.cpfs = cpfs;
    }

    public String getProdutos() {
        return produtos;
    }

    public void setProdutos(String produtos) {
        this.produtos = produtos;
    }

    public Integer getCompraDia() {
        return compraDia;
    }

    public void setCompraDia(Integer compraDia) {
        this.compraDia = compraDia;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


}
