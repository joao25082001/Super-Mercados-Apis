package org.example.DTO.itemVenda;

import org.example.entity.ControleProduto;
import org.example.entity.Venda;

import java.util.ArrayList;
import java.util.List;

public class ItemVendaDTO {
    private Venda venda;
    private List<String> controleProduto;

    public ItemVendaDTO(Venda venda, List<String> controleProduto) {
        this.venda = venda;
        this.controleProduto = controleProduto;
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
}
