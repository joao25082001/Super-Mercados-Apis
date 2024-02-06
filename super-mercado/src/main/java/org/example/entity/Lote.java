package org.example.entity;

import jakarta.persistence.*;

@Entity
public class Lote {
    @Id
    @Column(name = "id_lote")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String dataCompra;
    private String quantidadeRecebida;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getQuantidadeRecebida() {
        return quantidadeRecebida;
    }

    public void setQuantidadeRecebida(String quantidadeRecebida) {
        this.quantidadeRecebida = quantidadeRecebida;
    }
}
