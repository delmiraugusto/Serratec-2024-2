package com.t2m.gestao.controller;

import com.t2m.gestao.model.Evento;
import com.t2m.gestao.repository.EventoRepository;
import com.t2m.gestao.service.InscricaoService;
import com.t2m.gestao.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscricoes")
public class InscricaoController {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private InscricaoService inscricaoService;

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/{eventoId}")
    public ResponseEntity<String> inscrever(@PathVariable Long eventoId, @RequestParam String corporativeEmail) {
        String response = inscricaoService.inscreverNoEvento(eventoId, corporativeEmail);
        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new IllegalArgumentException("Evento não encontrado com o ID: " + eventoId));

        notificationService.sendNotification(corporativeEmail, "Inscrição confirmada", "Obrigado por ser inscrever no evento " + evento.getNomeEvento());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{eventoId}/verificar")
    public ResponseEntity<Boolean> verificarInscricao(
            @PathVariable Long eventoId,
            @RequestParam String corporativeEmail) {
        boolean inscrito = inscricaoService.verificarInscricao(eventoId, corporativeEmail);
        return ResponseEntity.ok(inscrito);
    }

    @GetMapping("/usuario")
    public ResponseEntity<List<Evento>> listarInscricoesPorUsuario(@RequestParam String email) {
        List<Evento> eventos = inscricaoService.listarInscricoesPorEmail(email);
        return ResponseEntity.ok(eventos);
    }

    @DeleteMapping("/{eventoId}")
    public ResponseEntity<String> cancelarInscricao(
            @PathVariable Long eventoId,
            @RequestParam String corporativeEmail) {

        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new IllegalArgumentException("Evento não encontrado com o ID: " + eventoId));

        String response = inscricaoService.cancelarInscricao(eventoId, corporativeEmail);
        notificationService.sendNotification(corporativeEmail, "Inscrição Cancelada", "Sua inscrição no evento: " + evento.getNomeEvento() + " foi cancelada com sucesso");
        return ResponseEntity.ok(response);
    }
}
