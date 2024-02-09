package org.example.entity;

import jakarta.persistence.*;

@Entity
public class ItemVenda {
    @Id
    @Column(name = "id_item_venda")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_controle_produto")
    private ControleProduto controleProduto;
    @ManyToOne
    @JoinColumn(name = "id_venda")
    private Venda venda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ControleProduto getControleProduto() {
        return controleProduto;
    }

    public void setControleProduto(ControleProduto controleProduto) {
        this.controleProduto = controleProduto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
}
