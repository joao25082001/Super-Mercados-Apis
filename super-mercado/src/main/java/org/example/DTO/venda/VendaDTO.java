package org.example.DTO.venda;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import org.example.entity.Cliente;
import org.example.entity.Jornada;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VendaDTO {

    private String dataHora;

    private Cliente cliente;

    private Integer caixa;

    public VendaDTO() {
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getCaixa() {
        return caixa;
    }

    public void setCaixa(Integer caixa) {
        this.caixa = caixa;
    }
}
