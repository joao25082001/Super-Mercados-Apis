package org.example.entity;

import jakarta.persistence.*;

@Entity
public class SuperMercado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_super_mercado")
    private Long id;
    private String nome;
    private String cnpj;
    private String email;
    protected SuperMercado() {
    }
    public static class SuperMercadoBuild{
        private SuperMercado superMercado;

        public SuperMercadoBuild(SuperMercado superMercado) {
            this.superMercado = superMercado;
        }
        public SuperMercado nome(String nome){
            superMercado.nome = nome;
            return superMercado;
        }
        public SuperMercado cnpj(String cnpj){
            superMercado.cnpj = cnpj;
            return superMercado;
        }
        public SuperMercado email(String email){
            superMercado.email = email;
            return superMercado;
        }
        public SuperMercado build() {
            return superMercado;
        }

    }

}
