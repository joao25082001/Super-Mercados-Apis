package org.example.DTO.produto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.example.entity.SuperMercado;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProdutoDTO {
    private String nome;
    private String tipo;
    private String marca;
    private String codigo;
    private BigDecimal valor;
    private Integer quantidadeUnidade;
    private Integer quantidade;

    private Long idSupermercado;

    protected ProdutoDTO() {
    }
    public static class ProdutoDTOBuilder{
        private ProdutoDTO produtoDTO;

        public ProdutoDTOBuilder() {
            this.produtoDTO = new ProdutoDTO();
        }
        public ProdutoDTOBuilder nome(String nome){
            produtoDTO.nome = nome;
            return this;
        }
        public ProdutoDTOBuilder tipo(String tipo){
            produtoDTO.tipo = tipo;
            return this;
        }
        public ProdutoDTOBuilder marca(String marca){
            produtoDTO.marca = marca;
            return this;
        }
        public ProdutoDTOBuilder codigo(String codigo){
            produtoDTO.codigo = codigo;
            return this;
        }
        public ProdutoDTOBuilder valor(BigDecimal valor){
            produtoDTO.valor = valor;
            return this;
        }
        public ProdutoDTOBuilder quantidadeUnidade(Integer quantidadeUnidade){
            produtoDTO.quantidadeUnidade = quantidadeUnidade;
            return this;
        }

        public ProdutoDTOBuilder quantidade(Integer quantidade) {
            produtoDTO.quantidade = quantidade;
            return this;
        }

        public ProdutoDTOBuilder superMercado(Long superMercado) {
            produtoDTO.idSupermercado = superMercado;
            return this;
        }
        public ProdutoDTO build() {
            return this.produtoDTO;
        }
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
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

    public Long getIdSupermercado() {
        return idSupermercado;
    }

    public void setIdSupermercado(Long idSupermercado) {
        this.idSupermercado = idSupermercado;
    }
}
