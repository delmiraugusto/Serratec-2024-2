package com.t2m.gestao.service;

import com.t2m.gestao.model.Evento;
import com.t2m.gestao.model.Midia;
import com.t2m.gestao.repository.EventoRepository;
import com.t2m.gestao.repository.MidiaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MidiaService {

    @Autowired
    private MidiaRepository midiaRepository;

    @Autowired
    private EventoRepository eventoRepository;

    @Transactional
    public List<Midia> buscarMidiasPorEvento(Long eventoId) {
        return midiaRepository.findByEventoId(eventoId);
    }

    @Transactional
    public List<Midia> salvarMidiasPorEvento(MultipartFile[] midias, Long eventoId) {
        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado com ID: " + eventoId));

        List<Midia> midiasList = new ArrayList<>();

        for (MultipartFile midia : midias) {
            Midia m = new Midia();
            m.setEvento(evento);
            try {
                byte[] file = midia.getBytes();
                m.setMidias(file);
                midiasList.add(m);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        midiaRepository.saveAll(midiasList);
        return midiasList;
    }

    public ResponseEntity<String> adicionarUrl(@PathVariable Long eventoId, @RequestParam String url) {
        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado com ID: " + eventoId));

        Midia midia = new Midia();
        midia.setEvento(evento);
        midia.setUrl(url);

        midiaRepository.save(midia);
        return ResponseEntity.ok("Url adicionada");
    }

    public ResponseEntity<String> deletarMidia(Long midiaId) {
        if (midiaRepository.existsById(midiaId)) {
            midiaRepository.deleteById(midiaId);
            return ResponseEntity.ok("Mídia excluída com sucesso.");
        } else {
            return ResponseEntity.status(404).body("Mídia não encontrada.");
        }
    }

    @Transactional
    public List<String> buscarUrlsPorEvento(Long eventoId) {
        List<Midia> midias = midiaRepository.findByEventoId(eventoId);
        return midias.stream()
                .map(Midia::getUrl)
                .collect(Collectors.toList());
    }
}
