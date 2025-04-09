package com.t2m.gestao.service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import com.t2m.gestao.model.Endereco;
import com.t2m.gestao.model.EventoPresencial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2m.gestao.Dto.EventoPresencialDto;
import com.t2m.gestao.repository.EventoPresencialRepository;

@Service
public class EventoPresencialService {

    @Autowired
    private EventoPresencialRepository eventoPresencialRepository;

    public List<EventoPresencialDto> obterTodosEventos() {
        return eventoPresencialRepository.findAll()
                .stream()
                .map(EventoPresencialDto::toDto)
                .toList();
    }
    public Optional<EventoPresencialDto> obterEventoPorId(Long id) {
        return eventoPresencialRepository.findById(id)
                .map(EventoPresencialDto::toDto);
    }
    public List<EventoPresencialDto> obterEventosPorNome(String nome) {
        return eventoPresencialRepository.BuscarEventoPorNome(nome)
                .stream()
                .map(EventoPresencialDto::toDto)
                .toList();
    }
    public EventoPresencialDto criarEvento(EventoPresencialDto eventoDto) {
        Endereco endereco = new Endereco();
        endereco.setRua(eventoDto.rua());
        endereco.setCidade(eventoDto.cidade());
        endereco.setUf(eventoDto.uf());
        endereco.setCep(eventoDto.cep());
        endereco.setBairro(eventoDto.bairro());
        endereco.setComplemento(eventoDto.complemento());
        endereco.setNumero(eventoDto.numero());

        EventoPresencial evento = eventoDto.toEntity();
        evento.setEndereco(endereco);

        EventoPresencial eventoSalvo = eventoPresencialRepository.save(evento);
        return EventoPresencialDto.toDto(eventoSalvo);
    }

    public EventoPresencial salvarDetalhesEvento(Long eventoId, String descricao, String topicos, byte[] foto){
        EventoPresencial evento = eventoPresencialRepository.findById(eventoId)
                .orElseThrow(()-> new RuntimeException("Evento não encontrado"));

        evento.setDescricao(descricao);
        evento.setTopicos(topicos);
        evento.setFoto(foto);
        return eventoPresencialRepository.save(evento);
    }

    public Optional<EventoPresencialDto> atualizarEvento(Long id, EventoPresencialDto eventoDto) {
        Optional<EventoPresencial> eventoExistente = eventoPresencialRepository.findById(id);
        if (eventoExistente.isPresent()){
            var evento = eventoExistente.get();
            evento.setId(id);
            evento.setNomeEvento(eventoDto.nomeEvento());
            evento.setDataHora(eventoDto.dataHora());
            evento.setDuracaoEvento(eventoDto.duracaoEvento());
            evento.setLimitePublico(eventoDto.limitePublico());
            evento.setFormatoEvento(eventoDto.formatoEvento());
            evento.setHibrido(eventoDto.isHibrido());
            evento.setLinkHibrido(eventoDto.linkHibrido());
            evento.setPlataforma(eventoDto.plataforma());
            evento.setLimiteOnline(eventoDto.limiteOnline());
            evento.getEndereco().setRua(eventoDto.rua());
            evento.getEndereco().setCidade(eventoDto.cidade());
            evento.getEndereco().setUf(eventoDto.uf());
            evento.getEndereco().setCep(eventoDto.cep());
            evento.getEndereco().setBairro(eventoDto.bairro());
            evento.getEndereco().setComplemento(eventoDto.complemento());
            evento.getEndereco().setNumero(eventoDto.numero());
            eventoPresencialRepository.save(evento);
            return Optional.of(EventoPresencialDto.toDto(evento));
        }
        return Optional.empty();
    }

    public Optional<EventoPresencialDto> atualizarDetalhesPresencial(Long id, EventoPresencialDto eventoPresencialDto){
        Optional <EventoPresencial> eventoExistente = eventoPresencialRepository.findById(id);

        if (eventoExistente.isPresent()) {
            EventoPresencial eventoAtual = eventoExistente.get();
            if (eventoPresencialDto.descricao() != null) {
                eventoAtual.setDescricao(eventoPresencialDto.descricao());
            }
            if (eventoPresencialDto.topicos() != null) {
                eventoAtual.setTopicos(eventoPresencialDto.topicos());
            }
            if (eventoPresencialDto.foto() != null) {
                byte[] fotoBytes = Base64.getDecoder().decode(eventoPresencialDto.foto());
                eventoAtual.setFoto(fotoBytes);
            }

            eventoPresencialRepository.save(eventoAtual);
            return Optional.of(EventoPresencialDto.toDto(eventoAtual));
        }
        return Optional.empty();
    }

    public boolean deletarEvento(Long id) {
        if (eventoPresencialRepository.existsById(id)) {
            eventoPresencialRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
