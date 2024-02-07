package org.example.DTO.produto;

public class RequestProdutoAtualizacao {
    private String nome;
    private Double valor;
    private Integer quantidadeUnidade;
    private Integer quantidade;


    protected RequestProdutoAtualizacao() {
    }
    public static class RequestProdutoAtualizacaoBuilder{
        private RequestProdutoAtualizacao produtoDTO;

        public RequestProdutoAtualizacaoBuilder() {
            this.produtoDTO = new RequestProdutoAtualizacao();
        }
        public RequestProdutoAtualizacao.RequestProdutoAtualizacaoBuilder nome(String nome){
            produtoDTO.nome = nome;
            return this;
        }
        public RequestProdutoAtualizacao.RequestProdutoAtualizacaoBuilder valor(Double valor){
            produtoDTO.valor = valor;
            return this;
        }
        public RequestProdutoAtualizacao.RequestProdutoAtualizacaoBuilder quantidadeUnidade(Integer quantidadeUnidade){
            produtoDTO.quantidadeUnidade = quantidadeUnidade;
            return this;
        }

        public RequestProdutoAtualizacao.RequestProdutoAtualizacaoBuilder quantidade(Integer quantidade) {
            produtoDTO.quantidade = quantidade;
            return this;
        }

        public RequestProdutoAtualizacao build() {
            return this.produtoDTO;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}
