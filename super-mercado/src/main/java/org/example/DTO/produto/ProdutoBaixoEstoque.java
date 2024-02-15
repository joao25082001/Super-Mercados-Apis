package org.example.DTO.produto;

public class ProdutoBaixoEstoque {
    private String nome;
    private Integer quantidade;

    public ProdutoBaixoEstoque(String nome, Integer quantide) {
        this.nome = nome;
        this.quantidade = quantide;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantide(Integer quantide) {
        this.quantidade = quantide;
    }

    @Override
    public String toString() {
        return "ProdutoBaixoEstoque{" +
                "nome='" + nome + '\'' +
                ", quantide=" + quantidade +
                '}';
    }
}
