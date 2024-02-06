package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Jornada {
    @Id
    @Column(name = "id_jornada")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime horarioAbertura;
    private LocalDateTime horarioFechamento;
    private Double valorInicial;
    private Double valorFinal;
    @ManyToOne
    @JoinColumn(name = "id_caixa")
    private Caixa caixa;
    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

}
