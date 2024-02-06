package org.example.entity;

import jakarta.persistence.*;

@Entity
public class Lote {
    @Id
    @Column(name = "id_lote")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String dataCompra;
    private String quantidadeRecebida;

}
