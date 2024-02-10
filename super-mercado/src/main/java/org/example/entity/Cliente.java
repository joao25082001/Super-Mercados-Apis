package org.example.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;
    private String nome;
    private String cpf;
    private String dataNascimento;

    protected Cliente() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public static class Clientebuilder {
        private Cliente cliente;

        public Clientebuilder() {
            cliente = new Cliente();
        }
        public Cliente.Clientebuilder nome(String nome){
            cliente.nome = nome;
            return this;
        }
        public Cliente.Clientebuilder cpf(String cpf){
            cliente.cpf = cpf;
            return this;
        }
        public Cliente.Clientebuilder dataNascimento(String dataNascimento){
            cliente.dataNascimento = dataNascimento;
            return this;
        }

        public Cliente build(){
            return this.cliente;

        }
    }

}
