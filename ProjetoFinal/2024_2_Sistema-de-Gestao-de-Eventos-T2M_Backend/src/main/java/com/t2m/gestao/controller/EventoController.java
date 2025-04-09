package com.t2m.gestao.controller;

import com.t2m.gestao.Dto.EventoPresencialDto;
import com.t2m.gestao.model.Evento;
import com.t2m.gestao.model.EventoOnline;
import com.t2m.gestao.model.EventoPresencial;
import com.t2m.gestao.service.EventoOnlineService;
import com.t2m.gestao.service.EventoPresencialService;
import com.t2m.gestao.service.NotificationService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoPresencialService eventoPresencialService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private EventoOnlineService eventoOnlineService;

    @PostMapping("/{eventoId}/detalhes")
    public ResponseEntity<EventoPresencial> adicionarDetalhesEventoPresencial(@PathVariable Long eventoId,
                                                                              @RequestParam String descricao,
                                                                              @RequestParam String topicos,
                                                                              @RequestParam(required = false)MultipartFile eventCover){
        try{
            byte [] foto = eventCover.getBytes();
            EventoPresencial evento = eventoPresencialService.salvarDetalhesEvento(eventoId, descricao, topicos, foto);
            return ResponseEntity.ok(evento);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/online/{eventoId}/detalhes")
    public ResponseEntity<?> adicionarDetalhesEventoOnline(@PathVariable Long eventoId,
                                                                      @RequestParam String descricao,
                                                                      @RequestParam String topicos,
                                                                      @RequestParam(required = false) MultipartFile eventCover) {
        try {
            byte [] foto = eventCover.getBytes();
            EventoOnline evento = eventoOnlineService.salvarDetalhesEvento(eventoId, descricao, topicos, foto);
            return ResponseEntity.ok(evento);
        }catch (Exception e){
            return ResponseEntity.ok(e);
        }
    }
    @GetMapping
    public ResponseEntity<?> listarTodosOsEventos() {
        try {

            List<EventoOnline> eventosOnline = eventoOnlineService.buscarTodosEventosOnline();
            List<EventoPresencialDto> eventosPresenciais = eventoPresencialService.obterTodosEventos();

            List<Object> todosEventos = new ArrayList<>();
            todosEventos.addAll(eventosOnline);
            todosEventos.addAll(eventosPresenciais);

            return ResponseEntity.ok(todosEventos);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Erro ao listar todos os eventos: " + e.getMessage());
        }
    }
    @GetMapping("/{eventoId}")
    public ResponseEntity<?> obterEventoPorId(@PathVariable Long eventoId) {
        try {
            if (eventoOnlineService.buscarEventoOnlinePorId(eventoId).isPresent()) {
                return ResponseEntity.ok("online");
            } else if (eventoPresencialService.obterEventoPorId(eventoId).isPresent()) {
                return ResponseEntity.ok("presencial");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento não encontrado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar tipo de evento: " + e.getMessage());
        }
    }


    @DeleteMapping("/{eventoId}")
    public ResponseEntity<?> excluirEvento(@PathVariable Long eventoId) {
        try{
            if(eventoOnlineService.buscarEventoOnlinePorId(eventoId).isPresent()){
                eventoOnlineService.deletarEventoOnline(eventoId);
                return ResponseEntity.noContent().build();
            } else if(eventoPresencialService.obterEventoPorId(eventoId).isPresent()) {
                eventoPresencialService.deletarEvento(eventoId);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{eventoId}/inscritos")
    public ResponseEntity<Integer> getTotalInscritos(@PathVariable Long eventoId){
        try{
            Optional<EventoOnline> eventoOnline = eventoOnlineService.buscarEventoOnlinePorId(eventoId);
            if(eventoOnline.isPresent()){
                int totalInscritos = eventoOnline.get().getInscricoes().size();
                return ResponseEntity.ok(totalInscritos);
            }

            Optional<EventoPresencialDto> eventoPresencial = eventoPresencialService.obterEventoPorId(eventoId);
            if (eventoPresencial.isPresent()) {
                int totalInscritos = eventoPresencial.get().totalInscritos();
                return ResponseEntity.ok(totalInscritos);
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(0);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0);
        }
    }
}
