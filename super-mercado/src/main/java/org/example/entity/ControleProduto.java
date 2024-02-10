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
    private Produto idProduto;

    public ControleProduto(String dataVencimento, Lote idLote, Produto idProduto) {
        this.dataVencimento = dataVencimento;
        this.idLote = idLote;
        this.idProduto = idProduto;
    }

    public ControleProduto() {
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

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }
}
