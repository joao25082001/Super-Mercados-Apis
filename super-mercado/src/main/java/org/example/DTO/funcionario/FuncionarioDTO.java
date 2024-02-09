package org.example.DTO.funcionario;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.stream.Collector;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class FuncionarioDTO {
    private Long id;
    private String cpf;
    private String nome;
    private String numeroCarteira;
    private Long idSupermercado;

    public FuncionarioDTO(String cpf, String nome, String numeroCarteira) {
        this.cpf = cpf;
        this.nome = nome;
        this.numeroCarteira = numeroCarteira;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroCarteira() {
        return numeroCarteira;
    }

    public void setNumeroCarteira(String numeroCarteira) {
        this.numeroCarteira = numeroCarteira;
    }

    public Long getIdSupermercado() {
        return idSupermercado;
    }

    public void setIdSupermercado(Long idSupermercado) {
        this.idSupermercado = idSupermercado;
    }


}
