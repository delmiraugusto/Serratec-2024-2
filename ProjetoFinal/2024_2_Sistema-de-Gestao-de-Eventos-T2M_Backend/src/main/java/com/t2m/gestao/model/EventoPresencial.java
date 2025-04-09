package com.t2m.gestao.model;


import com.t2m.gestao.util.TratamentoDeErro;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



@Entity
@Table
public class EventoPresencial extends Evento {

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    @Column
    @NotNull
    @NotBlank(message = TratamentoDeErro.NotBlankMessage3)
    private String formatoEvento;

	@Column
    private Integer limitePublico;

    @Column
    private Boolean isHibrido;

    @Column
    private String linkHibrido;

    @Column
    private String plataforma;

    @Column
    private Integer limiteOnline;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getFormatoEvento() {
        return formatoEvento;
    }

    public void setFormatoEvento(String formatoEvento) {
        this.formatoEvento = formatoEvento;
    }

    public Integer getLimitePublico() {
        return limitePublico;
    }

    public void setLimitePublico(Integer limitePublico) {
        this.limitePublico = limitePublico;
    }

    public Boolean getHibrido() {
        return isHibrido;
    }

    public void setHibrido(Boolean hibrido) {
        isHibrido = hibrido;
    }

    public String getLinkHibrido() {
        return linkHibrido;
    }

    public void setLinkHibrido(String linkHibrido) {
        this.linkHibrido = linkHibrido;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Integer getLimiteOnline() {
        return limiteOnline;
    }

    public void setLimiteOnline(Integer limiteOnline) {
        this.limiteOnline = limiteOnline;
    }
}
