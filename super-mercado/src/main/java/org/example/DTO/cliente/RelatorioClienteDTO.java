package org.example.DTO.cliente;

import org.example.DTO.produto.ProdutoDTO;
import org.example.entity.Cliente;
import org.example.entity.Endereco;
import org.example.entity.Produto;

import java.util.List;

public class RelatorioClienteDTO {
    private ProdutoDTO produto;
    private Integer quantidadeVendida;
    private Cliente clientes;
    private Endereco endereco;



    public RelatorioClienteDTO(ProdutoDTO produto,  Cliente clientes, Endereco endereco,Integer quantidadeVendida) {
        this.produto = produto;
        this.quantidadeVendida = quantidadeVendida;
        this.clientes = clientes;
        this.endereco = endereco;
    }

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }

    public Integer getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(Integer quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public Cliente getClientes() {
        return clientes;
    }

    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
