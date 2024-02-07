package org.example.DTO.cliente;


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
