package org.example.entity;

import jakarta.persistence.*;

@Entity
public class Venda {
    @Id
    @GeneratedValue
    @Column(name = "id_venda")
    private Long id;
    private String dataHora;
    @ManyToOne
    @JoinColumn( name = "id_cliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn( name = "id_jornada")
    private Jornada jornada;

    public Venda() {
    }

    public Venda(String dataHora, Cliente cliente, Jornada jornada) {
        this.dataHora = dataHora;
        this.cliente = cliente;
        this.jornada = jornada;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
