package com.t2m.gestao.model;

import jakarta.persistence.*;

@Entity
public class Midia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @Lob
    private byte[] midias;

    @Column
    @Lob
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public byte[] getMidias() {
        return midias;
    }

    public void setMidias(byte[] midias) {
        this.midias = midias;
    }
}
