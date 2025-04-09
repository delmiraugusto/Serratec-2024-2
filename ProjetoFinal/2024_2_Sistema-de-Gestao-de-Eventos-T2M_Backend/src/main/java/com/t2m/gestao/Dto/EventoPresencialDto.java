package com.t2m.gestao.Dto;

import com.t2m.gestao.model.EventoPresencial;

import java.time.LocalDateTime;
import java.util.Base64;

public record EventoPresencialDto(Long id, String nomeEvento, LocalDateTime dataHora,
                                  String duracaoEvento, int limitePublico, String formatoEvento,
                                  Boolean isHibrido, String linkHibrido, String plataforma, Integer limiteOnline,
                                  String rua, String cidade, String uf,
                                  String cep, String bairro, String complemento, String numero, String descricao, String topicos, String foto,
                                  Integer totalInscritos) {


    public EventoPresencial toEntity() {
        EventoPresencial evento = new EventoPresencial();
        evento.setNomeEvento(this.nomeEvento);
        evento.setDataHora(this.dataHora);
        evento.setDuracaoEvento(this.duracaoEvento);
        evento.setLimitePublico(this.limitePublico);
        evento.setFormatoEvento(this.formatoEvento);
        evento.setHibrido(this.isHibrido);
        evento.setLinkHibrido(this.linkHibrido);
        evento.setPlataforma(this.plataforma);
        evento.setLimiteOnline(this.limiteOnline);
        return evento;
    }

    public static EventoPresencialDto toDto(EventoPresencial evento) {
        String foto = evento.getFoto() != null ? Base64.getEncoder().encodeToString(evento.getFoto()): null;
        return new EventoPresencialDto(
                evento.getId(),
                evento.getNomeEvento(),
                evento.getDataHora(),
                evento.getDuracaoEvento(),
                evento.getLimitePublico(),
                evento.getFormatoEvento(),
                evento.getHibrido(),
                evento.getLinkHibrido(),
                evento.getPlataforma(),
                evento.getLimiteOnline(),
                evento.getEndereco() != null ? evento.getEndereco().getRua() : null,
                evento.getEndereco() != null ? evento.getEndereco().getCidade() : null,
                evento.getEndereco() != null ? evento.getEndereco().getUf() : null,
                evento.getEndereco() != null ? evento.getEndereco().getCep() : null,
                evento.getEndereco() != null ? evento.getEndereco().getBairro() : null,
                evento.getEndereco() != null ? evento.getEndereco().getComplemento() : null,
                evento.getEndereco() != null ? evento.getEndereco().getNumero() : null,
                evento.getDescricao(),
                evento.getTopicos(),
                foto,
                evento.getInscricoes() != null ? evento.getInscricoes().size() : 0
        );
    }

}
