package org.example.DTO.cliente;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDTO {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String cep;
    private String mensagem;

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getCep() {
        return cep;
    }

    public String getMensagem() {
        return mensagem;
    }

    protected ClienteDTO() {
    }
    public static class ClienteDTObuilder{
        private ClienteDTO cliente;

        public ClienteDTObuilder() {
             cliente = new ClienteDTO();
        }
        public ClienteDTObuilder nome(String nome){
            cliente.nome = nome;
            return this;
        }
        public ClienteDTObuilder cpf(String cpf){
            cliente.cpf = cpf;
            return this;
        }
        public ClienteDTObuilder mensagem(String mensagem){
            cliente.mensagem = mensagem;
            return this;
        }
        public ClienteDTObuilder dataNascimento(String dataNascimento){
            cliente.dataNascimento = dataNascimento;
            return this;
        }

        public ClienteDTO build(){
            return this.cliente;

        }
    }
}
