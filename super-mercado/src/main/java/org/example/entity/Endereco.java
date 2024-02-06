package org.example.entity;

import jakarta.persistence.*;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long id;
    private Integer numero;
    private String cep;
    private String uf;
    private String logradouro;
    @ManyToOne
    @JoinColumn(name = "id_super_mercado")
    private SuperMercado idSupermercado;

    protected Endereco() {
    }
    public static class EnderecoBuild{
        private Endereco endereco;

        public EnderecoBuild(Endereco endereco) {
            this.endereco = endereco;
        }
        public Endereco cep(String cep){
            endereco.cep = cep;
            return endereco;
        }
        public Endereco numero(Integer numero){
            endereco.numero = numero;
            return endereco;
        }
        public Endereco uf(String  uf){
            endereco.uf = uf;
            return endereco;
        }
        public Endereco logradouro(String logradouro){
            endereco.logradouro = logradouro;
            return endereco;
        }
        public Endereco idSupermercado(SuperMercado idSupermercado){
            endereco.idSupermercado = idSupermercado;
            return endereco;
        }
        public Endereco build() {
            return endereco;
        }


    }
}
