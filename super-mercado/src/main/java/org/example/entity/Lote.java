package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Lote {
    @Id
    @Column(name = "id_lote")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String dataCompra;
    private Integer quantidadeRecebida;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<ControleProduto> controle;


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

    public Integer getQuantidadeRecebida() {
        return quantidadeRecebida;
    }

    public void setQuantidadeRecebida(Integer quantidadeRecebida) {
        this.quantidadeRecebida = quantidadeRecebida;
    }
}
