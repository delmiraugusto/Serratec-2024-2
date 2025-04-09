package com.t2m.gestao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String email;

    @NotNull
    @Column
    private String titulo;

    @NotNull
    @Column
    private String mensagem;


    private LocalDateTime timeStamp = LocalDateTime.now();

    @Column(name = "is_read")
    private Boolean isRead = false;

    public Notification(){

    }

    public Notification( String email, String titulo, String mensagem) {
        this.email = email;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.isRead = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    public @NotNull String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotNull String titulo) {
        this.titulo = titulo;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public @NotNull String getMensagem() {
        return mensagem;
    }

    public void setMensagem(@NotNull String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
