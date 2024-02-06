package org.example.entity;

import jakarta.persistence.*;

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

}
