package org.example.entity;

import jakarta.persistence.*;
import org.example.DTO.produto.ProdutoDTO;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id;
    private String nome;
    private String tipo;
    private String marca;
    private String codigo;
    private Double valor;
    private Integer quantidadeUnidade;
    private Integer quantidade;
    @ManyToOne
    @JoinColumn(name = "id_super_mercado")
    private SuperMercado idSupermercado;

    protected Produto() {
    }
    public static class ProdutoBuilder{
        private Produto produto;

        public ProdutoBuilder() {
            produto = new Produto();

        }
        public ProdutoBuilder id(Long id){
            produto.id = id;
            return this;
        }

        public ProdutoBuilder nome(String nome){
            produto.nome = nome;
            return this;
        }
        public ProdutoBuilder tipo(String tipo){
            produto.tipo = tipo;
            return this;
        }
        public ProdutoBuilder marca(String marca){
            produto.marca = marca;
            return this;
        }
        public ProdutoBuilder codigo(String codigo){
            produto.codigo = codigo;
            return this;
        }
        public ProdutoBuilder valor(Double valor){
            produto.valor = valor;
            return this;
        }
        public ProdutoBuilder quantidadeUnidade(Integer quantidadeUnidade){
            produto.quantidadeUnidade = quantidadeUnidade;
            return this;
        }

        public ProdutoBuilder quantidade(Integer quantidade) {
            produto.quantidade = quantidade;
            return this;
        }

        public ProdutoBuilder superMercado(SuperMercado superMercado) {
            produto.idSupermercado = superMercado;
            return this;
        }
        public Produto build() {
            return this.produto;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidadeUnidade() {
        return quantidadeUnidade;
    }

    public void setQuantidadeUnidade(Integer quantidadeUnidade) {
        this.quantidadeUnidade = quantidadeUnidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public SuperMercado getIdSupermercado() {
        return idSupermercado;
    }

    public void setIdSupermercado(SuperMercado idSupermercado) {
        this.idSupermercado = idSupermercado;
    }
}
