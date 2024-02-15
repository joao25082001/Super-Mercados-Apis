package org.example.DTO.venda;

import org.example.entity.Caixa;
import org.example.entity.Venda;

import java.util.List;

public class ItemVendaExcel {
    private Venda venda;
    private List<String> controleProduto;
    private List<Integer> quantidadeProduto;
    private Caixa caixa;

    public ItemVendaExcel(Venda venda, List<String> controleProduto, List<Integer> quantidadeProduto, Caixa caixa) {
        this.venda = venda;
        this.controleProduto = controleProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.caixa = caixa;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public List<String> getControleProduto() {
        return controleProduto;
    }

    public void setControleProduto(List<String> controleProduto) {
        this.controleProduto = controleProduto;
    }

    public List<Integer> getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(List<Integer> quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }
}
