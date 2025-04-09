package com.t2m.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.t2m.gestao.model.EventoPresencial;

import java.util.List;
import java.util.Optional;

public interface EventoPresencialRepository extends JpaRepository<EventoPresencial, Long> {


    @Query("SELECT e FROM EventoPresencial  e WHERE LOWER(e.nomeEvento) LIKE LOWER(CONCAT('%', :nome, '%'))")
    
    List<EventoPresencial> BuscarEventoPorNome(@Param("nome") String nome);
    
}
