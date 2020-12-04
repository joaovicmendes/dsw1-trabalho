package br.ufscar.dc.dsw.domain;

import java.util.Date;

public class Locacao {
    private Cliente c;
    private Locadora l;
    private Date dataReserva;

    public Locacao(Cliente c, Locadora l,  Date dataReserva) {
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

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Date getDataReserva() {
        return this.dataReserva;
    }
}
