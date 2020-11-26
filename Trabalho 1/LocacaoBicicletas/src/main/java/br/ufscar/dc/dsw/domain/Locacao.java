package br.ufscar.dc.dsw.domain;

import java.time.LocalDateTime;

public class Locacao {
    private Cliente c;
    private Locadora l;
    private LocalDateTime data;

    public Locacao(Cliente c, Locadora l,  LocalDateTime data) {
        this.setCliente(c);
        this.setLocadora(l);
        this.setData(data);
    }

    public void setCliente(Cliente c) {
        this.c = c;
    }

    public Cliente getCliente() {
        return this.c;
    }

    public void setLocadora(Locadora l) {
        this.l = l;
    }

    public Locadora getLocadora() {
        return this.l;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public LocalDateTime getData() {
        return this.data;
    }
}
