package com.t2m.gestao.model;


import com.t2m.gestao.util.TratamentoDeErro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table
public class EventoOnline extends Evento {

    @Column
    private String plataformaChamada;

    @Column
    private String linkChamada;

    @Column
    private Integer limitePublico;


    public EventoOnline() {
        super();
    }

    public EventoOnline(Long id, String nomeEvento, LocalDateTime dataHora,
                        String duracaoEvento,
                        String plataformaChamada, String linkChamada, Integer limitePublico) {
        super(id, nomeEvento, dataHora, duracaoEvento);
        this.plataformaChamada = plataformaChamada;
        this.linkChamada = linkChamada;
        this.limitePublico = limitePublico;
    }
    public String getPlataformaChamada() {
        return plataformaChamada;
    }
    public void setPlataformaChamada(String plataformaChamada) {
        this.plataformaChamada = plataformaChamada;
    }
    public String getLinkChamada() {
        return linkChamada;
    }

    public void setLinkChamada(String linkChamada) {
        this.linkChamada = linkChamada;
    }

    public Integer getLimitePublico() {
        return limitePublico;
    }

    public void setLimitePublico(Integer limitePublico) {
        this.limitePublico = limitePublico;
    }
    @Override
    public String toString() {
        return "EventoOnline [plataformaChamada=" + plataformaChamada + ", linkChamada=" + linkChamada + ", "
                + "Evento [nomeEvento=" + getNomeEvento() + ", data=" + getDataHora() + "]]";
    }
}
