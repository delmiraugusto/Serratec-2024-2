package com.t2m.gestao.repository;

import com.t2m.gestao.model.EventoOnline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoOnlineRepository extends JpaRepository<EventoOnline, Long> {

    // Buscar Evento Online por Plataforma de Chamada
    List<EventoOnline> findByPlataformaChamada(String plataformaChamada);

    // Buscar Evento Online por Nome do Evento
    List<EventoOnline> findByNomeEventoContaining(String nomeEvento);
}
