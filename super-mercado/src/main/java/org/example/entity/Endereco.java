package org.example.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long id;
    private String cep;
    private String uf;
    private String logradouro;
    @ManyToOne
    @JoinColumn(name = "id_super_mercado")
    private SuperMercado idSupermercado;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente idCliente;

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public SuperMercado getIdSupermercado() {
        return idSupermercado;
    }

    public void setIdSupermercado(SuperMercado idSupermercado) {
        this.idSupermercado = idSupermercado;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", uf='" + uf + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", idSupermercado=" + idSupermercado +
                '}';
    }

    protected Endereco() {
    }
    public static class EnderecoBuild{
        private Endereco endereco;

        public EnderecoBuild(Endereco endereco) {
            this.endereco = endereco;
        }

        public EnderecoBuild() {
            this.endereco = new Endereco();
        }

        public Endereco.EnderecoBuild cep(String cep){
            endereco.cep = cep;
            return this;
        }
        public Endereco.EnderecoBuild uf(String  uf){
            endereco.uf = uf;
            return this;
        }
        public Endereco.EnderecoBuild logradouro(String logradouro){
            endereco.logradouro = logradouro;
            return this;
        }
        public Endereco.EnderecoBuild idSupermercado(SuperMercado idSupermercado){
            endereco.idSupermercado = idSupermercado;
            return this;
        }
        public Endereco build() {
            return endereco;
        }


    }
}
