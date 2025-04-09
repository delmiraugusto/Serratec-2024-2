package com.t2m.gestao.service;

import com.t2m.gestao.model.Evento;
import com.t2m.gestao.model.EventoOnline;
import com.t2m.gestao.repository.EventoOnlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class EventoOnlineService {

    @Autowired
    private EventoOnlineRepository eventoOnlineRepository;


    public EventoOnline salvarDetalhesEvento (Long eventoId, String descricao, String topicos, byte[] foto ){
        EventoOnline evento = eventoOnlineRepository.findById(eventoId)
                .orElseThrow(()-> new RuntimeException("Evento não encontrado"));

        evento.setDescricao(descricao);
        evento.setTopicos(topicos);
        evento.setFoto(foto);

        return eventoOnlineRepository.save(evento);
    }

    public EventoOnline criarEventoOnline(EventoOnline eventoOnline) {
        return eventoOnlineRepository.save(eventoOnline);
    }

    public List<EventoOnline> buscarTodosEventosOnline() {
        return eventoOnlineRepository.findAll();
    }

    public Optional<EventoOnline> buscarEventoOnlinePorId(Long id) {
        return eventoOnlineRepository.findById(id);
    }

    public List<EventoOnline> buscarPorPlataformaChamada(String plataformaChamada) {
        return eventoOnlineRepository.findByPlataformaChamada(plataformaChamada);
    }

    public List<EventoOnline> buscarPorNomeEvento(String nomeEvento) {
        return eventoOnlineRepository.findByNomeEventoContaining(nomeEvento);
    }

    public EventoOnline atualizarEventoOnline(Long id, EventoOnline eventoOnline) {
        Optional<EventoOnline> eventoExistente = eventoOnlineRepository.findById(id);
        if (eventoExistente.isPresent()) {
            EventoOnline evento = eventoExistente.get();

            if (eventoOnline.getNomeEvento() != null) {
                evento.setNomeEvento(eventoOnline.getNomeEvento());
            }
            if (eventoOnline.getDataHora() != null) {
                evento.setDataHora(eventoOnline.getDataHora());
            }
            if (eventoOnline.getPlataformaChamada() != null) {
                evento.setPlataformaChamada(eventoOnline.getPlataformaChamada());
            }
            if (eventoOnline.getLinkChamada() != null) {
                evento.setLinkChamada(eventoOnline.getLinkChamada());
            }
            if (eventoOnline.getLimitePublico() != null){
                evento.setLimitePublico(eventoOnline.getLimitePublico());
            }

            return eventoOnlineRepository.save(evento);
        }
        return null;
    }


    public EventoOnline atualizarDetalhesOnline(Long eventoId, EventoOnline eventoOnline){
        Optional<EventoOnline> eventoExistente = eventoOnlineRepository.findById(eventoId);

        if (eventoExistente.isPresent()) {
            EventoOnline eventoAtual = eventoExistente.get();

            if (eventoOnline.getDescricao() != null) {
                eventoAtual.setDescricao(eventoOnline.getDescricao());
            }
            if (eventoOnline.getTopicos() != null) {
                eventoAtual.setTopicos(eventoOnline.getTopicos());
            }
            if (eventoOnline.getFoto() != null) {
                byte[] fotoBytes = eventoOnline.getFoto();
                eventoAtual.setFoto(fotoBytes);
            }
            return eventoOnlineRepository.save(eventoAtual);
        }

        return null;
    }

    public boolean deletarEventoOnline(Long id) {
        if (eventoOnlineRepository.existsById(id)) {
            eventoOnlineRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
