package org.example.DTO.jornada;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JornadaDTO {
    private LocalDateTime horarioAbertura;
    private LocalDateTime horarioFechamento;
    private BigDecimal valorInicial;
    private BigDecimal valorFinal;
    private Integer caixa;
    private String cpfFuncionario;

    public JornadaDTO() {
    }

    public JornadaDTO(LocalDateTime horarioAbertura, BigDecimal valorInicial, Integer caixa, String cpfFuncionario) {
        this.horarioAbertura = horarioAbertura;
        this.valorInicial = valorInicial;
        this.caixa = caixa;
        this.cpfFuncionario = cpfFuncionario;
    }

    public JornadaDTO(LocalDateTime horarioFechamento, BigDecimal valorFinal, Integer caixa) {
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

    public BigDecimal getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(BigDecimal valorInicial) {
        this.valorInicial = valorInicial;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
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
