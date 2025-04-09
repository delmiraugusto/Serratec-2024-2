package com.t2m.gestao.controller;

import com.t2m.gestao.Dto.EnderecoDto;
import com.t2m.gestao.model.Endereco;
import com.t2m.gestao.service.EnderecoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    @Operation(summary = "Criar um novo endereço", description = "Cria um novo endereço e retorna o endereço criado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Endereço criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.")
    })
    public ResponseEntity<EnderecoDto> criarEndereco(@RequestBody EnderecoDto enderecoDto) {
        Endereco enderecoCriado = enderecoService.criarEndereco(enderecoDto.toEntity());
        return new ResponseEntity<>(EnderecoDto.toDto(enderecoCriado), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retornar o endereço pelo Id", description = "Dado um determinado número de id, será retornado o endereço.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereço encontrado com sucesso."),
            @ApiResponse(responseCode = "401", description = "Erro de autenticação."),
            @ApiResponse(responseCode = "403", description = "Não há permissão para acessar o recurso."),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado com o id fornecido.")
    })
    public ResponseEntity<EnderecoDto> buscarEnderecoPorId(@PathVariable Long id) {
        return enderecoService.buscarEnderecoPorId(id)
                .map(endereco -> ResponseEntity.ok(EnderecoDto.toDto(endereco)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar o endereço pelo Id", description = "Dado um id, será atualizado o endereço existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso."),
            @ApiResponse(responseCode = "401", description = "Erro de autenticação."),
            @ApiResponse(responseCode = "403", description = "Não há permissão para acessar o recurso."),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado para atualização.")
    })
    public ResponseEntity<EnderecoDto> atualizarEndereco(@PathVariable Long id, @RequestBody EnderecoDto enderecoDto) {
        return enderecoService.atualizarEndereco(id, enderecoDto.toEntity())
                .map(endereco -> ResponseEntity.ok(EnderecoDto.toDto(endereco)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir endereço pelo id", description = "Dado um id, o endereço será excluído.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Endereço excluído com sucesso."),
            @ApiResponse(responseCode = "401", description = "Erro de autenticação."),
            @ApiResponse(responseCode = "403", description = "Não há permissão para acessar o recurso."),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado para exclusão.")
    })
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
        if (enderecoService.deletarEndereco(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
