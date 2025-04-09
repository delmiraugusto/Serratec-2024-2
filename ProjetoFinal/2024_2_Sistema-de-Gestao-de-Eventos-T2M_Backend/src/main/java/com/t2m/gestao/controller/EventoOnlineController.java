package com.t2m.gestao.controller;

import com.t2m.gestao.model.EventoOnline;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import com.t2m.gestao.service.EventoOnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos-online")
public class EventoOnlineController {

    @Autowired
    private EventoOnlineService eventoOnlineService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar evento online", description = "Cria um novo evento online e o adiciona à lista de eventos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Evento criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na requisição."),
            @ApiResponse(responseCode = "401", description = "Erro de autenticação."),
            @ApiResponse(responseCode = "403", description = "Sem permissão para acessar este recurso.")
    })
    public ResponseEntity<EventoOnline> criarEventoOnline(@RequestBody EventoOnline eventoOnline) {
        EventoOnline eventoCriado = eventoOnlineService.criarEventoOnline(eventoOnline);
        return new ResponseEntity<>(eventoCriado, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Buscar todos os eventos online", description = "Retorna uma lista com todos os eventos online cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de eventos retornada com sucesso."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor.")
    })
    public ResponseEntity<List<EventoOnline>> buscarTodosEventosOnline() {
        List<EventoOnline> eventos = eventoOnlineService.buscarTodosEventosOnline();
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar evento online por ID", description = "Busca um evento online específico pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Evento encontrado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Evento não encontrado.")
    })
    public ResponseEntity<EventoOnline> buscarEventoOnlinePorId(@PathVariable Long id) {
        Optional<EventoOnline> evento = eventoOnlineService.buscarEventoOnlinePorId(id);
        return evento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/plataforma/{plataformaChamada}")
    @Operation(summary = "Buscar eventos por plataforma", description = "Retorna uma lista de eventos filtrados pela plataforma de chamada.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Eventos encontrados com sucesso."),
            @ApiResponse(responseCode = "404", description = "Nenhum evento encontrado para a plataforma especificada.")
    })
    public ResponseEntity<List<EventoOnline>> buscarPorPlataformaChamada(@PathVariable String plataformaChamada) {
        List<EventoOnline> eventos = eventoOnlineService.buscarPorPlataformaChamada(plataformaChamada);
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @GetMapping("/nome/{nomeEvento}")
    @Operation(summary = "Buscar eventos por nome", description = "Retorna uma lista de eventos filtrados pelo nome.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Eventos encontrados com sucesso."),
            @ApiResponse(responseCode = "404", description = "Nenhum evento encontrado com o nome especificado.")
    })
    public ResponseEntity<List<EventoOnline>> buscarPorNomeEvento(@PathVariable String nomeEvento) {
        List<EventoOnline> eventos = eventoOnlineService.buscarPorNomeEvento(nomeEvento);
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar evento online", description = "Atualiza os dados de um evento online existente pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Evento atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Evento não encontrado.")
    })
    public ResponseEntity<EventoOnline> atualizarEventoOnline(@PathVariable Long id, @RequestBody EventoOnline eventoOnline) {
        EventoOnline eventoAtualizado = eventoOnlineService.atualizarEventoOnline(id, eventoOnline);
        return eventoAtualizado != null ? new ResponseEntity<>(eventoAtualizado, HttpStatus.OK) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{eventoId}/online")
    public ResponseEntity<?> atualizarDetalhesOnline(@PathVariable Long eventoId, @RequestBody EventoOnline eventoOnline){
        try{
            EventoOnline eventoAtualizado = eventoOnlineService.atualizarDetalhesOnline(eventoId, eventoOnline);

            if (eventoAtualizado != null){
                return ResponseEntity.ok(eventoAtualizado);
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento Online não encontrado");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar evento online", description = "Remove um evento online existente pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Evento deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Evento não encontrado.")
    })
    public ResponseEntity<Void> deletarEventoOnline(@PathVariable Long id) {
        boolean deletado = eventoOnlineService.deletarEventoOnline(id);
        return deletado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
