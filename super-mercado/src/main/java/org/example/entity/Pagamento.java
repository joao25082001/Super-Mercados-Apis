package org.example.entity;

import jakarta.persistence.*;

@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private Long id;
    private String pagamento;
    private Double valorTotal;
    @ManyToOne
    @JoinColumn(name = "id_venda")
    private Venda venda;
}
