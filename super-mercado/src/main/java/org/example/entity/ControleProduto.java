package org.example.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class ControleProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_controle_produto")
    private Long id;
    private String dataVencimento;
    @ManyToOne
    @JoinColumn(name = "id_lote")
    private Lote idLote;
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto id_produto;

    public ControleProduto(String dataVencimento, Lote idLote, Produto id_produto) {
        this.dataVencimento = dataVencimento;
        this.idLote = idLote;
        this.id_produto = id_produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Lote getIdLote() {
        return idLote;
    }

    public void setIdLote(Lote idLote) {
        this.idLote = idLote;
    }

    public Produto getId_produto() {
        return id_produto;
    }

    public void setId_produto(Produto id_produto) {
        this.id_produto = id_produto;
    }
}
