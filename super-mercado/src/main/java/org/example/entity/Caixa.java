package org.example.entity;

import jakarta.persistence.*;
import org.example.enums.TipoCaixa;
@Entity
public class Caixa {
    @Id
    @Column(name = "id_caixa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;

    @Enumerated(EnumType.STRING)
    private TipoCaixa tipoCaixa;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "id_super_mercado")
    private SuperMercado idSupermercado;

    public Caixa() {
    }

    public Caixa(Long id, Integer numero, TipoCaixa tipoCaixa, Boolean status, SuperMercado idSupermercado) {
        this.id = id;
        this.numero = numero;
        this.tipoCaixa = tipoCaixa;
        this.status = status;
        this.idSupermercado = idSupermercado;
    }

    public Caixa( Integer numero, TipoCaixa tipoCaixa, Boolean status, SuperMercado idSupermercado) {
        this.numero = numero;
        this.tipoCaixa = tipoCaixa;
        this.status = status;
        this.idSupermercado = idSupermercado;
    }

    public SuperMercado getIdSupermercado() {
        return idSupermercado;
    }

    public void setIdSupermercado(SuperMercado idSupermercado) {
        this.idSupermercado = idSupermercado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public TipoCaixa getTipoCaixa() {
        return tipoCaixa;
    }

    public void setTipoCaixa(TipoCaixa tipoCaixa) {
        this.tipoCaixa = tipoCaixa;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
