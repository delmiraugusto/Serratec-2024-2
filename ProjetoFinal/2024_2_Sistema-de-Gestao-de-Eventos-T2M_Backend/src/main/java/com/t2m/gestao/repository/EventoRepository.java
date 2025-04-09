package com.t2m.gestao.repository;

import com.t2m.gestao.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    Evento findById(long id);
}
