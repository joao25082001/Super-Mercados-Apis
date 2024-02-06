package org.example.enums;

public enum TipoCaixa {


    PREFERENCIAL("preferencial"),
    COMUM("comumm"),
    TOTEM("totem"),
    RAPIDO("caixa_rapido");
    private String descricao;

    TipoCaixa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
