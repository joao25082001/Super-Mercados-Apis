package org.example.enums;

public enum TipoCaixa {


    PREFERENCIAL("caixa preferencial"),
    COMUM("caixa comumm"),
    TOTEM("totem");
    private String descricao;

    TipoCaixa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
