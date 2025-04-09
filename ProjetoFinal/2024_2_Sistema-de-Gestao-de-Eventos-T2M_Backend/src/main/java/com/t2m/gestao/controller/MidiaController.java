package com.t2m.gestao.controller;

import com.t2m.gestao.model.Evento;
import com.t2m.gestao.model.Midia;
import com.t2m.gestao.repository.EventoRepository;
import com.t2m.gestao.service.MidiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/midias")
public class MidiaController {

    @Autowired
    private MidiaService midiaService;
    @Autowired
    private EventoRepository eventoRepository;

    @PostMapping("/{eventoId}")
    public List<Midia> salvarMidias(@PathVariable Long eventoId, @RequestParam MultipartFile[] midias) {
         return midiaService.salvarMidiasPorEvento(midias, eventoId);
    }

    @GetMapping("/{eventoId}")
    public List<Midia> buscarMidiasPorEvento(@PathVariable Long eventoId) {
        return midiaService.buscarMidiasPorEvento(eventoId);
    }

    @PostMapping("/{eventoId}/addUrl")
    public ResponseEntity<String> adicionarUrl(@PathVariable Long eventoId, @RequestParam String url) {
        return midiaService.adicionarUrl(eventoId, url);
    }

    @DeleteMapping("/{midiaId}")
    public ResponseEntity<String> deletarMidia(@PathVariable Long midiaId) {
        return midiaService.deletarMidia(midiaId);
    }

    @GetMapping("/{eventoId}/urls")
    public ResponseEntity<List<String>> buscarUrlsPorEvento(@PathVariable Long eventoId) {
        List<String> urls = midiaService.buscarUrlsPorEvento(eventoId);
        return ResponseEntity.ok(urls);  // Retorna as URLs encontradas no evento
    }
}
