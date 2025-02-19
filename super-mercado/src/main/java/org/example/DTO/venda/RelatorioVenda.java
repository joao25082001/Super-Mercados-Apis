package org.example.DTO.venda;

import java.util.List;

public class RelatorioVenda {
    private List<RelatorioMes> relatorioMes;
    private Integer totalVendido;

    public RelatorioVenda(List<RelatorioMes> relatorioMes, Integer totalVendido) {
        this.relatorioMes = relatorioMes;
        this.totalVendido = totalVendido;
    }

    public List<RelatorioMes> getRelatorioMes() {
        return relatorioMes;
    }

    public void setRelatorioMes(List<RelatorioMes> relatorioMes) {
        this.relatorioMes = relatorioMes;
    }

    public Integer getTotalVendido() {
        return totalVendido;
    }

    public void setTotalVendido(Integer totalVendido) {
        this.totalVendido = totalVendido;
    }
}
