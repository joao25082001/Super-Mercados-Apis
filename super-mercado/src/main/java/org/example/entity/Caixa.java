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
    private TipoCaixa tipoCaixa;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "id_super_mercado")
    private SuperMercado idSupermercado;
}
