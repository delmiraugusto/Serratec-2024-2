package com.t2m.gestao.repository;

import com.t2m.gestao.model.Midia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MidiaRepository extends JpaRepository<Midia, Long> {
    List<Midia> findByEventoId(Long eventoId);
}
