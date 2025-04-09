package com.t2m.gestao.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "evento_id")
    private Evento evento;

    private String corporativeEmail;

    private boolean confirmado;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public String getCorporativeEmail() {
        return corporativeEmail;
    }

    public void setCorporativeEmail(String corporativeEmail) {
        this.corporativeEmail = corporativeEmail;
    }
}
