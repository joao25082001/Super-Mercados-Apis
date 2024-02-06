package org.example.entity;

import jakarta.persistence.*;

@Entity
public class Venda {
    @Id
    @GeneratedValue
    @Column(name = "id_venda")
    private Long id;
    private String dataHora;
    @ManyToOne
    @JoinColumn( name = "id_cliente")
    private Cliente cliente;
}
