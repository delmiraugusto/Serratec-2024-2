package com.t2m.gestao.service;

import com.t2m.gestao.model.Evento;
import com.t2m.gestao.model.Inscricao;
import com.t2m.gestao.repository.EventoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InscricaoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> listarInscricoesPorEmail(String corporativeEmail) {
        return eventoRepository.findAll().stream()
                .filter(evento -> evento.getInscricoes().stream()
                        .anyMatch(inscricao -> inscricao.getCorporativeEmail().equals(corporativeEmail)))
                .collect(Collectors.toList());
    }

    @Transactional
    public String inscreverNoEvento(Long eventoId, String corporativeEmail) {
        Optional<Evento> optionalEvento = eventoRepository.findById(eventoId);

        if (optionalEvento.isEmpty()) {
            return "Evento não encontrado!";
        }

        Evento evento = optionalEvento.get();

        boolean jaInscrito = evento.getInscricoes().stream()
                .anyMatch(inscricao -> inscricao.getCorporativeEmail().equals(corporativeEmail));

        if (jaInscrito) {
            return "Usuário já inscrito neste evento!";
        }

        Inscricao inscricao = new Inscricao();
        inscricao.setCorporativeEmail(corporativeEmail);
        inscricao.setConfirmado(false);

        evento.adicionarInscricao(inscricao);
        eventoRepository.save(evento);

        return "Inscrição realizada com sucesso!";
    }

    public boolean verificarInscricao(Long eventoId, String corporativeEmail) {
        Optional<Evento> optionalEvento = eventoRepository.findById(eventoId);

        if (optionalEvento.isEmpty()) {
            return false;
        }

        Evento evento = optionalEvento.get();

        return evento.getInscricoes().stream()
                .anyMatch(inscricao -> inscricao.getCorporativeEmail().equals(corporativeEmail));
    }

    @Transactional
    public String cancelarInscricao(Long eventoId, String corporativeEmail) {
        Optional<Evento> optionalEvento = eventoRepository.findById(eventoId);

        if (optionalEvento.isEmpty()) {
            return "Evento não encontrado!";
        }

        Evento evento = optionalEvento.get();

        Optional<Inscricao> inscricaoOptional = evento.getInscricoes().stream()
                .filter(inscricao -> inscricao.getCorporativeEmail().equals(corporativeEmail))
                .findFirst();

        if (inscricaoOptional.isEmpty()) {
            return "Usuário não está inscrito neste evento!";
        }

        evento.removerInscricao(inscricaoOptional.get());
        eventoRepository.save(evento);

        return "Inscrição cancelada com sucesso!";
    }
}