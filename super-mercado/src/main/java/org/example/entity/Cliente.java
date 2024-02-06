package org.example.entity;

import jakarta.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue
    @Column(name = "id_cliente")
    private Long id;
    private String nome;
    private String cpf;

}
