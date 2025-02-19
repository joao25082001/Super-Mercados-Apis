package org.example.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
public class NotaFiscal {
    @Id
    @GeneratedValue
    @Column(name = "id_nota_fiscal")
    private Long id;
    private String codNota;
    private LocalDate emissao;
    private BigDecimal valorTotal;
    @ManyToOne
    @JoinColumn(name = "id_jornada")
    private Jornada jornada;
    @ManyToOne
    @JoinColumn(name = "id_venda")
    private Venda venda;


}
