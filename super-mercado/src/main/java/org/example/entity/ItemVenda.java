package org.example.entity;

import jakarta.persistence.*;

@Entity
public class ItemVenda {
    @Id
    @Column(name = "id_item_venda")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_controle_produto")
    private ControleProduto controleProduto;
    @ManyToOne
    @JoinColumn(name = "id_venda")
    private Venda venda;
}
