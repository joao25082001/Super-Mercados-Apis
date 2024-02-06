package org.example.entity;

import jakarta.persistence.*;
import jdk.jfr.Name;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private Long id;
    private String cpf;
    private String numeroCarteira;
    @ManyToOne
    @JoinColumn(name = "id_super_mercado")
    private SuperMercado idSupermercado;

    protected Funcionario() {

    }
    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", numeroCarteira='" + numeroCarteira + '\'' +
                ", idSupermercado=" + idSupermercado +
                '}';
    }

    public static class FuncionarioBuilder {
        private Funcionario funcionario;

        public FuncionarioBuilder() {
            funcionario = new Funcionario();
        }

        public FuncionarioBuilder cpf(String cpf) {
            funcionario.cpf = cpf;
            return this;
        }

        public FuncionarioBuilder carteiraTrabalho(String numeroCarteira) {
            funcionario.numeroCarteira = numeroCarteira;
            return this;
        }

        public FuncionarioBuilder superMercado(SuperMercado superMercado) {
            funcionario.idSupermercado = superMercado;
            return this;
        }

        public Funcionario build() {
            return funcionario;
        }

    }
}
