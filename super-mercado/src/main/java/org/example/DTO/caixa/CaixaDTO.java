package org.example.DTO.caixa;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.example.enums.TipoCaixa;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CaixaDTO {
    private Long id;
    private Integer numero;


    private TipoCaixa tipoCaixa;
    private Boolean status;

    private Long idSupermercado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public TipoCaixa getTipoCaixa() {
        return tipoCaixa;
    }

    public void setTipoCaixa(TipoCaixa tipoCaixa) {
        this.tipoCaixa = tipoCaixa;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getIdSupermercado() {
        return idSupermercado;
    }

    public void setIdSupermercado(Long idSupermercado) {
        this.idSupermercado = idSupermercado;
    }
}
