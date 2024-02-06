package org.example.entity;

import jakarta.persistence.*;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id;
    private String tipo;
    private String marca;
    private String codigo;
    private Double valor;
    private Integer quantidadeUnidade;
    private Integer quantidade;
    @ManyToOne
    @JoinColumn(name = "id_super_mercado")
    private SuperMercado idSupermercado;




}
