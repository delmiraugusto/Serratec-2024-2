package com.t2m.gestao.controller;


import com.t2m.gestao.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.t2m.gestao.Dto.EventoPresencialDto;
import com.t2m.gestao.service.EventoPresencialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
public class EventoPresencialController {

    @Autowired
    private EventoPresencialService eventoPresencialService;

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    @Operation(summary = "Obter todos os eventos presenciais", description = "Retorna uma lista de todos os eventos presenciais cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de eventos retornada com sucesso."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.")
    })
    public ResponseEntity<List<EventoPresencialDto>> obterTodosEventos() {
        return ResponseEntity.ok(eventoPresencialService.obterTodosEventos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter evento presencial por ID", description = "Retorna um evento presencial específico pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Evento retornado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Evento não encontrado.")
    })
    public ResponseEntity<EventoPresencialDto> obterEventoPorId(@PathVariable Long id) {
        return eventoPresencialService.obterEventoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    @Operation(summary = "Buscar eventos por nome", description = "Retorna uma lista de eventos presenciais filtrados pelo nome.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Eventos encontrados com sucesso."),
            @ApiResponse(responseCode = "404", description = "Nenhum evento encontrado com o nome especificado.")
    })
    public ResponseEntity<List<EventoPresencialDto>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(eventoPresencialService.obterEventosPorNome(nome));
    }

    @PostMapping
    @Operation(summary = "Criar evento presencial", description = "Cria um novo evento presencial e o adiciona à lista de eventos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Evento criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.")
    })
    public ResponseEntity<EventoPresencialDto> criarEvento(@RequestBody EventoPresencialDto eventoDto) {
        EventoPresencialDto eventoCriado = eventoPresencialService.criarEvento(eventoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventoCriado);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar evento presencial", description = "Atualiza os dados de um evento presencial existente pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Evento atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Evento não encontrado."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos na requisição.")
    })
    public ResponseEntity<EventoPresencialDto> atualizarEvento(@PathVariable Long id, @RequestBody EventoPresencialDto eventoDto) {
        return eventoPresencialService.atualizarEvento(id, eventoDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{eventoId}/presencial")
    public ResponseEntity<?> atualizaDetalhesEventoPresencial(@PathVariable Long eventoId,
                                                              @RequestBody EventoPresencialDto eventoDto){
        try{
            Optional<EventoPresencialDto> eventoAtualizado = eventoPresencialService.atualizarDetalhesPresencial(eventoId, eventoDto);
            if (eventoAtualizado.isPresent()){
                return ResponseEntity.ok(eventoAtualizado.get());
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento presencial não encontrado");
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar evento" + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar evento presencial", description = "Remove um evento presencial existente pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Evento deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Evento não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.")
    })
    public ResponseEntity<Void> deletarEvento(@PathVariable Long id) {
        if (eventoPresencialService.deletarEvento(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
