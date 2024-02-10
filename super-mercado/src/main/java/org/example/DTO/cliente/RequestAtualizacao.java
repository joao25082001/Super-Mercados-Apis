package org.example.DTO.cliente;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestAtualizacao {
    private String nome;
    private String dataNascimento;

    protected RequestAtualizacao() {
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
}
