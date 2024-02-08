package org.example.DTO.jornada;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JornadaDTO {
    private LocalDateTime horarioAbertura;
    private LocalDateTime horarioFechamento;
    private Double valorInicial;
    private Double valorFinal;
    private Integer caixa;
    private String cpfFuncionario;

    public JornadaDTO() {
    }

    public JornadaDTO(LocalDateTime horarioAbertura, Double valorInicial, Integer caixa, String cpfFuncionario) {
        this.horarioAbertura = horarioAbertura;
        this.valorInicial = valorInicial;
        this.caixa = caixa;
        this.cpfFuncionario = cpfFuncionario;
    }

    public JornadaDTO(LocalDateTime horarioFechamento, Double valorFinal, Integer caixa) {
        this.horarioFechamento = horarioFechamento;
        this.valorFinal = valorFinal;
        this.caixa = caixa;
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

    public Integer getCaixa() {
        return caixa;
    }

    public void setCaixa(Integer caixa) {
        this.caixa = caixa;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }
}
