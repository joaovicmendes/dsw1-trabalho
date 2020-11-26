package br.ufscar.dc.dsw.domain;

import java.time.LocalDateTime;

public class Locacao {
    private Cliente c;
    private Locadora l;
    private LocalDateTime dataReserva;

    public Locacao(Cliente c, Locadora l,  LocalDateTime dataReserva) {
        this.setCliente(c);
        this.setLocadora(l);
        this.setDataReserva(dataReserva);
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

    public void setDataReserva(LocalDateTime dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalDateTime getDataReserva() {
        return this.dataReserva;
    }
}
