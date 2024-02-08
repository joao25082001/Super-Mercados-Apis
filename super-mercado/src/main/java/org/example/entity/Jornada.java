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

    public Jornada(LocalDateTime horarioAbertura, Double valorInicial, Caixa caixa, Funcionario funcionario) {
        this.horarioAbertura = horarioAbertura;
        this.valorInicial = valorInicial;
        this.caixa = caixa;
        this.funcionario = funcionario;
    }

    public Jornada() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getHorarioAbertura() {
        return horarioAbertura;
    }

    public void setHorarioAbertura(LocalDateTime horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
    }

    public LocalDateTime getHorarioFechamento() {
        return horarioFechamento;
    }

    public void setHorarioFechamento(LocalDateTime horarioFechamento) {
        this.horarioFechamento = horarioFechamento;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
